package com.planetarium.planetarium.stars;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomStarDTO {

  @NotBlank
  private String name;

  @NotBlank
  private StellarClass stellar_class;

  @NotBlank
  private int coordinate_x;

  @NotBlank
  private int coordinate_y;

  @NotBlank
  private int coordinate_z;

  private int surface_temperature_k;

  private float solar_masses;

  private int solar_radii;

  // User-related data

  private int first_discovered_by;

  private Date first_discovered;

  private int first_explored_by;

  private Date first_explored;

  private int first_colonised_by;

  private Date first_colonised;
}
