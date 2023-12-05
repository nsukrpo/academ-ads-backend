package nsukrpo.backend.repository.user;

import nsukrpo.backend.model.entities.user.UserAvatar;
import org.springframework.data.repository.CrudRepository;

public interface UserAvatarRep extends CrudRepository<UserAvatar, Long> {
}
