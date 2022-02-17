package edu.pdx.cs410J.teamname;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridAccountNumber {

  private static final String[] DIGIT = new String[]{
      " _ " +
          "| |" +
          "|_|",

      "   " +
          "  |" +
          "  |",

      " _ " +
          " _|" +
          "|_ ",

      " _ " +
          " _|" +
          " _|",

      "   " +
          "|_|" +
          "  |",

      " _ " +
          "|_ " +
          " _|",

      " _ " +
          "|_ " +
          "|_|",

      " _ " +
          "  |" +
          "  |",

      " _ " +
          "|_|" +
          "|_|",

      " _ " +
          "|_|" +
          " _|"
  };

  private static final byte[] DIGIT_CODE = new byte[]{
      toDigitCode(DIGIT[0]),
      toDigitCode(DIGIT[1]),
      toDigitCode(DIGIT[2]),
      toDigitCode(DIGIT[3]),
      toDigitCode(DIGIT[4]),
      toDigitCode(DIGIT[5]),
      toDigitCode(DIGIT[6]),
      toDigitCode(DIGIT[7]),
      toDigitCode(DIGIT[8]),
      toDigitCode(DIGIT[9])
  };


  byte[] digitCodes;

  public GridAccountNumber(String[] input) {

    digitCodes = new byte[9];

    for (int i = 0; i < 9; ++i) {
      digitCodes[i] = toDigitCode(input[i]);
    }
  }

  private GridAccountNumber(byte[] digitCodes) {
    this.digitCodes = digitCodes;
  }

  private static byte toDigitCode(String digitString) {
    List<Integer> indices = new ArrayList<Integer>(List.of(8, 7, 6, 5, 4, 3, 1));

    byte digitByte = 0;

    for (int i = 0; i < indices.size(); i++) {
      int charIndex = indices.get(i);

      if (' ' != digitString.charAt(charIndex)) {
        digitByte = setBit(digitByte, i);
      }
    }

    return digitByte;
  }

  private static byte setBit(byte data, int index) {
    return (byte) (data | (1 << index));
  }

  private static byte flipBit(byte data, int index) {
    return (byte) (data ^ (1 << index));
  }

  // Converts a digit code to an actual character
  // Returns '?' if the digit code does not match a known digit
  private static char toDigitChar(byte digitCode) {

    for (int i = 0; i < DIGIT_CODE.length; ++i)
      if (DIGIT_CODE[i] == digitCode)
        return (char) (i + '0');

    return '?';

  }

  // Converts a digit code to an actual digit
  // Returns -1 if the digit code does not match a known digit
  private static int toDigit(byte digitCode) {

    for (int i = 0; i < DIGIT_CODE.length; ++i)
      if (DIGIT_CODE[i] == digitCode)
        return i;

    return -1;

  }

  // Converts this account number to human-readable string
  // Unreadable digits will be ? characters
  @Override
  public String toString() {

    char[] str = new char[digitCodes.length];

    for (int i = 0; i < str.length; ++i) {
      str[i] = toDigitChar(digitCodes[i]);
    }

    return new String(str);

  }

  // Checks that all the digits in this account number are valid
  public boolean hasValidDigits() {

    for (int i = 0; i < digitCodes.length; ++i) {

      if (toDigit(digitCodes[i]) < 0)
        return false;

    }

    return true;

  }

  // Checks that this account number has a valid checksum
  public boolean hasValidChecksum() {

    int checksum = 0;

    for (int i = 1; i <= 9; ++i) {

      int index = 9 - i;
      int digit = toDigit(digitCodes[index]);

      if (digit < 0)
        return false;

      checksum += digit * i;

    }

    return (checksum % 11) == 0;

  }


  // Determines possible alternative account numbers that this
  // could represent if only one bit were flipped
  public List<GridAccountNumber> calculateAlternatives() {

    ArrayList<GridAccountNumber> alternatives = new ArrayList<>();
    byte[] alternative = Arrays.copyOf(digitCodes, digitCodes.length);

    for(int i = 0; i < digitCodes.length; ++i) {

      for(int bit = 0; bit <= 7; ++bit) {

        // Try changing a bit
        alternative[i] = flipBit(alternative[i], bit);

        // See if we end up with a valid account number
        GridAccountNumber num = new GridAccountNumber(alternative);

        // If we did, put the number in the alternatives list and create a new
        // digit code array to work with
        if(num.hasValidChecksum()) {

          alternatives.add(num);
          alternative = Arrays.copyOf(digitCodes, digitCodes.length);

        }

        // Otherwise, flip the bit back to the original value
        else
          alternative[i] = flipBit(alternative[i], bit);

      }

    }

    return alternatives;

  }

}
