package com.planetarium.planetarium.stars;

import java.util.Date;

public class StarUtilities {

  public static Star generateRandomStar() {
    String name = generateRandomStarName();
    StellarClass stellarClass = generateRandomStellarClass();
    int coordinateX = generateRandomCoordinate();
    int coordinateY = generateRandomCoordinate();
    int coordinateZ = generateRandomCoordinate();
    boolean isMainStar = generateMainStarStatus();
    int surfaceTemperatureK = generateSurfaceTemperature();
    float solarMasses = generateSolarMasses();
    int orbitsStarId = isMainStar ? 0 : getMainStarId();
    int radiusKm = generateRadius();
    Date now = new Date();
    Long l = Long.valueOf(0);

    return new Star(l, name, stellarClass, coordinateX, coordinateY, coordinateZ, isMainStar, surfaceTemperatureK,
        solarMasses, orbitsStarId, radiusKm, 1, now, 1, now, 1, now);
  }

  private static int generateRadius() {
    return 10000;
  }

  private static int getMainStarId() {
    return 0;
  }

  private static float generateSolarMasses() {
    return 1.00f;
  }

  private static boolean generateMainStarStatus() {
    return true;
  }

  public static String generateRandomStarName() {
    return "Sol";
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
