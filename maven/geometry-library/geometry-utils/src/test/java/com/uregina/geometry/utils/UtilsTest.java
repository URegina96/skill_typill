package com.uregina.geometry.utils;

import com.uregina.geometry.shapes.Circle;
import com.uregina.geometry.shapes.Rectangle;
import com.uregina.geometry.shapes.Shape;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {

    @Test
    void convertsLengthAndArea() {
        assertEquals(250, UnitConverter.convertLength(2.5, LengthUnit.METER, LengthUnit.CENTIMETER), 1e-9);
        assertEquals(10_000, UnitConverter.convertArea(1, LengthUnit.METER, LengthUnit.CENTIMETER), 1e-9);
    }

    @Test
    void findsLargestAndSums() {
        Shape small = new Rectangle(1, 2);
        Shape big = new Circle(3);
        assertSame(big, ShapeUtils.largest(List.of(small, big)).orElseThrow());
        assertEquals(2 + 9 * Math.PI, ShapeUtils.totalArea(List.of(small, big)), 1e-9);
    }

    @Test
    void comparesArea() {
        assertTrue(ShapeUtils.sameArea(new Rectangle(2, 8), new Rectangle(4, 4)));
    }
}
