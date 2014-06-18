package uk.co.ompispot.primes.service.config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import io.dropwizard.configuration.ConfigurationFactory;
import io.dropwizard.jackson.Jackson;

import java.io.File;

import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Resources;

public class PrimesServiceConfigTest {

  private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
  private final ConfigurationFactory<PrimesServiceConfig> factory =
      new ConfigurationFactory<PrimesServiceConfig>(PrimesServiceConfig.class, validator, Jackson.newObjectMapper(),
          "omni");
  private File yamlFile;

  @Before
  public void setUp() throws Exception {

    this.yamlFile = new File(Resources.getResource("prime-service.yml").toURI());
  }

  @Test
  public void shouldDeserializeFromYaml() throws Exception {

    PrimesServiceConfig config = factory.build(yamlFile);

    assertThat(config.getCachingStrategyName(), equalTo("Mem"));
    assertThat(config.getDefaultAlgorithmName(), equalTo("Sundaram"));
    assertThat(config.getAlgorithms().size(), equalTo(2));
    assertThat(config.getAlgorithms().get("Eratosthenes"),
        equalTo("uk.co.ompispot.primes.generator.EratosthenesSieveGenerator"));
    assertThat(config.getCachingStrategies().size(), equalTo(2));
    assertThat(config.getCachingStrategies().get("Noop"),
        equalTo("uk.co.ompispot.primes.caching.NoopCache"));
  }

}
