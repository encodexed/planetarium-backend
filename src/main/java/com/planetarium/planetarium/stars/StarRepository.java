package com.planetarium.planetarium.stars;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Long> {
  Optional<Star> findById(Long id);
}
