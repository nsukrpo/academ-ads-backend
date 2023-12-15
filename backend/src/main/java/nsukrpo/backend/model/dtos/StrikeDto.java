package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import nsukrpo.backend.model.entities.moderation.Strike;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
public class StrikeDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user")
    private Long user;

    @JsonProperty("reason")
    private String reason;

    public StrikeDto(Strike strike){
        id = strike.getId();
        user = strike.getUser().getId();
        reason = strike.getReason().getName();
    }

    public StrikeDto id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StrikeDto user(Long user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     **/
    @NotNull
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public StrikeDto reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     * @return reason
     **/
    @NotNull
    @Size(max=1000)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StrikeDto strikeDto = (StrikeDto) o;
        return Objects.equals(this.id, strikeDto.id) &&
                Objects.equals(this.user, strikeDto.user) &&
                Objects.equals(this.reason, strikeDto.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, reason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StrikeDto {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
