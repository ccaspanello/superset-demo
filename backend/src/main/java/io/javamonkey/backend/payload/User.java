package io.javamonkey.backend.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class User {

  private String username;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

}
