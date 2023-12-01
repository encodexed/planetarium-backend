package com.planetarium.planetarium.utils;

public class Utils {

  public static int randomNumber(int lowest, int range) {
    return (int) (
      Math.floor((Math.random() * (double) range) + (double) lowest)
    );
  }

  public static double randomNumber(double lowest, double range) {
    return (Math.floor((Math.random() * range) + lowest));
  }

  // Returns a random lowercase character
  public static char randomChar() {
    int rand = randomNumber(97, 26);
    return (char) rand;
  }
}
