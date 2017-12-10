package com.kodilla.testing.shape;

public class Triangle implements Shape {
    String name;
    Double field;


    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public double getField() {
        return field;
    }
}
