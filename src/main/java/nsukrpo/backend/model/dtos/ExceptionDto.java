package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@Builder
public class ExceptionDto {

    @JsonProperty("code")
    private final Integer code;
    @JsonProperty("message")
    private final String message;
}
