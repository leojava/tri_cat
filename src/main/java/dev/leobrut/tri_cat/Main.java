package dev.leobrut.tri_cat;

import java.io.PrintStream;
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
