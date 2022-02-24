package edu.pdx.cs410J.oneteam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class KataTest
{

  @Test
  void canInstantiateKataClass() {
    new Kata();
  }

  @Test
  void divideTest() {
    String equation = "20 5 /";
    assertEquals(4, Kata.init(equation));
  }

  @Test
  void plusAndMinus() {
    String equation = "4 2 + 3 -";
    assertEquals(3, Kata.init(equation));
  }

  @Test
  void timesTest() {
    String equation = "4 2 *";
    assertEquals(8, Kata.init(equation));
  }
  @Test
  void addTest() {
    String equation = "4 2 +";
    assertEquals(6, Kata.init(equation));
  }
  @Test
  void subtractTest() {
    String equation = "4 2 -";
    assertEquals(2, Kata.init(equation));
  }

  @Test
  void divideTest2() {
    String equation = "6 2 /";
    assertEquals(3, Kata.init(equation));
  }

  @Test
  void sqrtTest() {
    String equation = "9 SQRT";
    assertEquals(3, Kata.init(equation));
  }

  @Test
  void maxTestOneMax() {
    String equation = "5 3 4 2 9 1 MAX";
    assertEquals(9, Kata.init(equation));
  }

  @Test
  void threeOperations() {
    String equation = "3 5 8 * 7 + *";
    assertEquals(Kata.init(equation), 141);
  }
}
