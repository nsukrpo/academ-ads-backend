package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.PurchasePostBody;
import nsukrpo.backend.model.dtos.PurchaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/purchase")
public interface PurchaseApi {

    @GetMapping(produces = { "application/json" })
    ResponseEntity<List<PurchaseDto>> purchaseGet(@NotNull @Valid @RequestParam(value = "user_id", required = true) Long userId);

    @PostMapping(produces = { "application/json" },
        consumes = { "application/json" })
    ResponseEntity<IdDto> purchasePost(@Valid @RequestBody PurchasePostBody body);

}

