package com.planetarium.planetarium.starSystems;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomStarSystemDTO {

  @NotBlank
  private String name;

  private int coordinate_x;

  private int coordinate_y;

  private int coordinate_z;

  private int first_discovered_by;

  private Date first_discovered;

  private int first_explored_by;

  private Date first_explored;

  private int first_colonised_by;

  private Date first_colonised;
}
