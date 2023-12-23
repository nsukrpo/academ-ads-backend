package nsukrpo.backend.model.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 * InlineResponse2001
 */
@Validated


public class TokenDto {
  @JsonProperty("token")
  private Integer token = null;

  public TokenDto token(Integer token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   **/
  
    public Integer getToken() {
    return token;
  }

  public void setToken(Integer token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenDto inlineResponse2001 = (TokenDto) o;
    return Objects.equals(this.token, inlineResponse2001.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
