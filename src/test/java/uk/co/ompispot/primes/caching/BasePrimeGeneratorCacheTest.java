package uk.co.ompispot.primes.caching;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import uk.co.ompispot.primes.generator.EratosthenesSieveGenerator;

public abstract class BasePrimeGeneratorCacheTest {

  protected BasePrimeGeneratorCache cache;

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailForNegative() {

    cache.generatePrimes(-3, new EratosthenesSieveGenerator());
  }

  @Test
  public void shouldReturnEmptyForZero() {

    assertThat(cache.generatePrimes(0, new EratosthenesSieveGenerator()).length, equalTo(0));
  }

  @Test
  public void shouldReturnEmptyForOne() {

    assertThat(cache.generatePrimes(1, new EratosthenesSieveGenerator()).length, equalTo(0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailForNullGenerator() {

    cache.generatePrimes(30, null);
  }

}
