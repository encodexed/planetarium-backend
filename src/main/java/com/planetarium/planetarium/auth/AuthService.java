package com.planetarium.planetarium.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

  @Autowired
  private AuthenticationManager authenticationManager;

  public JwToken register(RegisterDTO data) {
    // Overwrite plain text password with encoded password
    String encodedPassword = passwordEncoder.encode(data.getPassword());
    data.setPassword(encodedPassword);

    User newUser = this.userService.create(data);

    String token = this.jwtService.generateToken(newUser);
    return new JwToken(token);
  }

  public JwToken login(LoginDTO data) {
    UsernamePasswordAuthenticationToken userPasswordToken = new UsernamePasswordAuthenticationToken(data.getUsername(),
        data.getPassword());

    authenticationManager.authenticate(userPasswordToken);

    User user = this.userService.getByUsername(data.getUsername());

    if (user == null) {
      return null;
    }

    return new JwToken(this.jwtService.generateToken(user));
  }
}
