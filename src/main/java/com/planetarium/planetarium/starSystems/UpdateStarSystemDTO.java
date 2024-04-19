package com.planetarium.planetarium.starSystems;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStarSystemDTO {

  @Pattern(regexp = "^(?=\\S).*$", message = "'name' cannot be empty")
  private String name;

  @Pattern(
    regexp = "^-?[0-9]\\d*$",
    message = "'coordinate_x' must be an integer"
  )
  private int coordinateX;

  @Pattern(
    regexp = "^-?[0-9]\\d*$",
    message = "'coordinate_x' must be an integer"
  )
  private int coordinateY;

  @Pattern(
    regexp = "^-?[0-9]\\d*$",
    message = "'coordinate_x' must be an integer"
  )
  private int coordinateZ;
}
