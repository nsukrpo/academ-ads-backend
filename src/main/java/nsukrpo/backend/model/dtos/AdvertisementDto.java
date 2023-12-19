package nsukrpo.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * AdvertisementDto
 */
@Validated


public class AdvertisementDto   {
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

  @JsonProperty("author")
  private Long author = null;

  @JsonProperty("publicationDate")
  private Timestamp publicationDate = null;

  @JsonProperty("countWatch")
  private Integer countWatch = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("editDate")
  private Timestamp editDate = null;

  public AdvertisementDto id(Long id) {
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

  public AdvertisementDto header(String header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
   **/
      @NotNull

    public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public AdvertisementDto description(String description) {
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

  public AdvertisementDto price(Double price) {
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

  public AdvertisementDto category(Long category) {
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

  public AdvertisementDto author(Long author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
   **/
      @NotNull

    public Long getAuthor() {
    return author;
  }

  public void setAuthor(Long author) {
    this.author = author;
  }

  public AdvertisementDto publicationDate(Timestamp publicationDate) {
    this.publicationDate = publicationDate;
    return this;
  }

  /**
   * Get publicationDate
   * @return publicationDate
   **/
      @NotNull

    @Valid
    public Timestamp getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Timestamp publicationDate) {
    this.publicationDate = publicationDate;
  }

  public AdvertisementDto countWatch(Integer countWatch) {
    this.countWatch = countWatch;
    return this;
  }

  /**
   * Get countWatch
   * @return countWatch
   **/
      @NotNull

    public Integer getCountWatch() {
    return countWatch;
  }

  public void setCountWatch(Integer countWatch) {
    this.countWatch = countWatch;
  }

  public AdvertisementDto status(String status) {
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

  public AdvertisementDto editDate(Timestamp editDate) {
    this.editDate = editDate;
    return this;
  }

  /**
   * Get editDate
   * @return editDate
   **/
  
    @Valid
    public Timestamp getEditDate() {
    return editDate;
  }

  public void setEditDate(Timestamp editDate) {
    this.editDate = editDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdvertisementDto advertisementDto = (AdvertisementDto) o;
    return Objects.equals(this.id, advertisementDto.id) &&
        Objects.equals(this.header, advertisementDto.header) &&
        Objects.equals(this.description, advertisementDto.description) &&
        Objects.equals(this.price, advertisementDto.price) &&
        Objects.equals(this.category, advertisementDto.category) &&
        Objects.equals(this.author, advertisementDto.author) &&
        Objects.equals(this.publicationDate, advertisementDto.publicationDate) &&
        Objects.equals(this.countWatch, advertisementDto.countWatch) &&
        Objects.equals(this.status, advertisementDto.status) &&
        Objects.equals(this.editDate, advertisementDto.editDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, header, description, price, category, author, publicationDate, countWatch, status, editDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvertisementDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    publicationDate: ").append(toIndentedString(publicationDate)).append("\n");
    sb.append("    countWatch: ").append(toIndentedString(countWatch)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    editDate: ").append(toIndentedString(editDate)).append("\n");
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
