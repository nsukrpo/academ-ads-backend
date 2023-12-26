package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.LoginApi;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;
import nsukrpo.backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3000)
public class LoginController implements LoginApi {

    private final LoginService service;

    @Autowired
    public LoginController(LoginService loginService){
        service = loginService;
    }

    @Override
    public ResponseEntity<String> loginPost(LoginBodyDto body) {
        String res = service.loginPost(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> loginPut(LoginBodyDto body) {
        var res = service.loginPut(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> loginGet() {
        String msg = "Покажите пользователю форму авторизации и затем сделайте POST-запрос на /login";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
