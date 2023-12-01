package com.planetarium.planetarium.stars;

import java.util.Date;

import com.planetarium.planetarium.utils.Utils;

public class StarUtilities {

  public static Star generateRandomStar() {
    String name = generateRandomStarName();
    StellarClass stellarClass = generateRandomStellarClass();
    int coordinateX = generateRandomCoordinate();
    int coordinateY = generateRandomCoordinate();
    int coordinateZ = generateRandomCoordinate();
    int surfaceTemperatureK = generateSurfaceTemperature();
    float solarMasses = generateSolarMasses();
    float solarRadii = generateRadii();
    Date now = new Date();

    return new Star(name, stellarClass, coordinateX, coordinateY, coordinateZ, surfaceTemperatureK,
        solarMasses, solarRadii, 1, now, 1, now, 1, now);
  }

  private static float generateRadii() {
    return 1.00f;
  }

  private static float generateSolarMasses() {
    return 1.00f;
  }

  // This needs to be unique
  public static String generateRandomStarName() {
    // Generates a random number between 3 and 14 characters
    int length = (int) Utils.randomNumber(3, 11);

    // Generates random letters
    char[] letters = new char[length];
    for (int i = 0; i < length; i++) {
      char letter = Utils.randomChar();
      letters[i] = letter;
    }

    String name = new String(letters);
    String capitalised = name.substring(0, 1).toUpperCase().concat(name.substring(1));
    return capitalised;
  }

  public static StellarClass generateRandomStellarClass() {
    return StellarClass.M;
  }

  // Generates a random integer between -100 and 100
  public static int generateRandomCoordinate() {
    return (int) (Math.floor(Math.random() * 200 - 100));
  }

  public static int generateSurfaceTemperature() {
    return 666;
  }
}
