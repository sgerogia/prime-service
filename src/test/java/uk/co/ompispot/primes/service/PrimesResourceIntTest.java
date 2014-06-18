package uk.co.ompispot.primes.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import io.dropwizard.testing.junit.DropwizardAppRule;

import java.io.File;

import javax.ws.rs.core.MediaType;

import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

import uk.co.ompispot.primes.PrimesServiceApplication;
import uk.co.ompispot.primes.service.config.PrimesServiceConfig;

import com.google.common.io.Resources;
import com.sun.jersey.api.client.Client;

public class PrimesResourceIntTest {

  @ClassRule
  public static final DropwizardAppRule<PrimesServiceConfig> RULE =
      new DropwizardAppRule<PrimesServiceConfig>(PrimesServiceApplication.class, resourceFilePath("primes-service.yml"));

  @Test
  public void shouldExecuteWithoutAlgorithm() {

    Client client = new Client();

    Primes response = client.resource(
        String.format("http://localhost:%d/primes/30", RULE.getLocalPort()))
        .get(Primes.class);

    assertThat(response.getLimit(), equalTo(30));
    assertThat(response.getPrimes(), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
  }

  @Test
  public void shouldExecuteWithJsonMediaType() {

    Client client = new Client();

    Primes response = client.resource(
        String.format("http://localhost:%d/primes/30", RULE.getLocalPort())).accept(MediaType.APPLICATION_JSON)
        .get(Primes.class);

    assertThat(response.getLimit(), equalTo(30));
    assertThat(response.getPrimes(), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
  }

  @Test
  @Ignore("XML support to be added in the future, i.e. never")
  public void shouldExecuteWithXmlMediaType() {

    Client client = new Client();

    Primes response = client.resource(
        String.format("http://localhost:%d/primes/30", RULE.getLocalPort())).accept(MediaType.APPLICATION_XML)
        .get(Primes.class);

    assertThat(response.getLimit(), equalTo(30));
    assertThat(response.getPrimes(), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
  }

  @Test
  public void shouldExecuteWithEratosthenesAlgorithm() {

    Client client = new Client();

    Primes response = client.resource(
        String.format("http://localhost:%d/primes/30", RULE.getLocalPort())).queryParam("algorithm", "Eratosthenes")
        .get(Primes.class);

    assertThat(response.getLimit(), equalTo(30));
    assertThat(response.getPrimes(), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
  }

  @Test
  public void shouldExecuteWithSundaramAlgorithm() {

    Client client = new Client();

    Primes response = client.resource(
        String.format("http://localhost:%d/primes/30", RULE.getLocalPort())).queryParam("algorithm", "Sundaram")
        .get(Primes.class);

    assertThat(response.getLimit(), equalTo(30));
    assertThat(response.getPrimes(), equalTo(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
  }

  /*
   * Shamelessly copied from Dropwizard's test source.
   */
  public static String resourceFilePath(String resourceClassPathLocation) {

    try {
      return new File(Resources.getResource(resourceClassPathLocation).toURI()).getAbsolutePath();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
