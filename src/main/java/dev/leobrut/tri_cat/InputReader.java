package dev.leobrut.tri_cat;

import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads three numbers from an input stream (stdin by default) and turns them into {@link BigDecimal}s.
 * <p>
 * The numbers are whitespace-separated and may be on one line or spread over several.
 * Use a decimal point, not a comma ("1.5", not "1,5"). Anything after the third number is ignored.
 */
public final class InputReader {

    /** The three values that were read, in input order. */
    public record Numbers(BigDecimal first, BigDecimal second, BigDecimal third) {}

    private static final int COUNT = 3;

    private final InputStream in;

    public InputReader() {
        this(System.in);
    }

    public InputReader(InputStream in) {
        this.in = in;
    }

    /**
     * @throws IllegalArgumentException if fewer than three numbers are available or a token is not a number
     */
    public Numbers read() {
        // Deliberately not closed: closing the scanner would also close System.in.
        Scanner scanner = new Scanner(in, StandardCharsets.UTF_8);

        List<BigDecimal> values = new ArrayList<>(COUNT);
        while (values.size() < COUNT && scanner.hasNext()) {
            values.add(parse(scanner.next()));
        }
        if (values.size() < COUNT) {
            throw new IllegalArgumentException(
                    "expected " + COUNT + " numbers on stdin, got " + values.size());
        }
        return new Numbers(values.get(0), values.get(1), values.get(2));
    }

    private static BigDecimal parse(String token) {
        try {
            return new BigDecimal(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("not a valid number: " + token);
        }
    }
}
