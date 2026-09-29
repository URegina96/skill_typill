package com.uregina.geometry.utils;

public final class UnitConverter {

    private UnitConverter() {
    }

    public static double convertLength(double value, LengthUnit from, LengthUnit to) {
        return to.fromMeters(from.toMeters(value));
    }

    public static double convertArea(double value, LengthUnit from, LengthUnit to) {
        double factor = convertLength(1, from, to);
        return value * factor * factor;
    }
}
