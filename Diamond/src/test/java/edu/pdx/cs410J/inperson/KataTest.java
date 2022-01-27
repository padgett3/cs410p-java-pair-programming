package edu.pdx.cs410J.inperson;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class KataTest
{

  @Test
  void canInstantiateKataClass() {
    new Kata();
  }

  @Test
  void bIs1(){
    assertThat( Kata.getInnerSpaces('B') , equalTo(1));
  }

  @Test
  void CIs7(){
    assertThat( Kata.getInnerSpaces('C') , equalTo(3));
  }

  @Test
  void DIs7(){
    assertThat( Kata.getInnerSpaces('D') , equalTo(5));
  }
}
