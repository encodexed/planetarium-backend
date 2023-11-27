package com.planetarium.planetarium.stars;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stars")
@Getter
@Setter
public class Star {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String name;

  @Column
  private StellarClass stellar_class;

  @Column
  private int coordinateX;

  @Column
  private int coordinateY;

  @Column
  private int coordinateZ;

  @Column
  private boolean is_main_star;

  @Column
  private int surface_temperature_K;

  @Column
  private float solar_masses;

  @Column
  private int orbits_star_id;

  @Column
  private int radius_Km;

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

  // Construction

  public Star() {
  }

  public Star(String name, StellarClass stellarClass) {
    this.name = name;
    this.stellar_class = stellarClass;
  }
}
