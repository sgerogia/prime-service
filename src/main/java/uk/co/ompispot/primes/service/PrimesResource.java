package uk.co.ompispot.primes.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

/**
 * Entry-point for the prime generation service.
 * 
 * @author sgerogiannakis
 */
@Path("/primes")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PrimesResource {

  @GET
  @Path("/{limit}")
  public Primes calculatePrimes(@PathParam("limit") String limit, @QueryParam("algorithm") Optional<String> algorithm) {

  }
}
