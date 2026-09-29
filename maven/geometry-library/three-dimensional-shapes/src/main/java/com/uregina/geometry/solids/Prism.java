package com.uregina.geometry.solids;

import com.uregina.geometry.shapes.Shape;

public class Prism implements Solid {

    private final Shape base;
    private final double height;

    public Prism(Shape base, double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("height must be positive");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double volume() {
        return base.area() * height;
    }

    @Override
    public double surfaceArea() {
        return 2 * base.area() + base.perimeter() * height;
    }

    @Override
    public String name() {
        return base.name() + "Prism";
    }
}
