package com.uregina.geometry.utils;

import com.uregina.geometry.shapes.Shape;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public final class ShapeUtils {

    public static final Comparator<Shape> BY_AREA = Comparator.comparingDouble(Shape::area);
    public static final Comparator<Shape> BY_PERIMETER = Comparator.comparingDouble(Shape::perimeter);

    private static final double EPS = 1e-9;

    private ShapeUtils() {
    }

    public static Optional<Shape> largest(Collection<? extends Shape> shapes) {
        return shapes.stream().map(Shape.class::cast).max(BY_AREA);
    }

    public static double totalArea(Collection<? extends Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }

    public static boolean sameArea(Shape first, Shape second) {
        return Math.abs(first.area() - second.area()) < EPS;
    }
}
