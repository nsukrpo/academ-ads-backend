package nsukrpo.backend.services.impls.utils.impls;

import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.model.entities.moderation.Reason;
import nsukrpo.backend.model.entities.moderation.Strike;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.moderation.ReasonRep;
import nsukrpo.backend.repository.moderation.StrikeRep;
import nsukrpo.backend.services.impls.utils.StrikeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StrikeManagerImpl implements StrikeManager {
    private final StrikeRep strikeRep;
    private final ReasonRep reasonRep;
    private final EnumMap<StrikeReason, Reason> reasons = new EnumMap<>(StrikeReason.class);

    @Autowired
    public StrikeManagerImpl(StrikeRep strikeRep, ReasonRep reasonRep){
        this.strikeRep = strikeRep;
        this.reasonRep = reasonRep;
    }
    @Override
    public Strike getStrikeOrThrow(Long id) {
        return strikeRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find strike: " + id));
    }

    @Override
    public Reason getReasonOrThrow(StrikeReason reason) {
        return reasons.computeIfAbsent(reason, t -> {
            synchronized (reasons){
                return reasons.containsKey(t) ?
                        reasons.get(t) :
                        reasonRep.findByName(t.name()).orElseThrow(() -> new NotFoundException("Couldn't find strike: " + t.name()));
            }
        });
    }
}
