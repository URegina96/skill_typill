package com.uregina.geometry.solids;

import com.uregina.geometry.shapes.Rectangle;
import com.uregina.geometry.utils.LengthUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolidTest {

    private static final double EPS = 1e-9;

    @Test
    void cube() {
        Cube cube = new Cube(3);
        assertEquals(27, cube.volume(), EPS);
        assertEquals(54, cube.surfaceArea(), EPS);
    }

    @Test
    void sphere() {
        Sphere sphere = new Sphere(1);
        assertEquals(4.0 / 3 * Math.PI, sphere.volume(), EPS);
        assertEquals(4 * Math.PI, sphere.surfaceArea(), EPS);
    }

    @Test
    void prismAndCylinder() {
        Prism box = new Prism(new Rectangle(2, 3), 4);
        assertEquals(24, box.volume(), EPS);
        assertEquals(52, box.surfaceArea(), EPS);

        Cylinder cylinder = new Cylinder(1, 2);
        assertEquals(2 * Math.PI, cylinder.volume(), EPS);
        assertEquals(6 * Math.PI, cylinder.surfaceArea(), EPS);
    }

    @Test
    void convertsVolume() {
        assertEquals(1000, VolumeConverter.convert(1, LengthUnit.METER, LengthUnit.CENTIMETER) / 1000, EPS);
    }
}
