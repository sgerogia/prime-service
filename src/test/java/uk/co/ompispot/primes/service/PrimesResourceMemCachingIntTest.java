package uk.co.ompispot.primes.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import io.dropwizard.testing.junit.DropwizardAppRule;

import org.junit.ClassRule;
import org.junit.Test;

import uk.co.ompispot.primes.PrimesServiceApplication;
import uk.co.ompispot.primes.service.config.PrimesServiceConfig;

import com.sun.jersey.api.client.Client;

// @TODO: Make rule shareable/configurable so thattest case can be re-used via inheritance
public class PrimesResourceMemCachingIntTest {

  @ClassRule
  public static final DropwizardAppRule<PrimesServiceConfig> RULE =
      new DropwizardAppRule<PrimesServiceConfig>(PrimesServiceApplication.class,
          PrimesResourceIntTest.resourceFilePath("primes-service-caching.yml"));

  @Test
  public void shouldExecuteWithoutAlgorithm() {

    Client client = new Client();

    Primes response = client.resource(
        String.format("http://localhost:%d/primes/30", RULE.getLocalPort()))
        .get(Primes.class);

    assertThat(response.getLimit(), equalTo(30));
    assertThat(response.getPrimes(), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
  }

}
