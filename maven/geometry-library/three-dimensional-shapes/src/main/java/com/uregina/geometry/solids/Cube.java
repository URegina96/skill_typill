package com.uregina.geometry.solids;

public class Cube implements Solid {

    private final double edge;

    public Cube(double edge) {
        if (edge <= 0) {
            throw new IllegalArgumentException("edge must be positive");
        }
        this.edge = edge;
    }

    @Override
    public double volume() {
        return edge * edge * edge;
    }

    @Override
    public double surfaceArea() {
        return 6 * edge * edge;
    }
}
