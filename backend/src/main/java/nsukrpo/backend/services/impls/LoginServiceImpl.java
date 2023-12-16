package nsukrpo.backend.services.impls;

import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.LoginBodyDto;
import nsukrpo.backend.model.dtos.TokenDto;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.services.LoginService;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService, UserDetailsService {

    private final UserRep userRep;
    private final UserManager userManager;

    @Autowired
    public LoginServiceImpl(UserRep userRep, UserManager userManager){
        this.userRep = userRep;
        this.userManager = userManager;
    }

    @Override
    public TokenDto loginPost(LoginBodyDto body){
        UserDetails userDetails = loadUserByUsername(body.getLogin());
        int passwordHash = body.getPassword().hashCode();
        int userPasswordHash = Integer.parseInt(userDetails.getPassword());
        if (passwordHash == userPasswordHash){
            var token = new UsernamePasswordAuthenticationToken(userDetails, passwordHash, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
            return new TokenDto().token(token.hashCode());
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

    private User loadUser(String login) throws UsernameNotFoundException {
        var users = userRep.findAll();
        for (User user: users)
            if (login.equals(user.getLogin()))
                return user;
        throw new UsernameNotFoundException("not found user with login: " + login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = loadUser(login);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(user.getType().getType()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPasswordHash().toString(), roles);
    }
}
