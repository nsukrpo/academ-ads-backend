package nsukrpo.backend.model.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 * LoginBody
 */
@Validated


public class LoginBodyDto {
  @JsonProperty("user_id")
  private Long userId = null;

  @JsonProperty("login")
  private String login = null;

  @JsonProperty("password")
  private String password = null;

  public LoginBodyDto userId(Long userId) {
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

  public LoginBodyDto login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
   **/
  
    public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public LoginBodyDto password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  
    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginBodyDto loginBody = (LoginBodyDto) o;
    return Objects.equals(this.userId, loginBody.userId) &&
        Objects.equals(this.login, loginBody.login) &&
        Objects.equals(this.password, loginBody.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, login, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginBody {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
