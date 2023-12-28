package nsukrpo.backend.services.impls;

import nsukrpo.backend.config.AdvStatus;
import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.BookingDto;
import nsukrpo.backend.model.dtos.BookingPostBody;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.entities.advertisement.Booking;
import nsukrpo.backend.model.entities.advertisement.StatusAd;
import nsukrpo.backend.repository.advertsimenent.AdvRep;
import nsukrpo.backend.repository.advertsimenent.BookingRep;
import nsukrpo.backend.services.BookingService;
import nsukrpo.backend.services.impls.utils.AdvManager;
import nsukrpo.backend.services.impls.utils.BookingManager;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final ModelMapper modelMapper;
    private final AdvRep advRep;
    private final AdvManager advManager;
    private final UserManager userManager;
    private final BookingRep bookingRep;
    private final BookingManager bookingManager;

    @Autowired
    public BookingServiceImpl(
            AdvRep advRep1,
            ModelMapper modelMapper1,
            AdvManager advManager1,
            UserManager userManager1,
            BookingRep bookingRep1,
            BookingManager bookingManager1)
    {
        bookingManager = bookingManager1;
        bookingRep = bookingRep1;
        advRep = advRep1;
        modelMapper = modelMapper1;
        advManager = advManager1;
        userManager = userManager1;
    }

    @Override
    public void bookingDelete(Long bookingId) {
        var booking = bookingManager.getBookingOrThrow(bookingId);
        var adv = booking.getAds();
        adv.setStatus(advManager.getAdvStatusOrThrow(AdvStatus.ON_ADS_BOARD));
        advRep.save(adv);
        bookingRep.delete(booking);
    }

    @Override
    public List<BookingDto> bookingGet(Long userId) {
        userManager.getUserOrThrow(userId);
        return modelMapper.map(bookingRep.findBookingsByClaimantId(userId),new TypeToken<List<BookingDto>>() {}.getType());
    }

    @Override
    public IdDto bookingPost(BookingPostBody body) {
        var user = userManager.getUserOrThrow(body.getClaimant());
        var adv = advManager.getAdvOrThrow(body.getAdsId());

        Booking booking = Booking.builder()
                .ads(adv)
                .claimant(user)
                .dateStart(new Timestamp(System.currentTimeMillis()))
                .dateUntil(body.getDateUntil())
                .build();

        adv.setStatus(advManager.getAdvStatusOrThrow(AdvStatus.BOOKED));
        booking = bookingRep.save(booking);

        return new IdDto(booking.getId());

    }

    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    private void bookingExpiration(){
        var ads = advRep.findAllByStatusIdAndBookingsDateUntilBefore(advManager.getAdvStatusOrThrow(AdvStatus.BOOKED).getId(), new Timestamp(System.currentTimeMillis()));
        var onBoard = advManager.getAdvStatusOrThrow(AdvStatus.ON_ADS_BOARD);
        for (var ad : ads){
            ad.setStatus(onBoard);
            advRep.save(ad);
        }
//        advRep.saveAll(ads);

    }
}

