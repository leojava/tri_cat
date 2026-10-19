package dev.leobrut.tri_cat;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class Validator {

    /**
     * checks that all sides are positive in lengths and that every sum of the sides are greater than the other side.
     * NOTE: Degenerate triangles (a+b=c) are techincally still triangles, not sure if they can still be scalene or isosceles.
     *
     * @param triangle the triangle to validate
     * @return whether the triangle has valid sides
     *
     */
    public boolean isTriangleValid(Triangle triangle) {
        boolean areSidesValid = isSideValid(triangle.sideA(), "sideA")
                && isSideValid(triangle.sideB(), "sideB")
                && isSideValid(triangle.sideC(), "sideC");

        if (!areSidesValid) {
            return false;
        }

        return isSumOfSidesValid(triangle.sideA(), triangle.sideB(), triangle.sideC())
                && isSumOfSidesValid(triangle.sideA(), triangle.sideC(), triangle.sideB())
                && isSumOfSidesValid(triangle.sideB(), triangle.sideC(), triangle.sideA());
    }

    private boolean isSideValid(BigDecimal side, String name) {
        if (side!=null && side.signum() > 0) {
            log.debug("side {} is valid", name);
            return true;
        }
        log.debug("side {} with value {} is invalid! ", name, side);
        return false;
    }

    private boolean isSumOfSidesValid(BigDecimal first, BigDecimal second, BigDecimal third) {
        BigDecimal sum = first.add(second);
        // 1 if greaterThan
        if (sum.compareTo(third) > 0) {
            log.debug("sum of {} and {} is {} whch is greater than {}", first, second, sum, third);
            return true;
        }
        log.debug("sum of sides {} and {} is {} which is NOT greater than {}", first, second, sum, third);
        return false;
    }

}
