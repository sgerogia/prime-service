/**
 * $Id: PrimeServiceApplication.java 17 Jun 2014 19:51:57 sgerogiannakis Exp $ $Copyright: Copyright 2002-2014
 * Expedia.com, L.P. All rights reserved. $
 */
package uk.co.ompispot.primes;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.ompispot.primes.caching.PrimeGeneratorCache;
import uk.co.ompispot.primes.generator.PrimeGenerator;
import uk.co.ompispot.primes.service.PrimesResource;
import uk.co.ompispot.primes.service.config.PrimesServiceConfig;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/**
 * Prime service application launcher.
 * 
 * @author sgerogiannakis
 */
public class PrimesServiceApplication extends Application<PrimesServiceConfig> {

  private static final Logger LOG = LoggerFactory.getLogger(PrimesServiceApplication.class);

  public static void main(String[] args) throws Exception {

    new PrimesServiceApplication().run(args);
  }

  @Override
  public String getName() {

    return "primes-service";
  }

  @Override
  public void initialize(Bootstrap<PrimesServiceConfig> boot) {

    // do nothing
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void run(PrimesServiceConfig conf, Environment env) {

    Map<String, PrimeGenerator> generators = Maps.transformValues(conf.getAlgorithms(),
        new Function<String, PrimeGenerator>() {

          @Override
          public PrimeGenerator apply(String input) {

            try {
              return (PrimeGenerator) Class.forName(input).newInstance();
            } catch (Exception e) {
              LOG.error("Error initializing PrimeGenerators from config", e);
              throw new IllegalStateException("Error initializing PrimeGenerators from config", e);
            }
          }
        });

    Map<String, PrimeGeneratorCache> caches = Maps.transformValues(conf.getCachingStrategies(),
        new Function<String, PrimeGeneratorCache>() {

          @Override
          public PrimeGeneratorCache apply(String input) {

            try {
              return (PrimeGeneratorCache) Class.forName(input).newInstance();
            } catch (Exception e) {
              LOG.error("Error initializing PrimeGeneratorCaches from config", e);
              throw new IllegalStateException("Error initializing PrimeGeneratorCaches from config", e);
            }
          }
        });

    PrimeGeneratorCache cache = caches.get(conf.getCachingStrategyName());
    if (cache == null) {
      LOG.error("Unknown caching strategy name {}", conf.getCachingStrategyName());
      throw new IllegalArgumentException("Unknown caching strategy name '" + conf.getCachingStrategyName() + "'");
    }

    PrimesResource res = new PrimesResource(generators, cache, conf.getDefaultAlgorithmName());
    env.jersey().register(res);
  }
}
