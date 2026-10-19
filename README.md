# tri_cat

Build + test:  mvn package          (produces target/tri_cat.jar, self-contained)
Tests only:    mvn test

Run:      java -jar target/tri_cat.jar --principal 1000 --rate 5 --years 10
File in:  java -jar target/tri_cat.jar --in input.properties
File out: java -jar target/tri_cat.jar --in input.properties --out result.properties

Logging (slf4j-simple, goes to stderr; stdout carries only the result):
  default level: info   (config: src/main/resources/simplelogger.properties)
  debug at runtime: java -Dorg.slf4j.simpleLogger.defaultLogLevel=debug -jar target/tri_cat.jar ...
