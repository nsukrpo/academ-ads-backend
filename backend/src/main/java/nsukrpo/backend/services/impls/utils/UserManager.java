package nsukrpo.backend.services.impls.utils;

import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.entities.user.UserAvatar;
import nsukrpo.backend.model.entities.user.UserType;

public interface UserManager {
    UserType getUserTypeOrThrow(nsukrpo.backend.config.UserType type);
    User getUserOrThrow(Long id);
    UserAvatar getAvatarOrThrow(Long id);
}
