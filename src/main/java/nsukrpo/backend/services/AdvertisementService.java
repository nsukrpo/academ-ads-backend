package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.AdvertisementPostBody;
import nsukrpo.backend.model.dtos.AdvertisementPutBody;
import nsukrpo.backend.model.dtos.IdDto;
import org.springframework.http.HttpStatus;

import java.sql.Date;
import java.util.List;

public interface AdvertisementService {

    List<AdvertisementDto> advertisementGet(Long category, String header, Integer page);

    HttpStatus advertisementIdDelete(Long id);

    AdvertisementDto advertisementIdGet(Long id);

    IdDto advertisementIdPut(Long id,AdvertisementPutBody body);

    IdDto advertisementPost(AdvertisementPostBody body);
}
