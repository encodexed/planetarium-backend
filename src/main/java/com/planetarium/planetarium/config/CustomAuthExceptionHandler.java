package com.planetarium.planetarium.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthExceptionHandler implements AuthenticationEntryPoint {

  // We have access to the request, the response and the exception thrown by the
  // application when something goes wrong
  @Override
  public void commence(
    HttpServletRequest request,
    HttpServletResponse response,
    AuthenticationException authException
  ) throws IOException, ServletException {
    response.setStatus(this.determineStatusCode(authException));
    response.setHeader(
      HttpHeaders.CONTENT_TYPE,
      MediaType.APPLICATION_JSON_VALUE
    );
    response
      .getWriter()
      .write("{ \"message\": \"" + authException.getMessage() + "\" }");
  }

  private int determineStatusCode(AuthenticationException authException) {
    if (authException instanceof BadCredentialsException) {
      // 400
      return HttpServletResponse.SC_BAD_REQUEST;
    }

    if (authException instanceof InsufficientAuthenticationException) {
      return HttpServletResponse.SC_UNAUTHORIZED;
    }

    // 401
    return HttpServletResponse.SC_FORBIDDEN;
  }
}
