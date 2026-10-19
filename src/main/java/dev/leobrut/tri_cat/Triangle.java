package dev.leobrut.tri_cat;


import java.math.BigDecimal;

// could be an array or whatever, at least it's enforced to have 3 elements
public record Triangle(
        BigDecimal sideA,
        BigDecimal sideB,
        BigDecimal sideC
) {

    // area()
    // perimeter()
    // potentially internal validation
    // ...

}
