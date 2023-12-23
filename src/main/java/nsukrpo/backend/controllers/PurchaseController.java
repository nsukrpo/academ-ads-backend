package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.PurchaseApi;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.PurchaseDto;
import nsukrpo.backend.model.dtos.PurchasePostBody;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PurchaseController implements PurchaseApi {
    @Override
    public ResponseEntity<List<PurchaseDto>> purchaseGet(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<IdDto> purchasePost(PurchasePostBody body) {
        return null;
    }
}
