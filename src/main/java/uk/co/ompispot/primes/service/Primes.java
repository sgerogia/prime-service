package uk.co.ompispot.primes.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A simple DTO for the serialization of the values.
 * 
 * @author sgerogiannakis
 */
@XmlRootElement(name = "result")
public class Primes {

  private int limit;

  private int[] primes;

  public Primes() {

  }

  public Primes(int limit, int[] primes) {

    this.limit = limit;
    this.primes = primes;
  }

  @JsonProperty("initial")
  @XmlElement(name = "initial")
  public int getLimit() {

    return limit;
  }

  @JsonProperty("primes")
  @XmlElement(name = "primes")
  public int[] getPrimes() {

    return primes;
  }

}
