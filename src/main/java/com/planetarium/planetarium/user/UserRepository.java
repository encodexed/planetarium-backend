package com.planetarium.planetarium.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  // Spring takes care of this if you use the right syntax, in this case
  // "findBy(Column)"
  Optional<User> findByUsername(String username);
}
