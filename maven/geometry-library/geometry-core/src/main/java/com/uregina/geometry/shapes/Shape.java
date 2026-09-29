package com.uregina.geometry.shapes;

public interface Shape {

    double area();

    double perimeter();

    default String name() {
        return getClass().getSimpleName();
    }

    default String describe() {
        return String.format(java.util.Locale.ROOT, "%-10s area = %8.2f, perimeter = %8.2f", name(), area(), perimeter());
    }
}
