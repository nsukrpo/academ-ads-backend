package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * BookingBody
 */
@Validated


public class BookingPostBody {
  @JsonProperty("ads_id")
  private Long adsId = null;

  @JsonProperty("claimant")
  private Long claimant = null;

  @JsonProperty("dateUntil")
  private Timestamp dateUntil = null;

  public BookingPostBody adsId(Long adsId) {
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

  public BookingPostBody claimant(Long claimant) {
    this.claimant = claimant;
    return this;
  }

  /**
   * Get claimant
   * @return claimant
   **/
  
    public Long getClaimant() {
    return claimant;
  }

  public void setClaimant(Long claimant) {
    this.claimant = claimant;
  }

  public BookingPostBody dateUntil(Timestamp dateUntil) {
    this.dateUntil = dateUntil;
    return this;
  }

  /**
   * Get dateUntil
   * @return dateUntil
   **/
  
    @Valid
    public Timestamp getDateUntil() {
    return dateUntil;
  }

  public void setDateUntil(Timestamp dateUntil) {
    this.dateUntil = dateUntil;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingPostBody bookingBody = (BookingPostBody) o;
    return Objects.equals(this.adsId, bookingBody.adsId) &&
        Objects.equals(this.claimant, bookingBody.claimant) &&
        Objects.equals(this.dateUntil, bookingBody.dateUntil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adsId, claimant, dateUntil);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingBody {\n");
    
    sb.append("    adsId: ").append(toIndentedString(adsId)).append("\n");
    sb.append("    claimant: ").append(toIndentedString(claimant)).append("\n");
    sb.append("    dateUntil: ").append(toIndentedString(dateUntil)).append("\n");
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
