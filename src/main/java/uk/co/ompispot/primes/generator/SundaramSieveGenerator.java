package uk.co.ompispot.primes.generator;

import java.util.Arrays;

/**
 * Prime generator based on Sieve of Sundaram. See {@linkplain http://en.wikipedia.org/wiki/Sieve_of_Sundaram}.
 * 
 * @author sgerogiannakis
 */
public class SundaramSieveGenerator extends BasePrimeGenerator {

  @Override
  protected int[] generate(int limit) {

    /* Adapted from http://bcbutler.com/Java_Tuts/java_sieve_of_sundaram.php */
    int n = limit / 2;
    boolean[] isPrime = new boolean[limit];
    Arrays.fill(isPrime, true);
    for (int i = 1; i < n; i++) {
      for (int j = i; j <= (n - i) / (2 * i + 1); j++) {
        isPrime[i + j + 2 * i * j] = false;
      }
    }
    int[] primes = new int[limit];
    int found = 0;

    if (limit > 2) {
      primes[found++] = 2;
    }
    for (int i = 1; i < n; i++) {
      if (isPrime[i]) {
        primes[found++] = i * 2 + 1;
      }
    }
    return Arrays.copyOf(primes, found);
  }

}
