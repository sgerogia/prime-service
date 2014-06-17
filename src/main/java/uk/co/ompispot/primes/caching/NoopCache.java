package uk.co.ompispot.primes.caching;


/**
 * Simply delegates to the wrapped generator.
 * 
 * @author sgerogiannakis
 */
public class NoopCache extends BasePrimeGeneratorCache {

  @Override
  protected int[] getCachedPrimes(int limit) {

    return null;
  }

  @Override
  protected void cachePrimes(int[] primes, int limit) {

    // do nothing
  }

}
