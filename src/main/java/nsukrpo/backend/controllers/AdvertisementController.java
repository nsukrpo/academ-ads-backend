package nsukrpo.backend.controllers;

import jakarta.validation.Valid;
import nsukrpo.backend.controllers.api.AdvertisementApi;
import nsukrpo.backend.model.dtos.*;
import nsukrpo.backend.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3000)
public class AdvertisementController implements AdvertisementApi {

    private final AdvertisementService service;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService){
        service = advertisementService;
    }

    @Override
    public ResponseEntity<List<AdvertisementDto>> advertisementGet(Long category, String header,Date date, Long countWatch,String status, Integer page) {
        var res = service.advertisementGet(category,header,status, page);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> advertisementIdDelete(Long id) {
        return new ResponseEntity<>(service.advertisementIdDelete(id));
    }

    @Override
    public ResponseEntity<AdvertisementDto> advertisementIdGet(Long id) {
        var res = service.advertisementIdGet(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> advertisementIdPut(Long id, AdvertisementPutBody body) {
        var res = service.advertisementIdPut(id,body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> advertisementPost(AdvertisementPostBody body) {
        var res =  service.advertisementPost(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
