package io.javamonkey.backend.payload;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class GuestTokenRequest {

  private User user;

  @Builder.Default
  private List<Resource> resources = new ArrayList<>();

  @Builder.Default
  private List<RlsRule> rls = new ArrayList<>();

}
