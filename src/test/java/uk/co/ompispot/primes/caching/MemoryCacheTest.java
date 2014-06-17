package uk.co.ompispot.primes.caching;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import uk.co.ompispot.primes.generator.EratosthenesSieveGenerator;
import uk.co.ompispot.primes.generator.PrimeGenerator;

public class MemoryCacheTest extends BasePrimeGeneratorCacheTest {

  private PrimeGenerator generator;

  @Before
  public void setUp() {

    generator = new EratosthenesSieveGenerator();
    cache = new MemoryCache();
  }

  @Test
  public void shouldGeneratePrimesForVariousLimits() {

    MemoryCache memCache = (MemoryCache) cache;
    assertThat(memCache.generatePrimes(30, generator), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
    assertThat(memCache.getHighestLimit(), equalTo(30));
    assertThat(memCache.getCachedPrimes(), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));

    assertThat(memCache.generatePrimes(29, generator), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
    assertThat(memCache.getHighestLimit(), equalTo(30));
    assertThat(memCache.getCachedPrimes(), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));

    assertThat(memCache.generatePrimes(8, generator), equalTo(new int[] { 2, 3, 5, 7 }));
    assertThat(memCache.getHighestLimit(), equalTo(30));

    assertThat(memCache.generatePrimes(2, generator), equalTo(new int[] { 2 }));
    assertThat(memCache.getHighestLimit(), equalTo(30));

    assertThat(memCache.generatePrimes(50, generator), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
        41, 43, 47 }));
    assertThat(memCache.getHighestLimit(), equalTo(50));
    assertThat(memCache.getCachedPrimes(),
        equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 }));

    assertThat(memCache.generatePrimes(36, generator), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 }));
    assertThat(memCache.getHighestLimit(), equalTo(50));
  }

}
