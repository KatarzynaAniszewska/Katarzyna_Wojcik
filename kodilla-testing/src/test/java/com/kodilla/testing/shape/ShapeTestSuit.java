package com.kodilla.testing.shape;
import com.kodilla.testing.shape.ShapeCollector;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;

public class ShapeTestSuit {
    private static int testCounter=0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
@Test
    public void testAddFigure() {
        //Given

        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        shapeCollector.addFigure(new Circle());

        //Then

        Assert.assertEquals(1,shapeCollector.shapes.size());
    }
    @Test
    public void testRemoveFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Circle());

        //When
        Circle circle = (Circle) shapeCollector.shapes.get(0);
        shapeCollector.removeFigure(circle);

        //Then

        Assert.assertTrue(shapeCollector.shapes.size() == 0);

    }

    @Test
    public void testGetFigure() {

        //Given

        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle();
        shapeCollector.shapes.add(new Circle());

        //When
        Shape shape = shapeCollector.getFigure(0);
        Shape shape1 = shapeCollector.shapes.get(0);

        //Then

       Assert.assertEquals(shape,shape1);
    }

@Test
    public void testShowFigure() {
    //Given
    ShapeCollector shapeCollector = new ShapeCollector();
    ArrayList<Shape> shapes = new ArrayList<>();
    shapes.add(new Circle());
    //When
    System.out.println(shapes);
    //Then
    Assert.assertNotNull(shapes);

}
}
