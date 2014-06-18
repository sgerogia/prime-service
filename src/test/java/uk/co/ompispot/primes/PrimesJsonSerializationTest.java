package uk.co.ompispot.primes;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import io.dropwizard.jackson.Jackson;

import org.junit.Test;

import uk.co.ompispot.primes.service.Primes;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PrimesJsonSerializationTest {

  private ObjectMapper MAPPER = Jackson.newObjectMapper();

  @Test
  public void shouldSerializePrimes() throws Exception {

    Primes result = new Primes(12, new int[] { 2, 3, 5 });
    assertThat(MAPPER.writeValueAsString(result), equalTo(fixture("json/primes.json")));
  }

}
