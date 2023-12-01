package com.planetarium.planetarium.stars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StarService {

  @Autowired
  private StarRepository starRepository;

  public List<Star> getAll() {
    return this.starRepository.findAll();
  }

  public Star createStar(Star data) {
    return this.starRepository.save(data);
  }

  public Star createStar(CustomStarDTO data) {
    String name = data.getName();
    StellarClass stellarClass = data.getStellarClass();
    return this.starRepository.save(new Star(name, stellarClass));
  }
}
