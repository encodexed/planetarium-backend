package com.planetarium.planetarium.starSystems;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StarSystemService {

  @Autowired
  private StarSystemRepository starSystemRepository;

  public List<StarSystem> getAll() {
    return this.starSystemRepository.findAll();
  }

  public StarSystem createStarSystem(StarSystem data) {
    return this.starSystemRepository.save(data);
  }
}
