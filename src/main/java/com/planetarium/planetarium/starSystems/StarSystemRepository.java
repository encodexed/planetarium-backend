package com.planetarium.planetarium.starSystems;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarSystemRepository extends JpaRepository<StarSystem, Long> {
  Optional<StarSystem> findById(Long id);
}
