package com.uregina.geometry.app;

import com.uregina.geometry.shapes.Circle;
import com.uregina.geometry.shapes.Rectangle;
import com.uregina.geometry.shapes.Shape;
import com.uregina.geometry.shapes.Square;
import com.uregina.geometry.shapes.Triangle;

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
    }
}
