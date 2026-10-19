package dev.leobrut.tri_cat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Main {

    public static final int EXIT_OK = 0;
    public static final int EXIT_INVALID_DATA = 1;

    public static void main(String[] args) {
        int code = run(args);
        if (code != 0) System.exit(code);
    }

    /**
     * Testable entry point. Returns the process exit code: 0 ok, 1 I/O error, 2 bad usage.
     */
    static int run(String[] args) {

        InputReader inputReader = new InputReader();
        Validator validator = new Validator();
        Categorizer categorizer = new Categorizer();
        OutputWriter outputWriter = new OutputWriter();

        Triangle triangle = inputReader.read();
        if (validator.isTriangleValid(triangle)) {
            var category = categorizer.categorize(triangle);
            outputWriter.write(category);
            return EXIT_OK;
        } else {
            log.error("invalid data");
            return EXIT_INVALID_DATA;
        }
    }
}
