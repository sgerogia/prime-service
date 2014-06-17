/**
 * $Id: PrimeServiceApplication.java 17 Jun 2014 19:51:57 sgerogiannakis Exp $ $Copyright: Copyright 2002-2014
 * Expedia.com, L.P. All rights reserved. $
 */
package uk.co.ompispot.primes;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.co.ompispot.primes.service.config.PrimeServiceConfig;

/**
 * Prime service application launcher.
 * 
 * @author sgerogiannakis
 */
public class PrimeServiceApplication extends Application<PrimeServiceConfig> {

  public static void main(String[] args) throws Exception {

    new PrimeServiceApplication().run(args);
  }

  @Override
  public String getName() {

    return "prime-service";
  }

  @Override
  public void initialize(Bootstrap<PrimeServiceConfig> boot) {

    // do nothing
  }

  @Override
  public void run(PrimeServiceConfig conf, Environment env) throws Exception {

    // do nothing
  }

}
