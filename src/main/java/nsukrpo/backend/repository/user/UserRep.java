package nsukrpo.backend.repository.user;

import nsukrpo.backend.model.entities.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRep extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
