package nsukrpo.backend.services.impls;

import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.config.constants.SystemConstants;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.StrikeDto;
import nsukrpo.backend.model.dtos.StrikePostDto;
import nsukrpo.backend.model.entities.moderation.Strike;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.repository.moderation.StrikeRep;
import nsukrpo.backend.services.StrikeService;
import nsukrpo.backend.services.impls.utils.BlockingManager;
import nsukrpo.backend.services.impls.utils.StrikeManager;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StrikeServiceImpl implements StrikeService {
    private final StrikeRep strikeRep;
    private final StrikeManager strikeManager;
    private final UserManager userManager;
    private final BlockingManager blockingManager;

    @Autowired
    public StrikeServiceImpl(StrikeRep strikeRep, StrikeManager strikeManager, UserManager manager, BlockingManager blockingManager){
        this.strikeRep = strikeRep;
        this.strikeManager = strikeManager;
        this.userManager = manager;
        this.blockingManager = blockingManager;
    }

    @Override
    public StrikeDto getStrike(Long id) {
        Strike strike = strikeManager.getStrikeOrThrow(id);
        return new StrikeDto(strike);
    }

    @Override
    public IdDto putStrike(Long id, StrikeDto body) {
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
        User user = userManager.getUserOrThrow(body.getUserId());
        Strike strike = Strike.builder()
                .user(user)
                .reason(strikeManager.getReasonOrThrow(StrikeReason.valueOf(body.getReason())))
                .build();
        strike = strikeRep.save(strike);

        if (getUserStrikes(body.getUserId()).size() >= SystemConstants.STRIKES_LIMIT)
            blockingManager.getPermanentBlock(user);

        return new IdDto(strike.getId());
    }
}
