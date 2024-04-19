package com.planetarium.planetarium.stars;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StarRepository extends JpaRepository<Star, Long> {
  @Query(value = "SELECT name FROM stars WHERE star_system_id = :sysId", nativeQuery = true)
  List<String> getStarsOfSystem(@Param("sysId") Long id);

  @Query(value = "SELECT * FROM stars ORDER BY date_instantiated DESC LIMIT 1", nativeQuery = true)
  Optional<Star> findLastCreatedStar();

  Optional<Star> findById(Long id);
}
