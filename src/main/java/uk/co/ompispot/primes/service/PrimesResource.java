package uk.co.ompispot.primes.service;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.ompispot.primes.caching.PrimeGeneratorCache;
import uk.co.ompispot.primes.generator.PrimeGenerator;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

/**
 * Entry-point for the prime generation service.
 * 
 * @author sgerogiannakis
 */
@Path("/primes")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PrimesResource {

  private static final Logger LOG = LoggerFactory.getLogger(PrimesResource.class);

  private final Map<String, PrimeGenerator> generators;

  private final PrimeGeneratorCache generatorCache;

  private final String defaultAlgorithm;

  /**
   * Initializes the REST resource provider.
   * 
   * @param generators
   *          named map
   * @param generatorCache
   * @param defaultAlgorithm
   * @throws IllegalArgumentException
   *           if the arguments are null/empty or the default algorithm key does not exist in the generators map
   */
  public PrimesResource(Map<String, PrimeGenerator> generators, PrimeGeneratorCache generatorCache,
      String defaultAlgorithm) {

    if (generators == null || generators.isEmpty()) {
      LOG.error("PrimeGenerators map cannot be null or empty");
      throw new IllegalArgumentException("PrimeGenerators map cannot be null or empty");
    }

    if (generatorCache == null) {
      LOG.error("GeneratorCache cannot be null");
      throw new IllegalArgumentException("GeneratorCache cannot be null");
    }

    if (!generators.containsKey(defaultAlgorithm)) {
      LOG.error("defaultAlgorithm does not exist");
      throw new IllegalArgumentException("defaultAlgorithm does not exist");
    }

    this.generators = new ImmutableMap.Builder<String, PrimeGenerator>().putAll(generators).build();
    this.generatorCache = generatorCache;
    this.defaultAlgorithm = defaultAlgorithm;
  }

  /**
   * Return the list of primes up to the limit.
   * 
   * @param limit
   *          maximum number
   * @param algorithm
   *          the optional algorithm to use
   * @return Primes the results
   * @throws NumberFormatException
   *           if the limit is not a number
   * @throws IllegalArgumentException
   *           if the algorithm cannot be recognized
   */
  @GET
  @Path("/{limit}")
  public Primes calculatePrimes(@PathParam("limit") String limit, @QueryParam("algorithm") Optional<String> algorithm) {

    int lim = 0;
    try {
      lim = Integer.valueOf(limit);
    } catch (NumberFormatException e) {
      LOG.error("Argument {} is not a number", limit);
      throw e;
    }

    String algo = algorithm.or(defaultAlgorithm);
    PrimeGenerator gen = generators.get(algo);
    if (gen == null) {
      LOG.error("Algorithm {} is not recognized", algo);
      throw new IllegalArgumentException("Algorithm '" + algo + "' is not recognized");
    }

    return new Primes(lim, generatorCache.generatePrimes(lim, gen));
  }
}
