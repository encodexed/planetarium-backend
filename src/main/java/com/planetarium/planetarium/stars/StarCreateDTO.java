package com.planetarium.planetarium.stars;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class StarCreateDTO {

  @Getter
  @Setter
  @NotBlank
  private String name;

  @Getter
  @Setter
  @NotBlank
  private StellarClass stellarClass;

  public StarCreateDTO(String name, StellarClass stellarClass) {
    this.name = name;
    this.stellarClass = stellarClass;
  }
}
