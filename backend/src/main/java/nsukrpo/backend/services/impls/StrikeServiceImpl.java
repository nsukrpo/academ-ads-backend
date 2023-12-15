package nsukrpo.backend.services.impls;

import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.StrikeDto;
import nsukrpo.backend.model.dtos.StrikePostDto;
import nsukrpo.backend.model.entities.moderation.Strike;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.moderation.ReasonRep;
import nsukrpo.backend.repository.moderation.StrikeRep;
import nsukrpo.backend.services.StrikeService;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StrikeServiceImpl implements StrikeService {
    private final StrikeRep strikeRep;
    private final ReasonRep reasonRep;
    private final UserManager userManager;

    @Autowired
    public StrikeServiceImpl(StrikeRep strikeRep, ReasonRep reasonRep, UserManager manager){
        this.strikeRep = strikeRep;
        this.reasonRep = reasonRep;
        this.userManager = manager;
    }

    @Override
    public StrikeDto getStrike(Long id) {
        Strike strike = getStrikeOrThrow(id);
        return new StrikeDto(strike);
    }

    @Override
    public IdDto putStrike(Long id, StrikeDto body) {
        Strike strike = getStrikeOrThrow(id);
        Optional.ofNullable(body.getUser()).map(userManager::getUserOrThrow).ifPresent(strike::setUser);
        Optional.ofNullable(body.getReason()).map(reasonRep::findByName).ifPresent(strike::setReason);
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
                .reason(reasonRep.findByName(body.getReason()))
                .build();
        strike = strikeRep.save(strike);

        /*
        TODO
        Когда будет эндпоинт для блокировок, реализовать
         проверку достижения пользователем граничного числа предупреждений и, при необходимости,
         вынесение перманентной блокировки
         */
        return new IdDto(strike.getId());
    }

    private Strike getStrikeOrThrow(Long id){
        return strikeRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find strike: " + id));
    }
}
