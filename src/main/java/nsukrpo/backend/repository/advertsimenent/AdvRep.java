package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.Advertisement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

// TODO ну тут нужно сортировку убрать в параметр и сделать спецификации
public interface AdvRep extends PagingAndSortingRepository<Advertisement, Long> {
    List<Advertisement> findByCategoryIdAndStatusIdOrderByPublicationDateDesc(Long category, Long status);

    List<Advertisement> findAllByCategoryIdOrderByPublicationDateDesc(Long category, Pageable pageable);

    List<Advertisement> findAllByStatusIdOrderByPublicationDateDesc(Long status, Pageable page);

    List<Advertisement> findAllByStatusIdAndBookingsDateUntilBefore(Long statusId,Timestamp beforeThatDate);

    List<Advertisement> findAllByOrderByPublicationDateDesc(Pageable pageable);
    List<Advertisement> findAllByHeaderContainingIgnoreCaseOrderByPublicationDateDesc(String header, Pageable pageable);

    List<Advertisement> findByCategoryIdAndHeaderContainingIgnoreCaseOrderByPublicationDateDesc(Long category, String text, Pageable pageable);


    List<Advertisement> findByCategoryIdAndStatusIdAndHeaderContainingIgnoreCaseOrderByPublicationDateDesc(Long category, Long status, String text, Pageable pageable);
    List<Advertisement> findAllByCategoryIdAndStatusIdOrderByPublicationDateDesc(Long category,Long status, Pageable pageable);
    List<Advertisement> findAllByStatusIdAndHeaderContainingIgnoreCaseOrderByPublicationDateDesc(Long status,String header, Pageable pageable);
    void delete(Advertisement s);
    Advertisement save(Advertisement s);

    Optional<Advertisement> findById(Long id);

    Iterable<Advertisement> saveAll(Iterable<Advertisement> ss);

}
