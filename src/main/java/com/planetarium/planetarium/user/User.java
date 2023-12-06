package com.planetarium.planetarium.user;

import com.planetarium.planetarium.starSystems.StarSystem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Extending UserDetails will help us use DAO Authentication Manager
@Entity
@Table(name = "users")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long id;

  @Getter
  @Column(unique = true)
  private String email;

  @Column(unique = true)
  private String username;

  @Column
  private String password;

  @Getter
  @Enumerated(EnumType.STRING)
  @Column
  private Role role;

  @OneToMany(mappedBy = "firstArrivalBy", cascade = CascadeType.ALL)
  @Column(name = "star_systems_first_arrived_to")
  private List<StarSystem> starSystemsFirstArrivedTo = new ArrayList<>();

  @OneToMany(mappedBy = "firstExploredBy", cascade = CascadeType.ALL)
  @Column(name = "star_systems_first_explored")
  private List<StarSystem> starSystemsFirstExplored = new ArrayList<>();

  @OneToMany(mappedBy = "firstColonisedBy", cascade = CascadeType.ALL)
  @Column(name = "star_systems_first_arrived_to")
  private List<StarSystem> starSystemsFirstColonised = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(this.role.name()));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  public User() {}

  public User(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
    this.role = Role.ROLE_ADMIN;
  }
}
