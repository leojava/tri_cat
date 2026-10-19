package dev.leobrut.tri_cat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

class CategorizerTest {

    @ParameterizedTest
    @CsvSource(
            textBlock = """
                    4,4,4,EQUILATERAL
                    4,4,6,ISOSCELES
                    5,12,13,SCALENE
                    """
    )
    void testCategorizer(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC, TriangleType type) {
        Categorizer categorizer = new Categorizer();

        Triangle triangle = new Triangle(sideA, sideB, sideC);
        Assertions.assertThat(categorizer.categorize(triangle))
                .isEqualTo(type);
    }
}