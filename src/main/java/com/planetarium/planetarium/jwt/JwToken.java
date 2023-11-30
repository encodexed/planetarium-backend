package com.planetarium.planetarium.jwt;

import lombok.Getter;
import lombok.Setter;

public class JwToken {

  // Frontend should add a JWT to the cookies to make it safer

  @Getter
  @Setter
  private String token;

  public JwToken() {
  }

  public JwToken(String token) {
    this.token = token;
  }

}
