package com.uregina.geometry.shapes;

public interface Shape {

    double area();

    double perimeter();

    default String name() {
        return getClass().getSimpleName();
    }
}
