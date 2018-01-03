package com.kodilla.spring.intro.shape;

public class Drawer {
    public Drawer(Shape shape) {
        this.shape = shape;
    }

    final Shape shape;


    public String  doDrawing(){
        return shape.draw();

    }
}
