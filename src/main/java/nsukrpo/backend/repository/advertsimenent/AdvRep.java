package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.Advertisement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvRep extends CrudRepository<Advertisement, Long> {
    List<Advertisement> findByCategoryIdAndStatusId(Long category, Long status);

    void delete(Advertisement s);

}
