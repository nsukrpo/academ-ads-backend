package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.FavoriteAdvertisementDto;
import nsukrpo.backend.model.dtos.IdDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface FavoriteService {

    List<AdvertisementDto> getFavoriteAds(Long user_id);
    IdDto postFavoriteAds(FavoriteAdvertisementDto body);
    HttpStatus deleteFavoriteAds(Long user_id, Long ads_id);
}
