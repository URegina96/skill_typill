package com.uregina.geometry.utils;

public enum LengthUnit {
    MILLIMETER(0.001),
    CENTIMETER(0.01),
    METER(1),
    INCH(0.0254);

    private final double meters;

    LengthUnit(double meters) {
        this.meters = meters;
    }

    public double toMeters(double value) {
        return value * meters;
    }

    public double fromMeters(double value) {
        return value / meters;
    }
}
