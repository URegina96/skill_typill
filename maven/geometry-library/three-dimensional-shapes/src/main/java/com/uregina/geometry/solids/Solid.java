package com.uregina.geometry.solids;

import java.util.Locale;

public interface Solid {

    double volume();

    double surfaceArea();

    default String name() {
        return getClass().getSimpleName();
    }

    default String describe() {
        return String.format(Locale.ROOT, "%-10s volume = %8.2f, surface = %8.2f", name(), volume(), surfaceArea());
    }
}
