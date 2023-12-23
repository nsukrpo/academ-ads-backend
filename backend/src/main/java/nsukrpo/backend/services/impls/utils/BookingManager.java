package nsukrpo.backend.services.impls.utils;

import nsukrpo.backend.model.entities.advertisement.Booking;

public interface BookingManager {
   Booking getBookingOrThrow(Long id);
}
