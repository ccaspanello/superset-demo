package io.javamonkey.backend.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class Resource {

  private String id;
  private String type;

}
