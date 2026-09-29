package com.uregina.geometry.solids;

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
}
