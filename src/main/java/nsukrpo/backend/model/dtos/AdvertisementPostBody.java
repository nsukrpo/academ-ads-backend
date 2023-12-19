package nsukrpo.backend.model.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * AdvertisementBody
 */
@Validated


public class AdvertisementPostBody {
  @JsonProperty("header")
  private String header = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("author")
  private Long author = null;

  public AdvertisementPostBody header(String header) {
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

  public AdvertisementPostBody description(String description) {
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

  public AdvertisementPostBody price(Double price) {
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

  public AdvertisementPostBody category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public AdvertisementPostBody author(Long author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
   **/
  
    public Long getAuthor() {
    return author;
  }

  public void setAuthor(Long author) {
    this.author = author;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdvertisementPostBody advertisementBody = (AdvertisementPostBody) o;
    return Objects.equals(this.header, advertisementBody.header) &&
        Objects.equals(this.description, advertisementBody.description) &&
        Objects.equals(this.price, advertisementBody.price) &&
        Objects.equals(this.category, advertisementBody.category) &&
        Objects.equals(this.author, advertisementBody.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, description, price, category, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvertisementBody {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
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
