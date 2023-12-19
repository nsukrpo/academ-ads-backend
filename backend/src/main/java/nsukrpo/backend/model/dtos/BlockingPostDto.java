package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * BlockingBody
 */
@Validated
public class BlockingPostDto {
  @JsonProperty("user_id")
  private Long userId = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("time_minutes")
  private Integer timeMinutes = null;

  public BlockingPostDto userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public BlockingPostDto reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   * @return reason
   **/

  @Size(max=1000)
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public BlockingPostDto timeMinutes(Integer timeMinutes) {
    this.timeMinutes = timeMinutes;
    return this;
  }

  /**
   * Get timeMinutes
   * @return timeMinutes
   **/

  public Integer getTimeMinutes() {
    return timeMinutes;
  }

  public void setTimeMinutes(Integer timeMinutes) {
    this.timeMinutes = timeMinutes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockingPostDto blockingBody = (BlockingPostDto) o;
    return Objects.equals(this.userId, blockingBody.userId) &&
            Objects.equals(this.reason, blockingBody.reason) &&
            Objects.equals(this.timeMinutes, blockingBody.timeMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, reason, timeMinutes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockingBody {\n");

    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    timeMinutes: ").append(toIndentedString(timeMinutes)).append("\n");
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
