
package io.javamonkey.backend.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GuestTokenResponse {
  private String token;
}
