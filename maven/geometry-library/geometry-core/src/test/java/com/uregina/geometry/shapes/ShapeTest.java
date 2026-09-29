package com.uregina.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeTest {

    private static final double EPS = 1e-9;

    @Test
    void circle() {
        Circle circle = new Circle(2);
        assertEquals(4 * Math.PI, circle.area(), EPS);
        assertEquals(4 * Math.PI, circle.perimeter(), EPS);
    }

    @Test
    void rectangle() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(12, rectangle.area(), EPS);
        assertEquals(14, rectangle.perimeter(), EPS);
    }

    @Test
    void triangle() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(6, triangle.area(), EPS);
        assertEquals(12, triangle.perimeter(), EPS);
    }

    @Test
    void invalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 10));
    }
}
