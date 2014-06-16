package uk.co.ompispot.primes.generator;

import java.util.ArrayList;
import java.util.List;

import com.google.common.primitives.Ints;

/**
 * Prime generator based on Sieve of Eratosthenes. See {@linkplain http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes}.
 * 
 * @author sgerogiannakis
 */
public class EratosthenesSieveGenerator extends BasePrimeGenerator {

  @Override
  protected int[] generate(int limit) {

    /* Adapted from http://www.vogella.com/tutorials/JavaAlgorithmsPrimeNumbers/article.html */
    boolean[] isPrimeNumber = new boolean[limit + 1];
    List<Integer> primes = new ArrayList<Integer>();
    for (int i = 2; i < limit; i++) {
      isPrimeNumber[i] = true;
    }
    for (int i = 2; i < limit; i++) {
      if (isPrimeNumber[i]) {
        primes.add(i);
        for (int j = i; j * i <= limit; j++) {
          isPrimeNumber[i * j] = false;
        }
      }
    }
    return Ints.toArray(primes);
  }

}
