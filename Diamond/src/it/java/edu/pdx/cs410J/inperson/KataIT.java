package edu.pdx.cs410J.inperson;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

class KataIT extends InvokeMainTestCase {

  @Test
  void invokingMainWithNoArgumentsHasExitCodeOf1() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
  }

  @Test
  void canPrintA() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "A");
    assertThat(result.getTextWrittenToStandardOut(), containsString("A"));
  }

  @Test
  @Disabled
  void canPrintB() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "B");
    assertThat(result.getTextWrittenToStandardOut(), containsString(" A \nB B\n A "));
    // A
    //B B
    // A
  }

  @Test
  @Disabled
  void canPrintC() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "C");
    assertThat(result.getTextWrittenToStandardOut(), containsString("  A  \n B B \nC   C\n B B \n  A  "));
  }


}
