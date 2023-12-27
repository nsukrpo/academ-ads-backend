package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.AdvertisementPostBody;
import nsukrpo.backend.model.dtos.AdvertisementPutBody;
import nsukrpo.backend.model.dtos.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Validated
public interface AdvertisementApi {

        
    @GetMapping(value = "/advertisement",
        produces = { "application/json" })
    ResponseEntity<List<AdvertisementDto>> advertisementGet(
            @Valid @RequestParam(value = "category", required = false) Long category,
            @Valid @RequestParam(value = "date", required = false) Date date,
            @Valid @RequestParam(value = "countWatch", required = false) Long countWatch,
            @Valid @RequestParam(value = "header", required = false) String header
);


        
        
    @DeleteMapping(value = "/advertisement/{id}",
        produces = { "application/json" })
    ResponseEntity<Void> advertisementIdDelete(@PathVariable("id") Long id);


        
        
    @GetMapping(value = "/advertisement/{id}",
        produces = { "application/json" })
    ResponseEntity<AdvertisementDto> advertisementIdGet(@PathVariable("id") Long id);


        
        
    @PutMapping(value = "/advertisement/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" })
    ResponseEntity<IdDto> advertisementIdPut(@PathVariable("id") Long id, @Valid @RequestBody AdvertisementPutBody body);


        
    @PostMapping(value = "/advertisement",
        produces = { "application/json" }, 
        consumes = { "application/json" })
    ResponseEntity<IdDto> advertisementPost(@Valid @RequestBody AdvertisementPostBody body);

}

