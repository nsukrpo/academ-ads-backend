package nsukrpo.backend.services.impls.utils;

import nsukrpo.backend.config.BlockReason;
import nsukrpo.backend.model.entities.moderation.Block;
import nsukrpo.backend.model.entities.moderation.Reason;
import nsukrpo.backend.model.entities.user.User;

public interface BlockingManager {
    Block getBlockOrThrow(Long id);
    Reason getReasonOrThrow(BlockReason reason);
    void getPermanentBlock(User user);
}
