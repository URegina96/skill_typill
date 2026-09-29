package com.uregina.geometry.app;

import com.uregina.geometry.shapes.Circle;
import com.uregina.geometry.shapes.Rectangle;
import com.uregina.geometry.shapes.Shape;
import com.uregina.geometry.shapes.Square;
import com.uregina.geometry.shapes.Triangle;
import com.uregina.geometry.solids.Cube;
import com.uregina.geometry.solids.Solid;
import com.uregina.geometry.solids.Sphere;
import com.uregina.geometry.utils.LengthUnit;
import com.uregina.geometry.utils.ShapeUtils;
import com.uregina.geometry.utils.UnitConverter;

import java.util.List;

public class GeometryApp {

    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Circle(1.5),
                new Rectangle(3, 4),
                new Triangle(3, 4, 5),
                new Square(2.5)
        );

        for (Shape shape : shapes) {
            System.out.println(shape.describe());
        }

        double total = ShapeUtils.totalArea(shapes);
        System.out.printf(java.util.Locale.ROOT, "total area: %.2f m2 = %.0f cm2%n", total, UnitConverter.convertArea(total, LengthUnit.METER, LengthUnit.CENTIMETER));
        ShapeUtils.largest(shapes).ifPresent(shape -> System.out.println("largest: " + shape.name()));
        System.out.println("by area: " + ShapeUtils.sortedByArea(shapes).stream().map(Shape::name).toList());

        List<Solid> solids = List.of(new Cube(2), new Sphere(1.5));
        solids.forEach(solid -> System.out.println(solid.describe()));
    }
}
