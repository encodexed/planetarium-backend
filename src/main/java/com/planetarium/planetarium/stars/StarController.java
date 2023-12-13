package com.planetarium.planetarium.stars;

import com.planetarium.planetarium.exceptions.NotFoundException;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stars")
public class StarController {

  @Autowired
  private StarService starService;

  @GetMapping
  public ResponseEntity<List<Star>> getAll() {
    List<Star> allStars = this.starService.getAll();
    return new ResponseEntity<>(allStars, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Star> getStarById(@PathVariable Long id) {
    Star foundStar = this.starService.getById(id);
    if (foundStar == null) {
      throw new NotFoundException(
        String.format("Star with id: %d does not exist", id)
      );
    }
    return new ResponseEntity<Star>(foundStar, HttpStatus.OK);
  }

  @PostMapping("/gen")
  public ResponseEntity<Star> generateStar() throws FileNotFoundException {
    Star starBlueprint = StarUtilities.generateRandomStar();
    Star createdStar = this.starService.createStar(starBlueprint);
    return new ResponseEntity<Star>(createdStar, HttpStatus.CREATED);
  }

  @PostMapping("/cus")
  public ResponseEntity<Star> createCustomStar(
    @RequestBody CustomStarDTO data
  ) {
    Star newStar = this.starService.createStar(data);
    return new ResponseEntity<Star>(newStar, HttpStatus.CREATED);
  }
}
