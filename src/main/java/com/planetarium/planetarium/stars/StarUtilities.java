package com.planetarium.planetarium.stars;

import com.planetarium.planetarium.utils.Utils;
import java.io.FileNotFoundException;
import java.util.Date;

public class StarUtilities {

  public static Star generateRandomStar() throws FileNotFoundException {
    String name = generateRandomStarName();
    StellarClass stellarClass = generateRandomStellarClass();
    int coordinateX = generateRandomCoordinate();
    int coordinateY = generateRandomCoordinate();
    int coordinateZ = generateRandomCoordinate();
    int surfaceTemperatureK = generateSurfaceTemperature();
    float solarMasses = generateSolarMasses();
    float solarRadii = generateRadii();
    Date now = new Date();

    return new Star(
      name,
      stellarClass,
      coordinateX,
      coordinateY,
      coordinateZ,
      surfaceTemperatureK,
      solarMasses,
      solarRadii,
      1,
      now,
      1,
      now,
      1,
      now
    );
  }

  private static float generateRadii() {
    return 1.00f;
  }

  private static float generateSolarMasses() {
    return 1.00f;
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

  public static String generateRandomStarName() throws FileNotFoundException {
    int length = (int) Utils.randomNumber(3, 15);
    return Utils.getRandomPronounceableWord(length);
  }
}
