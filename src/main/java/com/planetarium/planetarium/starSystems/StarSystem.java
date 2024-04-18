package com.planetarium.planetarium.starSystems;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

  @JoinColumn(name = "first_arrival_user_id")
  @ManyToOne
  private User firstArrivalUserId;

  @Column(name = "first_arrival_at")
  private Date firstArrivalAt;

  @JoinColumn(name = "first_explored_user_id")
  @ManyToOne
  private User firstExploredUserId;

  @Column(name = "first_explored_at")
  private Date firstExploredAt;

  @JoinColumn(name = "first_colonised_user_id")
  @ManyToOne
  private User firstColonisedUserId;

  @Column(name = "first_colonised_at")
  private Date firstColonisedAt;

  @Column(name = "date_instantiated")
  private Date dateInstantiated;

  @OneToMany(mappedBy = "starSystem", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Star> stars;

  public StarSystem(
    String name,
    int coordinateX,
    int coordinateY,
    int coordinateZ,
    Date dateInstantiated,
    User firstArrivalUserId,
    Date firstArrivalAt,
    User firstExploredUserId,
    Date firstExploredAt,
    User firstColonisedUserId,
    Date firstColonisedAt
  ) {
    this.name = name;
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
    this.coordinateZ = coordinateZ;
    this.dateInstantiated = dateInstantiated;
    this.firstArrivalUserId = firstArrivalUserId;
    this.firstArrivalAt = firstArrivalAt;
    this.firstExploredUserId = firstExploredUserId;
    this.firstExploredAt = firstArrivalAt;
    this.firstColonisedUserId = firstColonisedUserId;
    this.firstColonisedAt = firstColonisedAt;
    this.dateInstantiated = new Date();
  }
}
