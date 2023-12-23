package nsukrpo.backend.services.impls.utils.impls;

import nsukrpo.backend.model.entities.advertisement.Booking;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.entities.user.UserAvatar;
import nsukrpo.backend.model.entities.user.UserType;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.advertsimenent.BookingRep;
import nsukrpo.backend.repository.user.UserAvatarRep;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.repository.user.UserTypeRep;
import nsukrpo.backend.services.impls.utils.BookingManager;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BookingManagerImpl implements BookingManager {
    private final BookingRep bookingRep;

    @Autowired
    public BookingManagerImpl(BookingRep bookingRep1){
        bookingRep = bookingRep1;
    }
    @Override
    public Booking getBookingOrThrow(Long id) {
        return bookingRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find booking: " + id));
    }
}
