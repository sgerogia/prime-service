package uk.co.ompispot.primes.generator;

/**
 * A prime number geenrator.
 * 
 * @author sgerogiannakis
 */
public interface PrimeGenerator {

  /**
   * Generate all primes lower or equal to the limit.
   * 
   * @param limit
   *          maximum number to consider
   * @return array of numbers, never null
   * @throws IllegalArgumentException
   *           if the limit is negative
   */
  public int[] generatePrimes(int limit);

}
