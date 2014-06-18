package uk.co.ompispot.primes.caching;

import uk.co.ompispot.primes.generator.PrimeGenerator;

/**
 * A cache around a {@link PrimeGenerator}. All implementations must operate in a multi-threaded environment.
 * 
 * @author sgerogiannakis
 */
public interface PrimeGeneratorCache {

  /**
   * Get all primes from the cache. If there are no values, use the given implementation.
   * 
   * @param limit
   *          maximum number to consider
   * @param generator
   *          to use if no values are cached
   * @return array of numbers, never null
   * @throws IllegalArgumentException
   *           if the limit is negative or the implementation null
   */
  public int[] generatePrimes(int limit, PrimeGenerator generator);
}
