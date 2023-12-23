package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;
import nsukrpo.backend.model.dtos.TokenDto;

public interface LoginService {
    TokenDto loginPost(LoginBodyDto body);

    IdDto loginPut(LoginBodyDto body);
}
