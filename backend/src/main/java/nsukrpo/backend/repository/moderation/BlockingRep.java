package nsukrpo.backend.repository.moderation;

import nsukrpo.backend.model.entities.moderation.Block;
import org.springframework.data.repository.CrudRepository;

public interface BlockingRep extends CrudRepository<Block, Long> {
}
