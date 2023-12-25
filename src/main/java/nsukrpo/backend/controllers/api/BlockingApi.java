package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import nsukrpo.backend.model.dtos.BlockingDto;
import nsukrpo.backend.model.dtos.BlockingPostDto;
import nsukrpo.backend.model.dtos.BlockingPutDto;
import nsukrpo.backend.model.dtos.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/blocking")
public interface BlockingApi {

    @GetMapping(value = "/{id}", produces = { "application/json" })
    ResponseEntity<BlockingDto> getBlocking(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}", produces = { "application/json" }, consumes = { "application/json" })
    ResponseEntity<IdDto> putBlocking(@PathVariable("id") Long id, @Valid @RequestBody BlockingPutDto body);

    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    ResponseEntity<Void> deleteBlocking(@PathVariable("id") Long id);

    @GetMapping(produces = { "application/json" })
    ResponseEntity<List<BlockingDto>> getUserBlocking(@Valid @RequestParam(value = "user_id", required = false) Long userId);

    @PostMapping(produces = { "application/json" }, consumes = { "application/json" })
    ResponseEntity<IdDto> postBlocking(@Valid @RequestBody BlockingPostDto body);
}
