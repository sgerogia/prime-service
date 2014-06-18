package uk.co.ompispot.primes.service.config;

import io.dropwizard.Configuration;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-instantiated config class for the prime service.
 * 
 * @author sgerogiannakis
 */
public class PrimesServiceConfig extends Configuration {

  @JsonProperty("defaultAlgorithm")
  @Valid
  @NotNull
  private String defaultAlgorithmName;

  @JsonProperty("cachingStrategy")
  @Valid
  @NotNull
  private String cachingStrategyName;

  @JsonProperty("algorithms")
  @Valid
  @NotNull
  private Map<String, String> algorithms;

  @JsonProperty("cachingStrategies")
  @Valid
  @NotNull
  private Map<String, String> cachingStrategies;

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

  public Map<String, String> getAlgorithms() {

    return algorithms;
  }

  public void setAlgorithms(Map<String, String> algorithms) {

    this.algorithms = algorithms;
  }

  public Map<String, String> getCachingStrategies() {

    return cachingStrategies;
  }

  public void setCachingStrategies(Map<String, String> cachingStrategies) {

    this.cachingStrategies = cachingStrategies;
  }

}
