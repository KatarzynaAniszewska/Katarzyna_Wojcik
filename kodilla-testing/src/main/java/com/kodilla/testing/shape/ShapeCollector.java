package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);

    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if ( n<shapes.size()) {
            Shape shape = shapes.get(n);

        return shape;
    }
        return null;
    }

    public void showFigures() {
    System.out.println(shapes);

    }
}
