package uk.co.ompispot.primes.generator;

/**
 * Base class for all {@link PrimeGenerator} wrappers. Attempts to retrieve the primes before delegating to the wrapped
 * instance.
 * 
 * @author sgerogiannakis
 */
public abstract class PrimeGeneratorWrapper implements PrimeGenerator {

  private PrimeGenerator primeGenerator;

  public PrimeGeneratorWrapper(PrimeGenerator generator) {

    this.primeGenerator = generator;
  }

  protected PrimeGenerator getPrimeGenerator() {

    return primeGenerator;
  }

  public final int[] generatePrimes(int limit) {

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
