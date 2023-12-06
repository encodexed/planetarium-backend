package com.planetarium.planetarium.starSystems;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
