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
  // private Long first_arrival_user_id;

  // private Date first_arrival_at;

  // private Long first_explored_user_id;

  // private Date first_explored_at;

  // private Long first_colonised_user_id;

  // private Date first_colonised_at;
}
