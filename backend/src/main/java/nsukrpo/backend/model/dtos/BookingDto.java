package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * BookingDto
 */
@Validated


public class BookingDto   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("ads")
  private Long ads = null;

  @JsonProperty("claimant")
  private Long claimant = null;

  @JsonProperty("dateStart")
  private Timestamp dateStart = null;

  @JsonProperty("dateUntil")
  private Timestamp dateUntil = null;

  public BookingDto id(Long id) {
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

  public BookingDto ads(Long ads) {
    this.ads = ads;
    return this;
  }

  /**
   * Get ads
   * @return ads
   **/
      @NotNull

    public Long getAds() {
    return ads;
  }

  public void setAds(Long ads) {
    this.ads = ads;
  }

  public BookingDto claimant(Long claimant) {
    this.claimant = claimant;
    return this;
  }

  /**
   * Get claimant
   * @return claimant
   **/
      @NotNull

    public Long getClaimant() {
    return claimant;
  }

  public void setClaimant(Long claimant) {
    this.claimant = claimant;
  }

  public BookingDto dateStart(Timestamp dateStart) {
    this.dateStart = dateStart;
    return this;
  }

  /**
   * Get dateStart
   * @return dateStart
   **/
      @NotNull

    @Valid
    public Timestamp getDateStart() {
    return dateStart;
  }

  public void setDateStart(Timestamp dateStart) {
    this.dateStart = dateStart;
  }

  public BookingDto dateUntil(Timestamp dateUntil) {
    this.dateUntil = dateUntil;
    return this;
  }

  /**
   * Get dateUntil
   * @return dateUntil
   **/
      @NotNull

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
    BookingDto bookingDto = (BookingDto) o;
    return Objects.equals(this.id, bookingDto.id) &&
        Objects.equals(this.ads, bookingDto.ads) &&
        Objects.equals(this.claimant, bookingDto.claimant) &&
        Objects.equals(this.dateStart, bookingDto.dateStart) &&
        Objects.equals(this.dateUntil, bookingDto.dateUntil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ads, claimant, dateStart, dateUntil);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ads: ").append(toIndentedString(ads)).append("\n");
    sb.append("    claimant: ").append(toIndentedString(claimant)).append("\n");
    sb.append("    dateStart: ").append(toIndentedString(dateStart)).append("\n");
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
