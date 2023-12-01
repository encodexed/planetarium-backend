package com.planetarium.planetarium.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetarium.planetarium.auth.RegisterDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User create(RegisterDTO data) {
    User newUser = new User(data.getEmail(), data.getUsername(), data.getPassword());
    return this.userRepository.save(newUser);
  }

  public User getById(Long id) {
    User foundUser = this.userRepository.findById(id).orElse(null);
    return foundUser;
  }

  public User getByUsername(String username) {
    return this.userRepository.findByUsername(username).orElse(null);
  }
}
