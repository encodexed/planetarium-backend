package com.planetarium.planetarium.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planetarium.planetarium.jwt.JwToken;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<JwToken> register(@RequestBody RegisterDTO data) {
    return new ResponseEntity<>(this.authService.register(data), HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<JwToken> login(@RequestBody LoginDTO data) {
    return new ResponseEntity<>(this.authService.login(data), HttpStatus.OK);
  }

}
