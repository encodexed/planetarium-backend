package com.planetarium.planetarium.starSystems;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StarSystemService {

  @Autowired
  private StarSystemRepository starSystemRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<StarSystem> getAll() {
    return this.starSystemRepository.findAll();
  }

  public StarSystem createStarSystem(StarSystem data) {
    return this.starSystemRepository.save(data);
  }

  public StarSystem getById(Long id) {
    return this.starSystemRepository.findById(id).orElse(null);
  }

  public Optional<StarSystem> replaceById(Long id, UpdateStarSystemDTO data) {
    Optional<StarSystem> foundStarSystem =
      this.starSystemRepository.findById(id);

    if (foundStarSystem.isPresent()) {
      StarSystem starSystemToReplace = foundStarSystem.get();
      modelMapper.map(data, starSystemToReplace);
      StarSystem replacedStarSystem =
        this.starSystemRepository.save(starSystemToReplace);
      return Optional.of(replacedStarSystem);
    }

    return foundStarSystem;
  }
}
