/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import nsukrpo.backend.model.dtos.PurchaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Validated
@RequestMapping("/sales")
public interface SalesApi {
    @GetMapping(produces = { "application/json" })
    ResponseEntity<List<PurchaseDto>> salesGet(@NotNull @Valid @RequestParam(value = "user_id", required = true) Long userId);

}

