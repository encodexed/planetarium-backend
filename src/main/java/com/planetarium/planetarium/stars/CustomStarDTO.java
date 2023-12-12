package com.planetarium.planetarium.stars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomStarDTO {

  private String name;

  private StellarClass stellar_class;

  private int surface_temperature_k;

  private float solar_masses;

  private int solar_radii;
}
