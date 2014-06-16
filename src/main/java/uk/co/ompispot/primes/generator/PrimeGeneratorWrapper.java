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

  public int[] generatePrimes(int limit) {

  }
}
