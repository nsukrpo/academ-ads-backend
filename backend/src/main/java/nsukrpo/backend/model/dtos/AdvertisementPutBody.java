package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * AdvertisementIdBody
 */
@Validated


public class AdvertisementPutBody {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("header")
  private String header = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("category")
  private Long category = null;

  @JsonProperty("status")
  private String status = null;

  public AdvertisementPutBody id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AdvertisementPutBody header(String header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
   **/
  
    public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public AdvertisementPutBody description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  
  @Size(max=10000)   public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AdvertisementPutBody price(Double price) {
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

  public AdvertisementPutBody category(Long category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  
    public Long getCategory() {
    return category;
  }

  public void setCategory(Long category) {
    this.category = category;
  }

  public AdvertisementPutBody status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdvertisementPutBody advertisementIdBody = (AdvertisementPutBody) o;
    return Objects.equals(this.id, advertisementIdBody.id) &&
        Objects.equals(this.header, advertisementIdBody.header) &&
        Objects.equals(this.description, advertisementIdBody.description) &&
        Objects.equals(this.price, advertisementIdBody.price) &&
        Objects.equals(this.category, advertisementIdBody.category) &&
        Objects.equals(this.status, advertisementIdBody.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, header, description, price, category, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvertisementIdBody {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
