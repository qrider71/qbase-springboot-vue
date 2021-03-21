package com.mre.ping.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The reponse fromn a ping request
 */
@ApiModel(description = "The reponse fromn a ping request")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-21T17:41:51.691431+01:00[Europe/Berlin]")
public class PingResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("timestamp")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  @JsonProperty("hostname")
  private JsonNullable<String> hostname = JsonNullable.undefined();

  @JsonProperty("messages")
  @Valid
  private List<String> messages = null;

  public PingResponse timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * execution timestamp
   * @return timestamp
  */
  @ApiModelProperty(value = "execution timestamp")

  @Valid

  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public PingResponse hostname(String hostname) {
    this.hostname = JsonNullable.of(hostname);
    return this;
  }

  /**
   * Name of the host where on which ping was executed. It can be empty if name could not be determined.
   * @return hostname
  */
  @ApiModelProperty(value = "Name of the host where on which ping was executed. It can be empty if name could not be determined.")


  public JsonNullable<String> getHostname() {
    return hostname;
  }

  public void setHostname(JsonNullable<String> hostname) {
    this.hostname = hostname;
  }

  public PingResponse messages(List<String> messages) {
    this.messages = messages;
    return this;
  }

  public PingResponse addMessagesItem(String messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * list with returned messages from ping
   * @return messages
  */
  @ApiModelProperty(value = "list with returned messages from ping")

@Size(min=0) 
  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PingResponse pingResponse = (PingResponse) o;
    return Objects.equals(this.timestamp, pingResponse.timestamp) &&
        Objects.equals(this.hostname, pingResponse.hostname) &&
        Objects.equals(this.messages, pingResponse.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, hostname, messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PingResponse {\n");
    
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

