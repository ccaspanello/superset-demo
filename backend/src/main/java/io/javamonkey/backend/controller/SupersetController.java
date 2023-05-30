package io.javamonkey.backend.controller;

import io.javamonkey.backend.payload.LoginRequest;
import io.javamonkey.backend.payload.LoginResponse;
import io.javamonkey.backend.payload.GuestTokenRequest;
import io.javamonkey.backend.payload.Resource;
import io.javamonkey.backend.payload.User;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class SupersetController {

  private final String rootUrl = "http://localhost:8088/api/v1";
  private final String username = "admin";
  private final String password = "admin";

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/hello")
  public String hello() {
    return "Hello World!";
  }

  @GetMapping("/api/token/{dashboardId}")
  public ResponseEntity<?> token(@PathVariable("dashboardId") String dashboardId) {
    LoginResponse loginResponse = login();
    GuestTokenRequest guestTokenRequest = GuestTokenRequest.builder()
        .user(User.builder().username("admin").firstName("Superset").lastName("Admin").build())
        .resources(Collections.singletonList(Resource.builder().id(dashboardId).type("dashboard").build()))
        .build();
    log.info("{}",guestTokenRequest);
    HttpHeaders headers = createHeaders(loginResponse);
    HttpEntity<GuestTokenRequest> body = new HttpEntity<>(guestTokenRequest, headers);
    String url = rootUrl + "/security/guest_token";
    return restTemplate.exchange(url, HttpMethod.POST, body, String.class);
  }

  private HttpHeaders createHeaders(LoginResponse loginResponse) {
    log.info("Login: {}", loginResponse);
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.set("Authorization", "Bearer " +loginResponse.getAccessToken());
    return headers;
  }

  private LoginResponse login() {
    LoginRequest loginRequest = LoginRequest.builder()
        .username(username)
        .password(password)
        .build();
    String url = rootUrl + "/security/login";
    return restTemplate.postForEntity(url, loginRequest, LoginResponse.class).getBody();
  }

}
