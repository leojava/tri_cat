package dev.leobrut.tri_cat;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Main {

    public static void main(String[] args) {
        int code = run(args, System.out, System.err);
        if (code != 0) System.exit(code);
    }

    /** Testable entry point. Returns the process exit code: 0 ok, 1 I/O error, 2 bad usage. */
    static int run(String[] args, PrintStream stdout, PrintStream stderr) {
        InputReader inputReader = new InputReader();
        inputReader.read();
        return 0;
    }
}
