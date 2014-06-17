package uk.co.ompispot.primes.service.config;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

/**
 * Auto-instantiated config class for the prime service.
 * 
 * @author sgerogiannakis
 */
public class PrimeServiceConfig extends Configuration {

  @JsonProperty("defaultAlgorithm")
  @Valid
  @NotNull
  private String defaultAlgorithmName;

  @JsonProperty("cachingStrategy")
  @Valid
  @NotNull
  private String cachingStrategyName;

  @JsonProperty
  @Valid
  @NotNull
  private ImmutableList<NamedClassConfig> algorithms;

  @JsonProperty
  @Valid
  @NotNull
  private ImmutableList<NamedClassConfig> cachingStrategies;

  public String getDefaultAlgorithmName() {

    return defaultAlgorithmName;
  }

  public void setDefaultAlgorithmName(String defaultAlgorithmName) {

    this.defaultAlgorithmName = defaultAlgorithmName;
  }

  public String getCachingStrategyName() {

    return cachingStrategyName;
  }

  public void setCachingStrategyName(String cachingStrategyName) {

    this.cachingStrategyName = cachingStrategyName;
  }

  public ImmutableList<NamedClassConfig> getAlgorithms() {

    return algorithms;
  }

  public void setAlgorithms(ImmutableList<NamedClassConfig> algorithms) {

    this.algorithms = algorithms;
  }

  public ImmutableList<NamedClassConfig> getCachingStrategies() {

    return cachingStrategies;
  }

  public void setCachingStrategies(ImmutableList<NamedClassConfig> cachingStrategies) {

    this.cachingStrategies = cachingStrategies;
  }

}
