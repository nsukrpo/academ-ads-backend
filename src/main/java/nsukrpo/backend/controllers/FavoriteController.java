package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.FavoriteApi;
import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.FavoriteAdvertisementDto;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavoriteController implements FavoriteApi {
    private final FavoriteService service;

    @Autowired
    public FavoriteController(FavoriteService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<AdvertisementDto>> getFavoriteAds(Long user_id) {
        var res = service.getFavoriteAds(user_id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> postFavoriteAds(FavoriteAdvertisementDto body) {
        var res = service.postFavoriteAds(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteFavoriteAds(Long user_id, Long ads_id) {
        return new ResponseEntity<>(service.deleteFavoriteAds(user_id, ads_id));
    }
}
