package com.planetarium.planetarium.stars;

import jakarta.transaction.Transactional;

import java.io.FileNotFoundException;
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

  public Star createStar() throws FileNotFoundException {
    Star starBlueprint = StarUtilities.generateRandomStar();
    return this.starRepository.save(starBlueprint);
  }

  public void createNamedStar(String sysName, Long sysId) throws FileNotFoundException {
    List<String> takenStarNames = getStarNamesOfSystem(sysId);
    String newStarName = StarUtilities.generateNextStarName(sysName, takenStarNames);
    Star starBlueprint = StarUtilities.generateRandomStar(newStarName);
    this.starRepository.save(starBlueprint);
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

  public List<String> getStarNamesOfSystem(Long sysId) {
//    List<Star> starsInSystem = this.starRepository.getStarsOfSystem(sysId);
//    return starsInSystem.stream().map(Star::getName).toList();
    return this.starRepository.getStarsOfSystem(sysId);
  }
}
