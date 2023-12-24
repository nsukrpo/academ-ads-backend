package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.SalesApi;
import nsukrpo.backend.model.dtos.PurchaseDto;
import nsukrpo.backend.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3000)
public class SalesController implements SalesApi {

    private SalesService service;
    @Autowired
    public void SalesController(SalesService salesService){
        service = salesService;
    }
    @Override
    public ResponseEntity<List<PurchaseDto>> salesGet(Long userId) {

        return new ResponseEntity<>(service.salesGet(userId), HttpStatus.OK);
    }
}
