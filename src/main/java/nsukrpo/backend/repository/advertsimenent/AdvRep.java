package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.Advertisement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvRep extends CrudRepository<Advertisement, Long> {
    List<Advertisement> findByCategoryIdAndStatusIdOrderByPublicationDateDesc(Long category, Long status);

    List<Advertisement> findByCategoryIdOrderByPublicationDateDesc(Long category);

    List<Advertisement> findAllByStatusIdOrderByPublicationDate(Long status);

    List<Advertisement> findAllByOrderByPublicationDateDesc();
    List<Advertisement> findByHeaderContainingIgnoreCaseOrderByPublicationDateDesc(String text);

    List<Advertisement> findByCategoryIdAndHeaderContainingIgnoreCaseOrderByPublicationDateDesc(Long category, String text);
    void delete(Advertisement s);

}
