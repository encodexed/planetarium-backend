package com.planetarium.planetarium.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.planetarium.planetarium.jwt.JwToken;
import com.planetarium.planetarium.jwt.JwtService;
import com.planetarium.planetarium.user.User;
import com.planetarium.planetarium.user.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthService {

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtService jwtService;

  public JwToken register(RegisterDTO data) {
    // Overwrite plain text password with encoded password
    String encodedPassword = passwordEncoder.encode(data.getPassword());
    data.setPassword(encodedPassword);

    User newUser = this.userService.create(data);

    String token = this.jwtService.generateToken(newUser);
    System.out.println("TOKEN: " + token);
    return new JwToken(token);
  }

}
