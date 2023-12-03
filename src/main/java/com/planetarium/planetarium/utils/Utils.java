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
    try {
      String phonetics = fileToString("src/main/resources/phonetics.txt");
      String[] phoneticsArrs = phonetics.split("\n");
      return phoneticsArrs;
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    }

    return new String[0];
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

  public static String getRandomPronounceableWord(int length)
    throws FileNotFoundException {
    StringBuilder word = new StringBuilder();
    String[] phoneticOptions = getPhoneticOptions();
    String[] vowels = phoneticOptions[0].toString().split("-");
    String[] consonants = phoneticOptions[1].toString().split("-");

    String firstLetter = String.valueOf(randomChar()).toUpperCase();
    word.append(firstLetter);

    boolean nextLetterConsonant = false;
    if (
      firstLetter.equals("A") ||
      firstLetter.equals("E") ||
      firstLetter.equals("I") ||
      firstLetter.equals("O") ||
      firstLetter.equals("U")
    ) {
      nextLetterConsonant = true;
    }

    if (firstLetter.equals("Q")) {
      word.append("u");
    }

    for (int i = 1; i < length; i++) {
      if (nextLetterConsonant == true) {
        String next = consonants[randomNumber(0, consonants.length - 1)];
        word.append(next);
      } else {
        String next = vowels[randomNumber(0, vowels.length - 1)];
        word.append(next);
      }
      nextLetterConsonant = !nextLetterConsonant;
    }

    return word.toString();
  }
}
