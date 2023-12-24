package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.PurchaseApi;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.PurchaseDto;
import nsukrpo.backend.model.dtos.PurchasePostBody;
import nsukrpo.backend.services.LoginService;
import nsukrpo.backend.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3000)
public class PurchaseController implements PurchaseApi {

    private final PurchaseService service;

    @Autowired
    public PurchaseController(PurchaseService service1){
        service = service1;
    }

    @Override
    public ResponseEntity<List<PurchaseDto>> purchaseGet(Long userId) {
        return new ResponseEntity<>(service.purchaseGet(userId), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<IdDto> purchasePost(PurchasePostBody body) {
        return new ResponseEntity<>(service.purchasePost(body), HttpStatus.OK);
    }
}
