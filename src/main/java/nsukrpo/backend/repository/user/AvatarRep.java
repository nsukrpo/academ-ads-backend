package nsukrpo.backend.repository.user;

import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.entities.user.UserAvatar;
import org.springframework.data.repository.CrudRepository;

public interface AvatarRep extends CrudRepository<UserAvatar, Long> {
}
