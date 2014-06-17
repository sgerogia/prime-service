package uk.co.ompispot.primes.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.ompispot.primes.generator.PrimeGenerator;

/**
 * Base class for all {@link PrimeGenerator} caching strategies. Attempts to retrieve the primes before delegating to
 * the wrapped instance.
 * 
 * @author sgerogiannakis
 */
public abstract class BasePrimeGeneratorCache implements PrimeGeneratorCache {

  private static final Logger LOG = LoggerFactory.getLogger(BasePrimeGeneratorCache.class);

  public final int[] generatePrimes(int limit, PrimeGenerator primeGenerator) {

    if (primeGenerator == null) {
      LOG.error("PrimeGenerator is null");
      throw new IllegalArgumentException("PrimeGenerator is null");
    }
    int[] primes = getCachedPrimes(limit);
    if (primes == null) {
      primes = primeGenerator.generatePrimes(limit);
      cachePrimes(primes, limit);
    }
    return primes;
  }

  /**
   * Get the cached list of primes for this limit.
   * 
   * @param limit
   * @return the list of primes or null if no match cached
   */
  protected abstract int[] getCachedPrimes(int limit);

  /**
   * (Optionally) Cache the list of primes for the given limit.
   * 
   * @param primes
   * @param limit
   */
  protected abstract void cachePrimes(int[] primes, int limit);
}
