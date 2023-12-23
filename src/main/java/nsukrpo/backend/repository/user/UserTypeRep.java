package nsukrpo.backend.repository.user;

import nsukrpo.backend.model.entities.user.UserType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserTypeRep extends CrudRepository<UserType, Long> {
    Optional<UserType> findByType(String type);
}
