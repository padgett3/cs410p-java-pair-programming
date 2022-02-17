package edu.pdx.cs410J.inperson;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Kata {
                                                                                    

  public static void main(String[] args) {
    System.err.println("Missing command line arguments");

    if (args.length == 1) {
      outer('A', args[0].charAt(0));
    }

    System.exit(1);
  }

  public static void inner(char letter) {
    if (letter == 'A') {
      System.out.println(letter);
      return;
    }
    System.out.print(letter);
    printNSpaces(getInnerSpaces(letter));
    System.out.println(letter);
  }

  public static void outer(char currentLetter, char last) {
    if (currentLetter == last) {
      inner(currentLetter);
      return;
    }

    printNSpaces(last - currentLetter);
    inner(currentLetter);

    outer((char) (currentLetter + 1), last);

    printNSpaces(last - currentLetter);
    inner(currentLetter);
  }

  public static void printNSpaces(int numSpaces) {
    // https://www.quora.com/How-do-you-repeat-a-string-n-number-of-times-in-Java-programming
    System.out.print(new String(new char[numSpaces]).replace("\0", " "));
  }

  static int getInnerSpaces(char letter)
  {
    int evenIndex = (int) (letter - 'A');

    return -1 + 2 * evenIndex;
  }
}
