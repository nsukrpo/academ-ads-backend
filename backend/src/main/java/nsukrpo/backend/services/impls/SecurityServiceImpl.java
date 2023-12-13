package nsukrpo.backend.services.impls;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityServiceImpl {

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.GET, "/advertisement").permitAll()
                        .requestMatchers(HttpMethod.GET, "/advertisement/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/category").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").anonymous()
                        .anyRequest().authenticated())
                .exceptionHandling(entry ->
                        entry.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")))
                .build();
    }
}
