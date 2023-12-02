package com.planetarium.planetarium.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

  public static String[] getPhoneticOptions() throws FileNotFoundException {
    String phonetics = fileToString("src/main/resources/phonetics.txt");
    String[] phoneticsArrs = phonetics.split("\n");
    return phoneticsArrs;
  }

  // Read the file and convert to a String
  public static String fileToString(String filepath)
    throws FileNotFoundException {
    File file = new File(filepath);
    Scanner reader = new Scanner(file);
    StringBuilder sb = new StringBuilder();
    reader.useDelimiter(" ");
    while (reader.hasNextLine()) {
      sb.append(reader.next());
    }
    reader.close();
    return sb.toString();
  }
}
