package nsukrpo.backend.services.impls.utils;

import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.model.entities.moderation.Reason;
import nsukrpo.backend.model.entities.moderation.Strike;

public interface StrikeManager {
    Strike getStrikeOrThrow(Long id);

    Reason getReasonOrThrow(StrikeReason reason);
}
