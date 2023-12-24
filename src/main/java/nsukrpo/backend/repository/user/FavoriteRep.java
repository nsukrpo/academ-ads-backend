package nsukrpo.backend.repository.user;

import nsukrpo.backend.model.entities.user.Favourite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRep extends CrudRepository<Favourite, Long> {
    List<Favourite> findByUserId(Long user);
    Optional<Favourite> findByUserIdAndAdsId(Long user, Long ads);
}
