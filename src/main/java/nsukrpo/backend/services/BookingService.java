package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.BookingDto;
import nsukrpo.backend.model.dtos.BookingPostBody;
import nsukrpo.backend.model.dtos.IdDto;

import java.util.List;

public interface BookingService {

    void bookingDelete(Long bookingId);

    List<BookingDto> bookingGet(Long userId);

    IdDto bookingPost(BookingPostBody body);

}

