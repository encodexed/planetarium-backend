package com.planetarium.planetarium.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.planetarium.planetarium.jwt.JwtAuthFilter;

@Configuration
public class SecurityConfig {

  @Autowired
  private JwtAuthFilter jwtAuthFilter;

  @Autowired
  private CustomAuthExceptionHandler customAuthExceptionHandler;

  // This code was pasted from the spring security docs/github and is a
  // customisation of the default
  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

    // If there is a request to "/auth/register", the user doesn't need to be
    // authenticated. Cross-site request forgery filters are disabled for these
    // requests. Use requestMatchers(...).permitAll() to whitelist any endpoints you
    // want to be accessible without any authentication, such as sending a post
    // request to create a user account. Using stateless as a policy on httpsession
    // creation, we'll also be making sure every request being sent is individually
    // validated with the filters, rather than doing it once and then never checking
    // again
    http
        .csrf(CsrfConfigurer::disable)
        // will help display meaningful error messages
        .exceptionHandling((exception -> exception.authenticationEntryPoint(customAuthExceptionHandler)))
        .authorizeHttpRequests((requests) -> requests
            // using /auth/** can give full access to auth domain
            .requestMatchers("/auth/register").permitAll()
            .requestMatchers("/auth/login").permitAll()
            .anyRequest().authenticated())
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    return http.build();
  }
}
