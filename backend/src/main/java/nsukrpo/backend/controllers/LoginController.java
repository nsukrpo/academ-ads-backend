package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.LoginApi;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;
import nsukrpo.backend.model.dtos.TokenDto;
import nsukrpo.backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi {

    private final LoginService service;

    @Autowired
    public LoginController(LoginService loginService){
        service = loginService;
    }

    @Override
    public ResponseEntity<TokenDto> loginPost(LoginBodyDto body) {
        var res = service.loginPost(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> loginPut(LoginBodyDto body) {
        var res = service.loginPut(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
