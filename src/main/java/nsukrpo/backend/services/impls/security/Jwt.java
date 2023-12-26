package nsukrpo.backend.services.impls.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Jwt {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("role")
    private String role;

    @JsonProperty("login")
    private String login;
}
