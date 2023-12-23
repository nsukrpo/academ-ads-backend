package nsukrpo.backend.services.impls;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityServiceImpl {

    private final boolean testRegime = false;

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception{
        if (testRegime)
            return securityFilterChainTest(http);
        else
            return securityFilterChainReal(http);
    }

    private SecurityFilterChain securityFilterChainTest(final HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests.anyRequest().permitAll()).build();
    }

    private SecurityFilterChain securityFilterChainReal(final HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.GET, "/advertisement").permitAll()
                        .requestMatchers(HttpMethod.GET, "/advertisement/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/category").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").anonymous()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(entry ->
                        entry.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")))
                .build();
    }
}
