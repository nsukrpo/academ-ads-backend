package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
public class ExceptionDto {

    @JsonProperty("code")
    private final Integer code;
    @JsonProperty("message")
    private final String message;
}
