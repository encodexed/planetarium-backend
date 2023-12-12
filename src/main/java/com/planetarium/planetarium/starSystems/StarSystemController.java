package com.planetarium.planetarium.starSystems;

import com.planetarium.planetarium.stars.StarUtilities;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
