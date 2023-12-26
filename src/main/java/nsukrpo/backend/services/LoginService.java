package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;

public interface LoginService {
    String loginPost(LoginBodyDto body);

    IdDto loginPut(LoginBodyDto body);
}
