package edu.pdx.cs410J.teamname;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class FileParserTest {
  @Test
  void parseTest() throws IOException {
    var rsc = FileParserTest.class.getResourceAsStream("testInput.txt");
    assertThat(rsc, notNullValue());

    FileParser fileParser = new FileParser(new InputStreamReader(rsc));
    GridAccountNumber gan = fileParser.parse();

    assertThat(String.valueOf(gan.digitCodes[0]), equalTo(String.valueOf(0b1011011)));
    assertThat(gan.toString(), equalTo("333333333"));
  }
}
