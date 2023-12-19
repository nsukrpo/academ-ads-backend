package nsukrpo.backend.repository.user;

import nsukrpo.backend.model.entities.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRep extends CrudRepository<User, Long> {
}
