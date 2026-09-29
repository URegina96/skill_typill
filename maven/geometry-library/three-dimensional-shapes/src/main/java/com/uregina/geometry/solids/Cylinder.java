package com.uregina.geometry.solids;

import com.uregina.geometry.shapes.Circle;

public class Cylinder extends Prism {

    public Cylinder(double radius, double height) {
        super(new Circle(radius), height);
    }

    @Override
    public String name() {
        return "Cylinder";
    }
}
