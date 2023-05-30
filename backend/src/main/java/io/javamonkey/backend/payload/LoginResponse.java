package io.javamonkey.backend.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponse {

  @JsonProperty("access_token")
  private String accessToken;

  @JsonProperty("refresh_token")
  private String refreshToken;
}
