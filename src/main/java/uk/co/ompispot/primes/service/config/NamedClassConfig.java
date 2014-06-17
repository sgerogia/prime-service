package uk.co.ompispot.primes.service.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A wrapper around a named class, initialized by the YAML configuration.
 * 
 * @author sgerogiannakis
 */
public class NamedClassConfig {

  @JsonProperty
  @Valid
  @NotNull
  private String name;

  @JsonProperty
  @Valid
  @NotNull
  private String implClass;

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getImplClass() {

    return implClass;
  }

  public void setImplClass(String implClass) {

    this.implClass = implClass;
  }

}
