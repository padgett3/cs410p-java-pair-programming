package edu.pdx.cs410J.teamname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class FileParser {

  private final Reader reader;

  private final String[] digitStrings = new String[9];

  public FileParser(Reader reader) {
    this.reader = reader;
  }

  public GridAccountNumber parse() throws IOException {
    BufferedReader br = new BufferedReader(reader);

    for (int i = 0; i < 3; i++) {
      String line = br.readLine();

      for (int j = 0; j < digitStrings.length; j++) {
        digitStrings[j] += line.substring(3 * j, 3 * (j + 1));
      }
    }

    return new GridAccountNumber(digitStrings);
  }






}
