package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;
import nsukrpo.backend.model.dtos.TokenDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Valid
@RequestMapping("/login")
public interface LoginApi {
    @PostMapping(produces = { "application/json", "application/json" },
            consumes = { "application/json" })
    ResponseEntity<TokenDto> loginPost(@Valid @RequestBody LoginBodyDto body);

    @PutMapping(produces = { "application/json", "application/json" },
            consumes = { "application/json" })
    ResponseEntity<IdDto> loginPut(@RequestBody LoginBodyDto body);
}
