package com.planetarium.planetarium.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Need to add validation library and validate it
public class RegisterDTO {

  private String username;

  private String email;

  private String password;
}
