package edu.pdx.cs410J.oneteam;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KataIT extends InvokeMainTestCase {

  @Test
  void invokingMainWithNoArgumentsHasExitCodeOf1() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
  }

  @Test
  void maxTestMultipleMax() {
    String equation = "4 5 MAX 1 2 MAX *";
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, equation);
    assertThat(result.getTextWrittenToStandardError(), containsString("stack shouldn't be empty but it is"));
  }
}
