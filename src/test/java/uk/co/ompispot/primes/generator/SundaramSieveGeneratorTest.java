package uk.co.ompispot.primes.generator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SundaramSieveGeneratorTest extends BasePrimeGeneratorTest {

  @Before
  public void setUp() {

    generator = new SundaramSieveGenerator();
  }

  @Test
  public void shouldGeneratePrimesAsExpected() {

    assertThat(generator.generatePrimes(30), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
  }

}
