package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.FavoriteAdvertisementDto;
import nsukrpo.backend.model.dtos.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/favorite/advertisement")
public interface FavoriteApi {

    @GetMapping(produces = { "application/json" })
    ResponseEntity<List<AdvertisementDto>> getFavoriteAds(@Valid @RequestParam(value = "user_id") Long user_id);
    @PostMapping(produces = { "application/json" }, consumes = { "application/json" })
    ResponseEntity<IdDto> postFavoriteAds(@Valid @RequestBody FavoriteAdvertisementDto body);
    @DeleteMapping(produces = { "application/json" })
    ResponseEntity<Void> deleteFavoriteAds(@Valid @RequestParam(value = "user_id") Long user_id,
                                           @Valid @RequestParam(value = "ads_id") Long ads_id);
}
