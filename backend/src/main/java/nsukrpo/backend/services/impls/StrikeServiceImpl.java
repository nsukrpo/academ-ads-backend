package nsukrpo.backend.services.impls;

import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.StrikeDto;
import nsukrpo.backend.model.dtos.StrikePostDto;
import nsukrpo.backend.model.entities.moderation.Strike;
import nsukrpo.backend.repository.moderation.StrikeRep;
import nsukrpo.backend.services.StrikeService;
import nsukrpo.backend.services.impls.utils.UserManager;
import nsukrpo.backend.services.impls.utils.impls.StrikeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StrikeServiceImpl implements StrikeService {
    private final StrikeRep strikeRep;
    private final UserManager userManager;
    private final StrikeManagerImpl strikeManager;

    @Autowired
    public StrikeServiceImpl(StrikeRep strikeRep, UserManager manager, StrikeManagerImpl strikeManager){
        this.strikeRep = strikeRep;
        this.userManager = manager;
        this.strikeManager = strikeManager;
    }

    @Override
    public StrikeDto getStrike(Long id) {
        Strike strike = strikeManager.getStrikeOrThrow(id);
        return new StrikeDto(strike);
    }

    @Override
    public IdDto putStrike(Long id, StrikeDto body) { //ещё не работает
        Strike strike = strikeManager.getStrikeOrThrow(id);
        Optional.ofNullable(body.getUser()).map(userManager::getUserOrThrow).ifPresent(strike::setUser);
        Optional.ofNullable(body.getReason()).map(StrikeReason::valueOf).map(strikeManager::getReasonOrThrow).ifPresent(strike::setReason);
        strikeRep.save(strike);
        return new IdDto(strike.getId());
    }

    @Override
    public List<StrikeDto> getUserStrikes(Long user_id) {
        var strikes = strikeRep.findAll();
        ArrayList<StrikeDto> userStrikes = new ArrayList<>();
        for (var strike: strikes)
            if (user_id.equals(strike.getUser().getId()))
                userStrikes.add(new StrikeDto(strike));
        return userStrikes;
    }

    @Override
    public IdDto postStrike(StrikePostDto body) {
        Strike strike = Strike.builder()
                .user(userManager.getUserOrThrow(body.getUserId()))
                .reason(strikeManager.getReasonOrThrow(StrikeReason.valueOf(body.getReason())))
                .build();
        strike = strikeRep.save(strike);

        /*
        TODO
        Когда будет эндпоинт для блокировок, реализовать
         проверку достижения пользователем граничного числа предупреждений и, при необходимости,
         вынесение перманентной блокировки*/

        return new IdDto(strike.getId());
    }
}
