package com.planetarium.planetarium.starSystems;

import com.planetarium.planetarium.exceptions.NotFoundException;
import com.planetarium.planetarium.stars.StarUtilities;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/star_systems")
public class StarSystemController {

  @Autowired
  private StarSystemService starSystemService;

  @GetMapping
  public ResponseEntity<List<StarSystem>> getAll() {
    List<StarSystem> allStarSystems = this.starSystemService.getAll();
    return new ResponseEntity<>(allStarSystems, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<StarSystem> getStarSystemById(@PathVariable Long id) {
    StarSystem foundStarSystem = this.starSystemService.getById(id);
    if (foundStarSystem == null) {
      throw new NotFoundException(
        String.format("Star System with id: %d does not exist", id)
      );
    }
    return new ResponseEntity<StarSystem>(foundStarSystem, HttpStatus.OK);
  }

  @PostMapping("/gen")
  public ResponseEntity<StarSystem> generateStarSystem()
    throws FileNotFoundException {
    StarSystem starSystemBlueprint = StarUtilities.generateRandomStarSystem();
    StarSystem createdStarSystem =
      this.starSystemService.createStarSystem(starSystemBlueprint);
    return new ResponseEntity<StarSystem>(
      createdStarSystem,
      HttpStatus.CREATED
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<StarSystem> updateStarSystem(
    @PathVariable Long id,
    @RequestBody UpdateStarSystemDTO data
  ) {
    Optional<StarSystem> replacedStarSystem =
      this.starSystemService.replaceById(id, data);

    if (replacedStarSystem.isPresent()) {
      return new ResponseEntity<>(replacedStarSystem.get(), HttpStatus.OK);
    }

    throw new NotFoundException(
      String.format(
        "Could not update Star System with id: %d because it does not exist",
        id
      )
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<StarSystem> deleteStarSystem(@PathVariable Long id) {
    boolean isStarSystemDeleted = this.starSystemService.deleteById(id);
    if (isStarSystemDeleted == true) {
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    throw new NotFoundException(
      String.format(
        "Could not delete Star System with id: %d because it does not exist",
        id
      )
    );
  }
}
