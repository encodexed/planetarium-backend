package com.planetarium.planetarium.jwt;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import com.planetarium.planetarium.user.User;

@Component
public class JwtService {

  public String generateToken(User user) {
    String userId = Long.toString(user.getId());

    return Jwts
        .builder()
        .setClaims(null)
        .setSubject(userId)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 3600))
        .signWith(this.getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  private Key getSignInKey() {
    // ! Change and hide this secret with dotenv or similar when you figure out the
    // ! problem
    String secret = "64fbb35b471ec1c6a3267c60f810c8c6fa53825148577b016a96e5e518d6d7b2";
    byte[] keyBytes = Decoders.BASE64.decode(secret);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(this.getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public Long extractUserId(String token) {
    return Long.parseLong(this.extractAllClaims(token).getSubject());
  }

  public Date extractExpiration(String token) {
    return this.extractAllClaims(token).getExpiration();
  }

  public boolean isTokenValid(String token, User user) {
    // Check if the token is expired or not
    // Check if the userId is equal to the extracted id
    boolean idEqualsUserId = this.extractUserId(token).equals(user.getId());
    boolean isTokenExpired = this.extractExpiration(token).before(new Date());

    return (idEqualsUserId && !isTokenExpired);
  }
}
