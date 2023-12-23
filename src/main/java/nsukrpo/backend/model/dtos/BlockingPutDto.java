package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * BlockingIdBody
 */
@Validated
@NoArgsConstructor
public class BlockingPutDto {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("user")
  private Long user = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("time")
  private Integer time = null;

  public BlockingPutDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BlockingPutDto user(Long user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/


  public Long getUser() {
    return user;
  }

  public void setUser(Long user) {
    this.user = user;
  }

  public BlockingPutDto reason(String reason) {
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

  public BlockingPutDto time(Integer time) {
    this.time = time;
    return this;
  }

  /**
   * Время блокировки в минутах
   * @return time
   **/

  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockingPutDto blockingIdBody = (BlockingPutDto) o;
    return Objects.equals(this.id, blockingIdBody.id) &&
            Objects.equals(this.user, blockingIdBody.user) &&
            Objects.equals(this.reason, blockingIdBody.reason) &&
            Objects.equals(this.time, blockingIdBody.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user, reason, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockingIdBody {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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
