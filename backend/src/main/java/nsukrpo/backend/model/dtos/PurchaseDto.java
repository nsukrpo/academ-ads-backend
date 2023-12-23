package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * PurchaseDto
 */
@Validated


public class PurchaseDto   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("ads")
  private Long ads = null;

  @JsonProperty("seller")
  private Long seller = null;

  @JsonProperty("buyer")
  private Long buyer = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("date")
  private Timestamp date = null;

  public PurchaseDto id(Long id) {
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

  public PurchaseDto ads(Long ads) {
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

  public PurchaseDto seller(Long seller) {
    this.seller = seller;
    return this;
  }

  /**
   * Get seller
   * @return seller
   **/
      @NotNull

    public Long getSeller() {
    return seller;
  }

  public void setSeller(Long seller) {
    this.seller = seller;
  }

  public PurchaseDto buyer(Long buyer) {
    this.buyer = buyer;
    return this;
  }

  /**
   * Get buyer
   * @return buyer
   **/
      @NotNull

    public Long getBuyer() {
    return buyer;
  }

  public void setBuyer(Long buyer) {
    this.buyer = buyer;
  }

  public PurchaseDto price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
      @NotNull

    public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public PurchaseDto date(Timestamp date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
      @NotNull

    @Valid
    public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchaseDto purchaseDto = (PurchaseDto) o;
    return Objects.equals(this.id, purchaseDto.id) &&
        Objects.equals(this.ads, purchaseDto.ads) &&
        Objects.equals(this.seller, purchaseDto.seller) &&
        Objects.equals(this.buyer, purchaseDto.buyer) &&
        Objects.equals(this.price, purchaseDto.price) &&
        Objects.equals(this.date, purchaseDto.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ads, seller, buyer, price, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PurchaseDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ads: ").append(toIndentedString(ads)).append("\n");
    sb.append("    seller: ").append(toIndentedString(seller)).append("\n");
    sb.append("    buyer: ").append(toIndentedString(buyer)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
