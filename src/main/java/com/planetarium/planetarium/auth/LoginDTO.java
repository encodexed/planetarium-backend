package com.planetarium.planetarium.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

  // Validation sort of works currently, but doesn't display quite right in the
  // error messages, possibly due to our overriding CustomAuthExceptionHandler

  @NotBlank
  private String username;

  @NotBlank
  private String password;
}
