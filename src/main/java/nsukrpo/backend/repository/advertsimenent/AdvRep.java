package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.Advertisement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface AdvRep extends PagingAndSortingRepository<Advertisement, Long> {
    List<Advertisement> findByCategoryIdAndStatusIdOrderByPublicationDateDesc(Long category, Long status);

    List<Advertisement> findAllByCategoryIdOrderByPublicationDateDesc(Long category, Pageable pageable);

    List<Advertisement> findAllByStatusIdOrderByPublicationDate(Long status);

    List<Advertisement> findAllByOrderByPublicationDateDesc(Pageable pageable);
    List<Advertisement> findAllByHeaderContainingIgnoreCaseOrderByPublicationDateDesc(String header, Pageable pageable);

    List<Advertisement> findByCategoryIdAndHeaderContainingIgnoreCaseOrderByPublicationDateDesc(Long category, String text, Pageable pageable);
    void delete(Advertisement s);
    Advertisement save(Advertisement s);

    Optional<Advertisement> findById(Long id);

}
