package io.javamonkey.backend.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {

  private String username;

  private String password;

  @Builder.Default
  private String provider = "db";

  @Builder.Default
  private boolean refresh = true;
}
