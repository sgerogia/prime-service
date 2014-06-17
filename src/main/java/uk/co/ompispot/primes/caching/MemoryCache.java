/**
 * $Id: MemoryCache.java 17 Jun 2014 18:20:12 sgerogiannakis Exp $ $Copyright: Copyright 2002-2014 Expedia.com, L.P. All
 * rights reserved. $
 */
package uk.co.ompispot.primes.caching;

import java.util.Arrays;

/**
 * Caches an array of primes in memory. Effective only if the requested limit is smaller than the highest one already
 * encountered. In that case the best-case complexity is log(n).
 * 
 * @author sgerogiannakis
 */
public class MemoryCache extends BasePrimeGeneratorCache {

  private int highestLimit = -1;

  private int[] cachedPrimes;

  @Override
  protected int[] getCachedPrimes(int limit) {

    if (limit > highestLimit || highestLimit == -1) {
      return null;
    }
    int index = Arrays.binarySearch(cachedPrimes, limit);
    int subArrayLength = -1;
    if (index >= 0) {
      subArrayLength = index + 1;
    } else {
      subArrayLength = -index - 1;
    }
    return Arrays.copyOf(cachedPrimes, subArrayLength);
  }

  @Override
  protected void cachePrimes(int[] primes, int limit) {

    cachedPrimes = primes;
    highestLimit = limit;
  }

  public int getHighestLimit() {

    return highestLimit;
  }

  public int[] getCachedPrimes() {

    return cachedPrimes;
  }

}
