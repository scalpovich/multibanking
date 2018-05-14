/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.46.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Container for a bank connection owner&#39;s data
 */
@ApiModel(description = "Container for a bank connection owner's data")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-14T19:12:52.919Z")
public class BankConnectionOwner {
  @SerializedName("firstName")
  private String firstName = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("salutation")
  private String salutation = null;

  @SerializedName("title")
  private String title = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("dateOfBirth")
  private String dateOfBirth = null;

  @SerializedName("postCode")
  private String postCode = null;

  @SerializedName("country")
  private String country = null;

  @SerializedName("city")
  private String city = null;

  @SerializedName("street")
  private String street = null;

  @SerializedName("houseNumber")
  private String houseNumber = null;

  public BankConnectionOwner firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * First name
   * @return firstName
  **/
  @ApiModelProperty(value = "First name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public BankConnectionOwner lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Last name
   * @return lastName
  **/
  @ApiModelProperty(value = "Last name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public BankConnectionOwner salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

   /**
   * Salutation
   * @return salutation
  **/
  @ApiModelProperty(value = "Salutation")
  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public BankConnectionOwner title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Title
   * @return title
  **/
  @ApiModelProperty(value = "Title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BankConnectionOwner email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email
   * @return email
  **/
  @ApiModelProperty(value = "Email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public BankConnectionOwner dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

   /**
   * Date of birth (in format &#39;yyyy-MM-dd&#39;)
   * @return dateOfBirth
  **/
  @ApiModelProperty(value = "Date of birth (in format 'yyyy-MM-dd')")
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public BankConnectionOwner postCode(String postCode) {
    this.postCode = postCode;
    return this;
  }

   /**
   * Post code
   * @return postCode
  **/
  @ApiModelProperty(value = "Post code")
  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public BankConnectionOwner country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Country
   * @return country
  **/
  @ApiModelProperty(value = "Country")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public BankConnectionOwner city(String city) {
    this.city = city;
    return this;
  }

   /**
   * City
   * @return city
  **/
  @ApiModelProperty(value = "City")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public BankConnectionOwner street(String street) {
    this.street = street;
    return this;
  }

   /**
   * Street
   * @return street
  **/
  @ApiModelProperty(value = "Street")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public BankConnectionOwner houseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
    return this;
  }

   /**
   * House number
   * @return houseNumber
  **/
  @ApiModelProperty(value = "House number")
  public String getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankConnectionOwner bankConnectionOwner = (BankConnectionOwner) o;
    return Objects.equals(this.firstName, bankConnectionOwner.firstName) &&
        Objects.equals(this.lastName, bankConnectionOwner.lastName) &&
        Objects.equals(this.salutation, bankConnectionOwner.salutation) &&
        Objects.equals(this.title, bankConnectionOwner.title) &&
        Objects.equals(this.email, bankConnectionOwner.email) &&
        Objects.equals(this.dateOfBirth, bankConnectionOwner.dateOfBirth) &&
        Objects.equals(this.postCode, bankConnectionOwner.postCode) &&
        Objects.equals(this.country, bankConnectionOwner.country) &&
        Objects.equals(this.city, bankConnectionOwner.city) &&
        Objects.equals(this.street, bankConnectionOwner.street) &&
        Objects.equals(this.houseNumber, bankConnectionOwner.houseNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, salutation, title, email, dateOfBirth, postCode, country, city, street, houseNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankConnectionOwner {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    houseNumber: ").append(toIndentedString(houseNumber)).append("\n");
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
