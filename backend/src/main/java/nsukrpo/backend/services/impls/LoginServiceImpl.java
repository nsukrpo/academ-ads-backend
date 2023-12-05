package nsukrpo.backend.services.impls;

import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;
import nsukrpo.backend.model.dtos.TokenDto;
import nsukrpo.backend.services.LoginService;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    public TokenDto loginPost(LoginBodyDto body){
        throw new NotImplementedException();
    }

    public IdDto loginPut(LoginBodyDto body){
        throw new NotImplementedException();
    }
}
