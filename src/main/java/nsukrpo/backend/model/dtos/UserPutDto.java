package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.entities.user.UserAvatar;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;
import java.util.Optional;

/**
 * InlineResponse200
 */
@Validated
@NoArgsConstructor
public class UserPutDto {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("avatar")
  private Long avatar = null;

  public UserPutDto(User user){
    name = user.getName();
    avatar = Optional.ofNullable((user.getAvatar())).map(UserAvatar::getId).orElse(null);
  }

  public UserPutDto name(String name) {
    this.name = name;
    return this;
  }

  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserPutDto avatar(Long avatar) {
    this.avatar = avatar;
    return this;
  }
  
    public Long getAvatar() {
    return avatar;
  }

  public void setAvatar(Long avatar) {
    this.avatar = avatar;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPutDto filteredUserDto = (UserPutDto) o;
    return
        Objects.equals(this.name, filteredUserDto.name) &&
        Objects.equals(this.avatar, filteredUserDto.avatar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, avatar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserPutDto {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
