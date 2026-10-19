# tri_cat 

## open questions

- it's both written in the description that it should be a small and pragmatic solution but later on it's requested to have an extendable (for different shapes?), production-ready one, which sounds very vague. (what is needed? a full project, packaging, logging, testing, a full spring server?)
- There's no mention about the validation of input and about the corner case of degenerate triangles (a+b=c), for which I don't know if it can still possibly be isosceles or scalene.
- There's no mention of how input and output should be given, if by a file, stdin, stdout, parameters and what is the structure of the input apart "3 numbers" (if by file, comma separated? structured json? etc..)


## assumptions

- input is read from stdin as 3 numbers each followed by a newline
- output is written on stdout
- validation was not explicitly requested
  - sides are non-null positive numbers
  - each pair of sides must have sum greater than the remaining side
  - degenerate triangles (a+b=c) are NOT valid
- objective asked for a production-ready app; what was added:
  - this is a maven project with java 21 
  - some degree of separation and potentially IoC
  - simple logging
  - unit testing
- data was kept simple with just a Triangle class, there could be some kind of Shape with an array of sides but I decided to enforce 3 values for ease of completion


## other notes

- as stated, only side length is taken into account for categorization, angles are ignored
- AI was used only for the boilerplate code and for research on types and validation of triangles


## run and commands

Build + test:  mvn package          (produces target/tri_cat.jar, self-contained)
Tests only:    mvn test

Run:      java -jar target/tri_cat.jar --principal 1000 --rate 5 --years 10
File in:  java -jar target/tri_cat.jar --in input.properties
File out: java -jar target/tri_cat.jar --in input.properties --out result.properties

Logging (slf4j-simple, goes to stderr; stdout carries only the result):
  default level: info   (config: src/main/resources/simplelogger.properties)
  debug at runtime: java -Dorg.slf4j.simpleLogger.defaultLogLevel=debug -jar target/tri_cat.jar ...
