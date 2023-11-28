package com.planetarium.planetarium.jwt;

import lombok.Getter;
import lombok.Setter;

public class JwToken {

  @Getter
  @Setter
  private String token;

  public JwToken() {
  }

  public JwToken(String token) {
    this.token = token;
  }

}
