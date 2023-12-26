package nsukrpo.backend.services.impls.security;

import com.auth0.jwt.JWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (null == header || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        var token = new AnonymousAuthenticationToken("fdsfsd", "", new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(token);

        // Get jwt token and validate
//        final String token = header.split(" ")[1].trim();
//        if (!jwtTokenUtil.validate(token)) {
//            chain.doFilter(request, response);
//            return;
//        }
//        var jwt = JWT.decode(token).getPayload();
        // Get user identity and set it on the spring security context
//        UserDetails userDetails = userRepo
//            .findByUsername(jwtTokenUtil.getUsername(token))
//            .orElse(null);
//
//        UsernamePasswordAuthenticationToken
//            authentication = new UsernamePasswordAuthenticationToken(
//                userDetails, null,
//                userDetails == null ?
//                    List.of() : userDetails.getAuthorities()
//            );
//
//        authentication.setDetails(
//            new WebAuthenticationDetailsSource().buildDetails(request)
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

}