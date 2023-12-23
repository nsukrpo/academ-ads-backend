package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import nsukrpo.backend.model.entities.moderation.Block;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.*;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * BlockingDto
 */
@Validated
public class BlockingDto {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("user")
  private Long user;

  @JsonProperty("reason")
  private String reason;

  @JsonProperty("time")
  private Integer time;

  @JsonProperty("blockDate")
  private Timestamp blockDate;

  public BlockingDto(Block block){
    id = block.getId();
    user = block.getUser().getId();
    reason = block.getReason().getName();
    time = block.getTime();
    blockDate = block.getBlockDate();
  }

  public BlockingDto id(Long id) {
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

  public BlockingDto user(Long user) {
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

  public BlockingDto reason(String reason) {
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

  public BlockingDto time(Integer time) {
    this.time = time;
    return this;
  }

  /**
   * Время блокировки в минутах
   * @return time
   **/
  @NotNull
  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public BlockingDto blockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  /**
   * Get blockDate
   * @return blockDate
   **/
  @NotNull
  public Timestamp getBlockDate() {
    return blockDate;
  }

  public void setBlockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockingDto blockingDto = (BlockingDto) o;
    return Objects.equals(this.id, blockingDto.id) &&
            Objects.equals(this.user, blockingDto.user) &&
            Objects.equals(this.reason, blockingDto.reason) &&
            Objects.equals(this.time, blockingDto.time) &&
            Objects.equals(this.blockDate, blockingDto.blockDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user, reason, time, blockDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockingDto {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    blockDate: ").append(toIndentedString(blockDate)).append("\n");
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
