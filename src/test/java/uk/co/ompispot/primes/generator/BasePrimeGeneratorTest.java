package uk.co.ompispot.primes.generator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public abstract class BasePrimeGeneratorTest {

  protected PrimeGenerator generator;

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailForNegative() {

    generator.generatePrimes(-3);
  }

  @Test
  public void shouldReturnEmptyForZero() {

    assertThat(generator.generatePrimes(0).length, equalTo(0));
  }

  @Test
  public void shouldReturnEmptyForOne() {

    assertThat(generator.generatePrimes(1).length, equalTo(0));
  }
}
