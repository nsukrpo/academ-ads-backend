package nsukrpo.backend.services.impls.security;

import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityServiceImpl {

    private final boolean testRegime = false;
    private final JwtTokenFilter jwtTokenFilter;

    @Autowired
    public SecurityServiceImpl(JwtTokenFilter jwtTokenFilter){
        this.jwtTokenFilter = jwtTokenFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception{
        if (testRegime)
            return securityFilterChainTest(http);
        else
            return securityFilterChainReal(http);
    }

    @Bean
    public UserDetailsService userDetailsService(@Autowired UserManager manager){
        return username -> {
            try {
                var user = manager.getUserByLoginOrThrow(username);
                Set<GrantedAuthority> roles = new HashSet<>();
                roles.add(new SimpleGrantedAuthority(user.getType().getType()));
                return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPasswordHash().toString(), roles);
            } catch (NotFoundException e){
                throw new UsernameNotFoundException("Can't found user with login: " + username);
            }
        };

    }

    private SecurityFilterChain securityFilterChainTest(final HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests.anyRequest().permitAll()).build();
    }

    private SecurityFilterChain securityFilterChainReal(final HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.GET, "/advertisement", "/advertisement/**", "/category").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(entry ->
                        entry.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")))
                .addFilterBefore(jwtTokenFilter ,UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
