package com.planetarium.planetarium.starSystems;

import com.planetarium.planetarium.stars.Star;
import com.planetarium.planetarium.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "star_systems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StarSystem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  @Column(name = "coordinate_x")
  private int coordinateX;

  @Column(name = "coordinate_y")
  private int coordinateY;

  @Column(name = "coordinate_z")
  private int coordinateZ;

  @JoinColumn(name = "first_arrival_by")
  @ManyToOne
  private User firstArrivalBy;

  @Column(name = "first_arrival_at")
  private Date firstArrivalAt;

  @JoinColumn(name = "first_explored_by")
  @ManyToOne
  private User firstExploredBy;

  @Column(name = "first_explored_at")
  private Date firstExploredAt;

  @JoinColumn(name = "first_colonised_by")
  @ManyToOne
  private User firstColonisedBy;

  @Column(name = "first_colonised_at")
  private Date firstColonisedAt;

  @Column(name = "date_instantiated")
  private Date dateInstantiated;

  @OneToMany(mappedBy = "starSystem", cascade = CascadeType.ALL)
  @Column
  private List<Star> stars;

  public StarSystem(
    String name,
    int coordinateX,
    int coordinateY,
    int coordinateZ,
    User firstArrivalBy,
    Date firstArrivalAt,
    User firstExploredBy,
    Date firstExploredAt,
    User firstColonisedBy,
    Date firstColonisedAt
  ) {
    this.name = name;
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
    this.coordinateZ = coordinateZ;
    this.firstArrivalBy = firstArrivalBy;
    this.firstArrivalAt = firstArrivalAt;
    this.firstExploredBy = firstExploredBy;
    this.firstExploredAt = firstArrivalAt;
    this.firstColonisedBy = firstColonisedBy;
    this.firstColonisedAt = firstColonisedAt;
    this.dateInstantiated = new Date();
  }
}
