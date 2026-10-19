package dev.leobrut.tri_cat;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

@Slf4j
class ValidatorTest {

    @ParameterizedTest
    @CsvSource(
            textBlock = """
                    ,1,1
                    1,,1
                    1,1,
                    """
    )
    void testNullSidesAreInvalid(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        log.debug("{} {} {}", sideA, sideB, sideC);
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        Validator validator = new Validator();
        Assertions.assertThat(validator.isTriangleValid(triangle))
                .isFalse();
    }

    @ParameterizedTest
    @CsvSource(
            textBlock = """
                    -1,1,1
                    1,-1,1
                    1,1,-1
                    0,1,1
                    1,0,1
                    1,1,0
                    """
    )
    void testNonPositiveSidesAreInvalid(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        Validator validator = new Validator();

        Assertions.assertThat(validator.isTriangleValid(triangle))
                .isFalse();
    }

    @ParameterizedTest
    @CsvSource(
            textBlock = """
                    2,1,1
                    1,2,1
                    1,1,2
                    """
    )
    void testDegenerateTriangleIsInvalid(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        Validator validator = new Validator();

        Assertions.assertThat(validator.isTriangleValid(triangle))
                .isFalse();
    }

    @ParameterizedTest
    @CsvSource(
            textBlock = """
                    3,1,1
                    1,3,1
                    1,1,3
                    """
    )
    void testSumOfSidesLowerThanTheOtherIsInvalid(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        Validator validator = new Validator();

        Assertions.assertThat(validator.isTriangleValid(triangle))
                .isFalse();
    }

    @Test
    void testValidTriangle() {
        Triangle triangle = new Triangle(BigDecimal.valueOf(3), BigDecimal.valueOf(4), BigDecimal.valueOf(5));
        Validator validator = new Validator();
        log.info("HEY!!");
        log.debug("..");

        Assertions.assertThat(validator.isTriangleValid(triangle))
                .isTrue();
    }

}