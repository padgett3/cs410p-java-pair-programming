package edu.pdx.cs410J.teamname;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Kata {
                                                                                    

  public static void main(String[] args) {
    if (args.length != 1) {
      printErrorMessageAndExit("Not enough or too many args. Only the 'filename' arg is supported");
    }

    String filename = args[0];

    try(FileReader fileReader = new FileReader(filename)) {
      FileParser fileParser = new FileParser(fileReader);
      System.out.println(fileParser.parse());

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected static void printErrorMessageAndExit(String message) {
    System.err.println(message);
    System.exit(1);
  }
}