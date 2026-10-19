package dev.leobrut.tri_cat;

public class Categorizer {

    public TriangleType categorize(Triangle triangle) {
        var sideA = triangle.sideA();
        var sideB = triangle.sideB();
        var sideC = triangle.sideC();

        // ALL sides equal
        if (sideA.equals(sideB) && sideB.equals(sideC)) {
            return TriangleType.EQUILATERAL;
        }

        // any pair of sides equal
        if (sideA.equals(sideB) || sideB.equals(sideC) || sideC.equals(sideA)) {
            return TriangleType.ISOSCELES;
        }

        // ALL sides different
        return TriangleType.SCALENE;
    }

}


