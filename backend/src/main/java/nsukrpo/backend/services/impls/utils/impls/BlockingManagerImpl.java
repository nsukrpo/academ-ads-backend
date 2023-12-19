package nsukrpo.backend.services.impls.utils.impls;

import nsukrpo.backend.config.BlockReason;
import nsukrpo.backend.model.entities.moderation.Block;
import nsukrpo.backend.model.entities.moderation.Reason;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.moderation.BlockingRep;
import nsukrpo.backend.repository.moderation.ReasonRep;
import nsukrpo.backend.services.impls.utils.BlockingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.EnumMap;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BlockingManagerImpl implements BlockingManager {
    private final BlockingRep blockingRep;
    private final ReasonRep reasonRep;
    private final EnumMap<BlockReason, Reason> reasons = new EnumMap<>(BlockReason.class);

    @Autowired
    public BlockingManagerImpl(BlockingRep blockingRep, ReasonRep reasonRep){
        this.blockingRep = blockingRep;
        this.reasonRep = reasonRep;
    }
    @Override
    public Block getBlockOrThrow(Long id){
        return blockingRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find blocking: " + id));
    }

    @Override
    public Reason getReasonOrThrow(BlockReason reason) {
        return reasons.computeIfAbsent(reason, t -> {
            synchronized (reasons){
                return reasons.containsKey(t) ?
                        reasons.get(t) :
                        reasonRep.findByName(t.name()).orElseThrow(() -> new NotFoundException("Couldn't find block: " + t.name()));
            }
        });
    }

    @Override
    public void getPermanentBlock(User user) {
        Block block = Block.builder()
                .user(user)
                .reason(getReasonOrThrow(BlockReason.STRIKES_LIMIT))
                .time(Integer.MAX_VALUE)
                .blockDate(new Timestamp(System.currentTimeMillis()))
                .build();
        blockingRep.save(block);
    }
}
