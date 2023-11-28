package com.planetarium.planetarium.stars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import jakarta.validation.Valid;

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

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @PostMapping
  public ResponseEntity<Star> createStar(@RequestBody StarCreateDTO data) {
    Star newStar = this.starService.createStar(data);
    return new ResponseEntity<Star>(newStar, HttpStatus.CREATED);
  }
}
