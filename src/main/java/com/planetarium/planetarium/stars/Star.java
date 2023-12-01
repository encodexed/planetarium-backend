package com.planetarium.planetarium.stars;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Star {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  @Column
  @Enumerated(EnumType.STRING)
  private StellarClass stellar_class;

  @Column
  private int coordinate_x;

  @Column
  private int coordinate_y;

  @Column
  private int coordinate_z;

  @Column
  private int surface_temperature_k;

  @Column
  private float solar_masses;

  @Column
  private float solar_radii;

  // User-related data

  @Column
  private int first_discovered_by;

  @Column
  private Date first_discovered;

  @Column
  private int first_explored_by;

  @Column
  private Date first_explored;

  @Column
  private int first_colonised_by;

  @Column
  private Date first_colonised;

  // Custom Constructors

  public Star(String name, StellarClass stellarClass) {
    this.name = name;
    this.stellar_class = stellarClass;
  }

  // Omits Id field in construction
  public Star(
    String name,
    StellarClass stellarClass,
    int coordinateX,
    int coordinateY,
    int coordinateZ,
    int surfaceTemperatureK,
    float solarMasses,
    float solarRadii,
    int firstDiscoveredBy,
    Date firstDiscovered,
    int firstExploredBy,
    Date firstExplored,
    int firstColonisedBy,
    Date firstColonised
  ) {
    this.name = name;
    this.stellar_class = stellarClass;
    this.coordinate_x = coordinateX;
    this.coordinate_y = coordinateY;
    this.coordinate_z = coordinateZ;
    this.surface_temperature_k = surfaceTemperatureK;
    this.solar_masses = solarMasses;
    this.solar_radii = solarRadii;
    this.first_discovered_by = firstDiscoveredBy;
    this.first_discovered = firstDiscovered;
    this.first_explored_by = firstExploredBy;
    this.first_explored = firstExplored;
    this.first_colonised_by = firstColonisedBy;
    this.first_colonised = firstColonised;
  }
}
