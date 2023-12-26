package nsukrpo.backend.services.impls.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtUtil {
    private final ObjectMapper mapper;

    @Autowired
    public JwtUtil(ObjectMapper mapper){
        this.mapper = mapper;
    }

    public boolean validate(String jwt) {
        var headerBytes = JWT.decode(jwt).getHeader().getBytes(StandardCharsets.UTF_8);
        var payloadBytes = JWT.decode(jwt).getPayload().getBytes(StandardCharsets.UTF_8);

        byte[] contentBytes = new byte[headerBytes.length + 1 + payloadBytes.length];
        System.arraycopy(headerBytes, 0, contentBytes, 0, headerBytes.length);
        contentBytes[headerBytes.length] = 46;
        System.arraycopy(payloadBytes, 0, contentBytes, headerBytes.length + 1, payloadBytes.length);

        var realSig = Base64.getUrlEncoder().withoutPadding().encodeToString((String.valueOf(Arrays.hashCode(contentBytes)) + String.valueOf("редиска".hashCode())).getBytes());
        return realSig.equals(JWT.decode(jwt).getSignature());

    }

    public Set<GrantedAuthority> getRoles(String jwt){
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(nsukrpo.backend.config.UserType.REGULAR.name()));
        return roles;
    }

    public String getLogin(String jwt) throws JsonProcessingException {
        var payload = new String(Base64.getDecoder().decode(JWT.decode(jwt).getPayload()), StandardCharsets.UTF_8);

        var token = mapper.readValue(payload, Jwt.class);
        return token.getLogin();
    }
}
