package com.planetarium.planetarium.starSystems;

import com.planetarium.planetarium.stars.StarUtilities;
import jakarta.transaction.Transactional;

import java.io.FileNotFoundException;
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

  public StarSystem createStarSystem() throws FileNotFoundException {
    StarSystem starSystemBlueprint = StarUtilities.generateRandomStarSystem();
    return this.starSystemRepository.save(starSystemBlueprint);
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

  public boolean deleteById(Long id) {
    Optional<StarSystem> foundStarSystem =
      this.starSystemRepository.findById(id);

    if (foundStarSystem.isPresent()) {
      this.starSystemRepository.delete(foundStarSystem.get());
      return true;
    }

    return false;
  }
}
