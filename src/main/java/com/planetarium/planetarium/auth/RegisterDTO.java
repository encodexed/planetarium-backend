package com.planetarium.planetarium.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {

  @NotBlank
  private String username;

  @NotBlank
  private String email;

  @NotBlank
  private String password;
}
