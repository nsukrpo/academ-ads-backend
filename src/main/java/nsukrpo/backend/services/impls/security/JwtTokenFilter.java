package nsukrpo.backend.services.impls.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

//    private final UserDetailsService userService;

//    @Autowired
//    public JwtTokenFilter(UserDetailsService userService){
//        this.userService = userService;
//    }
//    private final JwtTokenUtil jwtTokenUtil;
//    private final UserRepo userRepo;
//
//    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil,
//                          UserRepo userRepo) {
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.userRepo = userRepo;
//    }

    private final JwtUtil jwtUtil;
    @Autowired
    public JwtTokenFilter(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (null == header) {
            chain.doFilter(request, response);
            return;
        }

        boolean valid = false;
        try {
            valid = jwtUtil.validate(header);
        } catch (JWTDecodeException e){
            chain.doFilter(request, response);
            return;
        }

        if (!valid) {
            chain.doFilter(request, response);
            return;
        }


        final String token = header;

        var token1 = new UsernamePasswordAuthenticationToken(jwtUtil.getLogin(token),token , jwtUtil.getRoles(token));
        SecurityContextHolder.getContext().setAuthentication(token1);

        chain.doFilter(request, response);
    }

}