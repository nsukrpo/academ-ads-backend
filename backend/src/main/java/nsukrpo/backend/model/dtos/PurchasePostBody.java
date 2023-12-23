package nsukrpo.backend.model.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 * PurchaseBody
 */
@Validated


public class PurchasePostBody {
  @JsonProperty("ads_id")
  private Long adsId = null;

  @JsonProperty("seller_id")
  private Long sellerId = null;

  @JsonProperty("buyer_id")
  private Long buyerId = null;

  @JsonProperty("price")
  private Double price = null;

  public PurchasePostBody adsId(Long adsId) {
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

  public PurchasePostBody sellerId(Long sellerId) {
    this.sellerId = sellerId;
    return this;
  }

  /**
   * Get sellerId
   * @return sellerId
   **/
  
    public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }

  public PurchasePostBody buyerId(Long buyerId) {
    this.buyerId = buyerId;
    return this;
  }

  /**
   * Get buyerId
   * @return buyerId
   **/
  
    public Long getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(Long buyerId) {
    this.buyerId = buyerId;
  }

  public PurchasePostBody price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  
    public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchasePostBody purchaseBody = (PurchasePostBody) o;
    return Objects.equals(this.adsId, purchaseBody.adsId) &&
        Objects.equals(this.sellerId, purchaseBody.sellerId) &&
        Objects.equals(this.buyerId, purchaseBody.buyerId) &&
        Objects.equals(this.price, purchaseBody.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adsId, sellerId, buyerId, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PurchaseBody {\n");
    
    sb.append("    adsId: ").append(toIndentedString(adsId)).append("\n");
    sb.append("    sellerId: ").append(toIndentedString(sellerId)).append("\n");
    sb.append("    buyerId: ").append(toIndentedString(buyerId)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
