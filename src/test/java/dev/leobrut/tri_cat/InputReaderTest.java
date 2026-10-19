package dev.leobrut.tri_cat;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class InputReaderTest {

    private static InputReader readerOf(String text) {
        return new InputReader(new ByteArrayInputStream(text.getBytes(UTF_8)));
    }

    @Test
    void readsThreeNumbersOnSeparateLines() {
        var n = readerOf("1\n2.5\n-3\n").read();

        assertThat(n.first()).isEqualTo(new BigDecimal("1"));
        assertThat(n.second()).isEqualTo(new BigDecimal("2.5"));
        assertThat(n.third()).isEqualTo(new BigDecimal("-3"));
    }

    @Test
    void readsThreeNumbersOnOneLineWithMixedWhitespace() {
        var n = readerOf("  1   2\t3 \n").read();

        assertThat(n.first()).isEqualByComparingTo("1");
        assertThat(n.second()).isEqualByComparingTo("2");
        assertThat(n.third()).isEqualByComparingTo("3");
    }

    @Test
    void keepsFullPrecision() {
        var n = readerOf("0.1 12345678901234567890.123456789 1e3").read();

        assertThat(n.first()).isEqualTo(new BigDecimal("0.1"));
        assertThat(n.second()).isEqualTo(new BigDecimal("12345678901234567890.123456789"));
        assertThat(n.third()).isEqualByComparingTo("1000");
    }

    @Test
    void ignoresInputAfterTheThirdNumber() {
        var n = readerOf("1 2 3 4 not-a-number").read();

        assertThat(n.third()).isEqualByComparingTo("3");
    }

    @Test
    void tooFewNumbersIsReported() {
        assertThatThrownBy(() -> readerOf("1 2").read())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("expected 3 numbers")
                .hasMessageContaining("got 2");
    }

    @Test
    void emptyInputIsReported() {
        assertThatThrownBy(() -> readerOf("").read())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("got 0");
    }

    @Test
    void nonNumericTokenIsReported() {
        assertThatThrownBy(() -> readerOf("1 abc 3").read())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("abc");
    }

    @Test
    void decimalCommaIsRejected() {
        assertThatThrownBy(() -> readerOf("1,5 2 3").read())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,5");
    }
}
