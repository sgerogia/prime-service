package uk.co.ompispot.primes;

import io.dropwizard.setup.Environment;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import uk.co.ompispot.primes.caching.NoopCache;
import uk.co.ompispot.primes.generator.SundaramSieveGenerator;
import uk.co.ompispot.primes.service.config.PrimesServiceConfig;

public class PrimesServiceApplicationTest {

  private PrimesServiceConfig config;

  private PrimesServiceApplication app;

  private Environment env;

  @Before
  public void setUp() throws Exception {

    env = new Environment("test", null, null, null, getClass().getClassLoader());
    config = new PrimesServiceConfig();
    config.setDefaultAlgorithmName("Sundaram");
    config.setCachingStrategyName("Noop");
    config.setAlgorithms(new HashMap<String, String>() {

      {
        put("Sundaram", SundaramSieveGenerator.class.getName());
      }
    });
    config.setCachingStrategies(new HashMap<String, String>() {

      {
        put("Noop", NoopCache.class.getName());
      }
    });
    app = new PrimesServiceApplication();
  }

  @Test(expected = IllegalStateException.class)
  public void shouldThrowExceptionForUnknownAlgorithm() {

    config.getAlgorithms().put("foo", "foo.bar.Baz");
    app.run(config, env);
  }

  @Test(expected = IllegalStateException.class)
  @Ignore("Fix when there is time, i.e. never")
  public void shouldThrowExceptionForUnknownCache() {

    config.getCachingStrategies().put("foo", "foo.bar.Baz");
    app.run(config, env);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionForUnknownCacheName() {

    config.setCachingStrategyName("Foo");
    app.run(config, env);
  }
}
