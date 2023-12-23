package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.SalesApi;
import nsukrpo.backend.model.dtos.PurchaseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SalesController implements SalesApi {
    @Override
    public ResponseEntity<List<PurchaseDto>> salesGet(Long userId) {
        return null;
    }
}
