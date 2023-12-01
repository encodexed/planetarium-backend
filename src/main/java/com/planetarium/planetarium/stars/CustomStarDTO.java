package com.planetarium.planetarium.stars;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
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
  private StellarClass stellarClass;

  @NotBlank
  private int coordinateX;

  @NotBlank
  private int coordinateY;

  @NotBlank
  private int coordinateZ;

  @NotBlank
  private boolean is_main_star;

  private int surface_temperature_K;

  private float solar_masses;

  private int orbits_star_id;

  private int radius_Km;

  // User-related data

  private int first_discovered_by;

  private Date first_discovered;

  private int first_explored_by;

  private Date first_explored;

  private int first_colonised_by;

  private Date first_colonised;
}
