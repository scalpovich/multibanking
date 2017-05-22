/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.20.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.InlineResponse20015Users;
import io.swagger.client.model.InlineResponse2002Paging;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for users information with paging info
 */
@ApiModel(description = "Container for users information with paging info")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse20015 {
  @SerializedName("users")
  private List<InlineResponse20015Users> users = new ArrayList<InlineResponse20015Users>();

  @SerializedName("paging")
  private InlineResponse2002Paging paging = null;

  public InlineResponse20015 users(List<InlineResponse20015Users> users) {
    this.users = users;
    return this;
  }

  public InlineResponse20015 addUsersItem(InlineResponse20015Users usersItem) {
    this.users.add(usersItem);
    return this;
  }

   /**
   * List of users information
   * @return users
  **/
  @ApiModelProperty(example = "null", required = true, value = "List of users information")
  public List<InlineResponse20015Users> getUsers() {
    return users;
  }

  public void setUsers(List<InlineResponse20015Users> users) {
    this.users = users;
  }

  public InlineResponse20015 paging(InlineResponse2002Paging paging) {
    this.paging = paging;
    return this;
  }

   /**
   * Get paging
   * @return paging
  **/
  @ApiModelProperty(example = "null", value = "")
  public InlineResponse2002Paging getPaging() {
    return paging;
  }

  public void setPaging(InlineResponse2002Paging paging) {
    this.paging = paging;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20015 inlineResponse20015 = (InlineResponse20015) o;
    return Objects.equals(this.users, inlineResponse20015.users) &&
        Objects.equals(this.paging, inlineResponse20015.paging);
  }

  @Override
  public int hashCode() {
    return Objects.hash(users, paging);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20015 {\n");
    
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    paging: ").append(toIndentedString(paging)).append("\n");
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
