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
}
