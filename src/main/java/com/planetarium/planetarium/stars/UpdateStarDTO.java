package com.planetarium.planetarium.stars;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStarDTO {

  @Pattern(regexp = "^(?=\\S).*$", message = "'name' cannot be empty")
  private String name;

  @Pattern(regexp = "^(?=\\S).*$", message = "'stellar_class' cannot be empty")
  private StellarClass stellar_class;

  @Pattern(
    regexp = "^\\d+$",
    message = "'surface_temperature_k' must be an unsigned integer"
  )
  private int surface_temperature_k;

  @Pattern(
    regexp = "[+-]?([0-9]*[.])?[0-9]+",
    message = "'solar_masses' must be a floating point compatible number"
  )
  private float solar_masses;

  @Pattern(
    regexp = "[+-]?([0-9]*[.])?[0-9]+",
    message = "'solar_radii' must be a floating point compatible number"
  )
  private float solar_radii;
  // private Long starSystem;
}
