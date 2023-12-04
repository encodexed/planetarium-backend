package com.planetarium.planetarium.stars;

import com.planetarium.planetarium.utils.Utils;
import java.io.FileNotFoundException;
import java.util.Date;
import org.apache.commons.math3.util.Precision;

public class StarUtilities {

  public static Star generateRandomStar() throws FileNotFoundException {
    String name = generateRandomStarName();
    StellarClass stellarClass = generateRandomStellarClass();
    int coordinateX = generateRandomCoordinate();
    int coordinateY = generateRandomCoordinate();
    int coordinateZ = generateRandomCoordinate();
    int surfaceTemperatureK = generateSurfaceTemperature(stellarClass);
    float solarMasses = generateSolarMasses(stellarClass);
    float solarRadii = generateRadii(stellarClass);
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

  private static float generateRadii(StellarClass stellarClass) {
    float radii = 1.00f;
    if (stellarClass == StellarClass.M) {
      radii = (float) Utils.randomNumber(0.11, 0.48);
    } else if (stellarClass == StellarClass.K) {
      radii = (float) Utils.randomNumber(0.61, 0.21);
    } else if (stellarClass == StellarClass.G) {
      radii = (float) Utils.randomNumber(0.85, 0.26);
    } else if (stellarClass == StellarClass.F) {
      radii = (float) Utils.randomNumber(1.12, 0.59);
    } else if (stellarClass == StellarClass.A) {
      radii = (float) Utils.randomNumber(1.75, 0.46);
    } else if (stellarClass == StellarClass.B) {
      radii = (float) Utils.randomNumber(2.46, 4.82);
    } else if (stellarClass == StellarClass.O) {
      radii = (float) Utils.randomNumber(7.51, 7.82);
    }

    System.out.println("\nRADII: " + radii);

    return Precision.round(radii, 3);
  }

  private static float generateSolarMasses(StellarClass stellarClass) {
    float mass = 1.00f;
    if (stellarClass == StellarClass.M) {
      mass = (float) Utils.randomNumber(0.078, 0.51);
    } else if (stellarClass == StellarClass.K) {
      mass = (float) Utils.randomNumber(0.59, 0.41);
    } else if (stellarClass == StellarClass.G) {
      mass = (float) Utils.randomNumber(0.9, 1.06);
    } else if (stellarClass == StellarClass.F) {
      mass = (float) Utils.randomNumber(1.13, 0.48);
    } else if (stellarClass == StellarClass.A) {
      mass = (float) Utils.randomNumber(1.74, 0.45);
    } else if (stellarClass == StellarClass.B) {
      mass = (float) Utils.randomNumber(2.71, 15.23);
    } else if (stellarClass == StellarClass.O) {
      mass = (float) Utils.randomNumber(14.95, 102.01);
    }

    System.out.println("\nMASS: " + mass);

    return Precision.round(mass, 3);
  }

  public static StellarClass generateRandomStellarClass() {
    int rand = Utils.randomNumber(0, 100000);
    if (rand < 3) {
      return StellarClass.O;
    } else if (rand < 133) {
      return StellarClass.B;
    } else if (rand < 733) {
      return StellarClass.A;
    } else if (rand < 3733) {
      return StellarClass.F;
    } else if (rand < 11333) {
      return StellarClass.G;
    } else if (rand < 23433) {
      return StellarClass.K;
    } else {
      return StellarClass.M;
    }
  }

  // Generates a random integer between -100 and 100
  public static int generateRandomCoordinate() {
    return (int) (Math.floor(Math.random() * 200 - 100));
  }

  public static int generateSurfaceTemperature(StellarClass stellarClass) {
    if (stellarClass == StellarClass.M) {
      return Utils.randomNumber(2774, 527);
    } else if (stellarClass == StellarClass.K) {
      return Utils.randomNumber(3436, 1583);
    } else if (stellarClass == StellarClass.G) {
      return Utils.randomNumber(4862, 1168);
    } else if (stellarClass == StellarClass.F) {
      return Utils.randomNumber(5932, 1602);
    } else if (stellarClass == StellarClass.A) {
      return Utils.randomNumber(7542, 2730);
    } else if (stellarClass == StellarClass.B) {
      return Utils.randomNumber(10102, 20312);
    } else if (stellarClass == StellarClass.O) {
      return Utils.randomNumber(30385, 17544);
    } else {
      return 6969;
    }
  }

  public static String generateRandomStarName() throws FileNotFoundException {
    int length = (int) Utils.randomNumber(3, 6);
    return Utils.getRandomPronounceableWord(length);
  }
}
