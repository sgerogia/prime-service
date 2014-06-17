package uk.co.ompispot.primes.service;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import uk.co.ompispot.primes.caching.PrimeGeneratorCache;
import uk.co.ompispot.primes.generator.PrimeGenerator;

import com.google.common.base.Optional;

/**
 * Entry-point for the prime generation service.
 * 
 * @author sgerogiannakis
 */
@Path("/primes")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PrimesResource {

  private final Map<String, PrimeGenerator> generators;

  private final PrimeGeneratorCache generatorCache;

  @GET
  @Path("/{limit}")
  public Primes calculatePrimes(@PathParam("limit") String limit, @QueryParam("algorithm") Optional<String> algorithm) {

  }
}
