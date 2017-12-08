package com.kodilla.testing.collection;
import com.kodilla.testing.OddNumbersExterminator;
import org.junit.*;

import java.util.ArrayList;


public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){

        ArrayList<Integer> testList = new ArrayList<>();
        int testListSize = testList.size();


        OddNumbersExterminator theList = new OddNumbersExterminator();

        ArrayList<Integer> evenNumberList = theList.exterminate(testList);
        System.out.println("Testing 1st case: empty list - result: " + evenNumberList);


        Assert.assertTrue(evenNumberList.size()==0);

    }
    @Test
    public void testOddNumbersExterminatorNormalList(){

        ArrayList<Integer> testList = new ArrayList<>();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(15);
        testList.add(17);
        testList.add(26);
        testList.add(28);
        testList.add(39);

        OddNumbersExterminator theList = new OddNumbersExterminator();

        ArrayList<Integer> evenNumberList= theList.exterminate(testList);
        System.out.println("Testing 2nd case list containing numbers result: " + evenNumberList);

        Assert.assertTrue(evenNumberList.size()==3);



    }
}