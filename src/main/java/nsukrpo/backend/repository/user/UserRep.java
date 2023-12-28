package nsukrpo.backend.repository.user;

import nsukrpo.backend.model.entities.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRep extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByLogin(String login);
    Optional<User> findById(Long id);
    User save(User s);
}
