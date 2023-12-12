package com.planetarium.planetarium.stars;

import com.planetarium.planetarium.starSystems.StarSystem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

  @JoinColumn(name = "star_system_id")
  @ManyToOne
  private StarSystem starSystem;

  @Column
  @Enumerated(EnumType.STRING)
  private StellarClass stellar_class;

  @Column
  private int surface_temperature_k;

  @Column
  private float solar_masses;

  @Column
  private float solar_radii;

  // Custom Constructors

  public Star(String name, StellarClass stellarClass) {
    this.name = name;
    this.stellar_class = stellarClass;
  }

  // Omits Id field in construction
  public Star(
    String name,
    StellarClass stellarClass,
    int surfaceTemperatureK,
    float solarMasses,
    float solarRadii
  ) {
    this.name = name;
    this.stellar_class = stellarClass;
    this.surface_temperature_k = surfaceTemperatureK;
    this.solar_masses = solarMasses;
    this.solar_radii = solarRadii;
  }
}
