package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.StrikeDto;
import nsukrpo.backend.model.dtos.StrikePostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/strike")
public interface StrikeApi {

    @GetMapping(value = "/{id}", produces = { "application/json" })
    ResponseEntity<StrikeDto> getStrike(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}", produces = { "application/json" }, consumes = { "application/json" })
    ResponseEntity<IdDto> putStrike(@PathVariable("id") Long id, @Valid @RequestBody StrikeDto body);

    @GetMapping(produces = { "application/json" })
    ResponseEntity<List<StrikeDto>> getUserStrikes(@Valid @RequestParam(value = "user_id") Long user_id);

    @PostMapping(produces = { "application/json" }, consumes = { "application/json" })
    ResponseEntity<IdDto> postStrike(@Valid @RequestBody StrikePostDto body);
}
