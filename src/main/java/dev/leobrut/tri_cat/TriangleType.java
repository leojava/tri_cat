package dev.leobrut.tri_cat;

import lombok.RequiredArgsConstructor;


// side classification
@RequiredArgsConstructor
public enum TriangleType {
    EQUILATERAL("Equilateral"),
    ISOSCELES("Isosceles"),
    SCALENE("Scalene");

    final String output;
}
