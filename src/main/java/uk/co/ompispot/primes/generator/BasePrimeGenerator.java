package uk.co.ompispot.primes.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Convenience base class for all prime generators.
 * 
 * @author sgerogiannakis
 */
public abstract class BasePrimeGenerator implements PrimeGenerator {

  protected static final Logger LOG = LoggerFactory.getLogger(BasePrimeGenerator.class);

  @Override
  public final int[] generatePrimes(int limit) {

    if (limit < 0) {
      LOG.error("Limit {} is less than 0", limit);
      throw new IllegalArgumentException("Limit " + limit + " is less than 0");
    }
    return generate(limit);
  }

  protected abstract int[] generate(int limit);

}
