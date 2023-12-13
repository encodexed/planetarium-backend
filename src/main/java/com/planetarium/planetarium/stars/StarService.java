package com.planetarium.planetarium.stars;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StarService {

  @Autowired
  private StarRepository starRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<Star> getAll() {
    return this.starRepository.findAll();
  }

  public Star createStar(Star data) {
    return this.starRepository.save(data);
  }

  public Star createStar(CustomStarDTO data) {
    Star newStar = modelMapper.map(data, Star.class);
    return this.starRepository.save(newStar);
  }

  public Star getById(Long id) {
    return this.starRepository.findById(id).orElse(null);
  }

  public Optional<Star> replaceById(Long id, UpdateStarDTO data) {
    Optional<Star> foundStar = this.starRepository.findById(id);

    if (foundStar.isPresent()) {
      Star starToReplace = foundStar.get();
      modelMapper.map(data, starToReplace);
      Star replacedStar = this.starRepository.save(starToReplace);
      return Optional.of(replacedStar);
    }

    return foundStar;
  }

  public boolean deleteById(Long id) {
    Optional<Star> foundStar = this.starRepository.findById(id);

    if (foundStar.isPresent()) {
      this.starRepository.delete(foundStar.get());
      return true;
    }

    return false;
  }
}
