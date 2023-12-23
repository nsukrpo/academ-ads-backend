package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;
import nsukrpo.backend.model.dtos.TokenDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Valid
@RequestMapping("/login")
public interface LoginApi {
    @PostMapping(produces = { "application/json" }, consumes = { "application/json" })
    ResponseEntity<TokenDto> loginPost(@Valid @RequestBody LoginBodyDto body);

    @PutMapping(produces = { "application/json" }, consumes = { "application/json" })
    ResponseEntity<IdDto> loginPut(@RequestBody LoginBodyDto body);

    @GetMapping(produces = { "application/json" })
    ResponseEntity<String> loginGet();
}
