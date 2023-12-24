package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * FavoriteAdvertisementBody
 */
@Validated
public class FavoriteAdvertisementDto {
  @JsonProperty("ads_id")
  private Long adsId = null;

  @JsonProperty("user_id")
  private Long userId = null;

  public FavoriteAdvertisementDto adsId(Long adsId) {
    this.adsId = adsId;
    return this;
  }

  /**
   * Get adsId
   * @return adsId
   **/

  public Long getAdsId() {
    return adsId;
  }

  public void setAdsId(Long adsId) {
    this.adsId = adsId;
  }

  public FavoriteAdvertisementDto userId(Long userId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FavoriteAdvertisementDto favoriteAdvertisementDto = (FavoriteAdvertisementDto) o;
    return Objects.equals(this.adsId, favoriteAdvertisementDto.adsId) &&
            Objects.equals(this.userId, favoriteAdvertisementDto.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adsId, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FavoriteAdvertismentBody {\n");

    sb.append("    adsId: ").append(toIndentedString(adsId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
