package com.kodilla.testing.shape;

import static java.lang.Math.pow;

public class Circle implements Shape {
    String name;
    Double field;


    @Override
    public String getShapeName() {
        return "circle";
    }


    public double getField() {
        return field;
    }
}
