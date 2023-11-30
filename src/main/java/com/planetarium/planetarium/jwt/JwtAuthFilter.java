package com.planetarium.planetarium.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.planetarium.planetarium.user.User;
import com.planetarium.planetarium.user.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

  @Autowired
  private JwtService jwtService;

  @Autowired
  private UserService userService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String authHeader = request.getHeader("Authorization");

    // Fast fail if the JWT doesn't exist
    if (authHeader == null || !authHeader.startsWith("Bearer")) {
      filterChain.doFilter(request, response);
      return;
    }

    String jwToken = authHeader.substring(7);
    // Get the userId so we can find the user in the database
    Long userId = this.jwtService.extractUserId(jwToken);
    // If user id exists in token, and has not been saved in SecurityContextHolder,
    // then proceed with verification
    if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      // Find the user in the database
      User foundUser = this.userService.getById(userId);
      // Double check that the token is valid and not expired
      if (this.jwtService.isTokenValid(jwToken, foundUser)) {
        // Save the user in SecurityContextHolder so Spring knows we can show
        UsernamePasswordAuthenticationToken userPassToken = new UsernamePasswordAuthenticationToken(foundUser, null,
            foundUser.getAuthorities());
        // This code adds some extra details based on the request, such as time the
        // request came in, IP, cookies, etc. as examples.
        userPassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // Finally let SecurityContextHolder know
        SecurityContextHolder.getContext().setAuthentication(userPassToken);
      }
    }

    // Pass onto the next filter in the chain, regardless of outcome
    filterChain.doFilter(request, response);
  }

}
