Primes service
==========

*Coding assignment for major retail bank*

Features
---
* 2 generator implementations, selectable via the optional "algorithm" query param (Sundaram, Eratosthenes)
* Startup option of using caching or not (in-memory implementation)
* Generates JSON (tested, supported) and XML (unsupported, hardly tested but works)
* Extensibility in all of the above

To use
---
* *mvn test* for unit tests 
* *mvn verify* ...plus integration tests
* *mvn package* for fat jar
* *java -jar ./target/primes-service-1.0-SNAPSHOT.jar server primes-service.yml* to start 
* *curl -i -H "Accept: application/json" http://localhost:8080/primes/20* to test

