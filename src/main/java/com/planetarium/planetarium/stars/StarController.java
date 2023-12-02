package com.planetarium.planetarium.stars;

import com.planetarium.planetarium.utils.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  @PostMapping("/gen")
  public ResponseEntity<Star> generateStar() {
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

  @GetMapping("/read")
  public void read() throws FileNotFoundException {
    try {
      Utils.getPhoneticOptions();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
}
