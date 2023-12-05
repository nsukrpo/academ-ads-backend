package nsukrpo.backend.model.dtos;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.entities.user.UserAvatar;
import org.springframework.validation.annotation.Validated;

/**
 * InlineResponse200
 */
@Validated
@NoArgsConstructor
public class UserDto {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("avatar")
  private Long avatar = null;

  @JsonProperty("regDate")
  private Date regDate = null;

  @JsonProperty("sales")
  private Integer sales = null;

  @JsonProperty("purchases")
  private Integer purchases = null;

  public UserDto(User user){
    id = user.getId();
    name = user.getName();
    avatar = Optional.ofNullable((user.getAvatar())).map(UserAvatar::getId).orElse(null);
    regDate = user.getRegDate();
    sales = Optional.ofNullable(user.getSales()).map(set -> (long) set.size()).orElse(0L).intValue();
    purchases = Optional.ofNullable(user.getPurchase()).map(set -> (long) set.size()).orElse(0L).intValue();
  }

  public UserDto id(Long id) {
    this.id = id;
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserDto name(String name) {
    this.name = name;
    return this;
  }

  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserDto avatar(Long avatar) {
    this.avatar = avatar;
    return this;
  }
  
    public Long getAvatar() {
    return avatar;
  }

  public void setAvatar(Long avatar) {
    this.avatar = avatar;
  }

  public UserDto regDate(Date regDate) {
    this.regDate = regDate;
    return this;
  }


    public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  public UserDto sales(Integer sales) {
    this.sales = sales;
    return this;
  }

    public Integer getSales() {
    return sales;
  }

  public void setSales(Integer sales) {
    this.sales = sales;
  }

  public UserDto purchases(Integer purchases) {
    this.purchases = purchases;
    return this;
  }

    public Integer getPurchases() {
    return purchases;
  }

  public void setPurchases(Integer purchases) {
    this.purchases = purchases;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDto filteredUserDto = (UserDto) o;
    return Objects.equals(this.id, filteredUserDto.id) &&
        Objects.equals(this.name, filteredUserDto.name) &&
        Objects.equals(this.avatar, filteredUserDto.avatar) &&
        Objects.equals(this.regDate, filteredUserDto.regDate) &&
        Objects.equals(this.sales, filteredUserDto.sales) &&
        Objects.equals(this.purchases, filteredUserDto.purchases);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, avatar, regDate, sales, purchases);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    regDate: ").append(toIndentedString(regDate)).append("\n");
    sb.append("    sales: ").append(toIndentedString(sales)).append("\n");
    sb.append("    purchases: ").append(toIndentedString(purchases)).append("\n");
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
