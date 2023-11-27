package com.planetarium.planetarium.stars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
