package nsukrpo.backend.config.mapper;

import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.BookingDto;
import nsukrpo.backend.model.entities.advertisement.Advertisement;
import nsukrpo.backend.model.entities.advertisement.Booking;
import nsukrpo.backend.model.entities.advertisement.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DefaultMapper extends ModelMapper {
    public DefaultMapper(){
        super();
        this.emptyTypeMap(Advertisement.class, AdvertisementDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getCategory().getId(), AdvertisementDto::setCategory);
            mapper.map(src -> src.getAuthor().getId(), AdvertisementDto::setAuthor);
            mapper.map(src -> src.getStatus().getName(), AdvertisementDto::setStatus);
        }).implicitMappings();

        this.emptyTypeMap(Booking.class, BookingDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getAds().getId(), BookingDto::setAds);
            mapper.map(src -> src.getClaimant().getId(), BookingDto::setClaimant);
        }).implicitMappings();

//        this.emptyTypeMap()
    }
}
