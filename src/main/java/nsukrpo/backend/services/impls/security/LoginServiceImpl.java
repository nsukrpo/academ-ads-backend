package nsukrpo.backend.services.impls.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureGenerationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;
//import nsukrpo.backend.model.dtos.TokenDto;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.services.LoginService;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRep userRep;
    private final UserManager userManager;
    private final UserDetailsService userService;

    @Autowired
    public LoginServiceImpl(
            UserRep userRep,
            UserManager userManager,
            UserDetailsService userService){
        this.userRep = userRep;
        this.userManager = userManager;
        this.userService = userService;
    }

    @Override
    public String loginPost(LoginBodyDto body){
        UserDetails userDetails = userService.loadUserByUsername(body.getLogin());
        var user = userManager.getUserByLoginOrThrow(body.getLogin());
        int passwordHash = body.getPassword().hashCode();
        int userPasswordHash = Integer.parseInt(userDetails.getPassword());
        if (passwordHash == userPasswordHash){
            return JWT.create()
                    .withClaim("user_id", user.getId().toString())
                    .withClaim("role", user.getType().getType())
                    .withClaim("login", user.getLogin())
                    .sign(new Algorithm("i", "do nothing") {
                        @Override
                        public void verify(DecodedJWT decodedJWT) throws SignatureVerificationException {
                        }

                        @Override
                        public byte[] sign(byte[] bytes) throws SignatureGenerationException {
                            return (String.valueOf(Arrays.hashCode(bytes)) + String.valueOf("редиска".hashCode())).getBytes();
                        }
                    });
        }
        throw new AuthenticationServiceException("Wrong login or password");
    }

    @Override
    public IdDto loginPut(LoginBodyDto body){
        var user = userManager.getUserOrThrow(body.getUserId());
        Optional.ofNullable(body.getLogin()).ifPresent(user::setLogin);
        Optional.ofNullable(body.getPassword()).map(String::hashCode).ifPresent(user::setPasswordHash);
        userRep.save(user);
        return new IdDto(user.getId());
    }

}
