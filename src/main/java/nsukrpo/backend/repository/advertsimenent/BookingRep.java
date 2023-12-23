package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.dtos.BookingDto;
import nsukrpo.backend.model.entities.advertisement.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRep extends CrudRepository<Booking, Long> {
    List<Booking> findBookingsByClaimantId(Long claimantId);
}
