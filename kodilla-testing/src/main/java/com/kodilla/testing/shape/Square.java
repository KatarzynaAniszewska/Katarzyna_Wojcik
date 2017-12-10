package com.kodilla.testing.shape;

public class Square implements Shape {
    String name;
    Double field;


    @Override

    public String getShapeName() {
        return "square";
    }


    @Override
    public double getField() {
        return field;

    }
}
