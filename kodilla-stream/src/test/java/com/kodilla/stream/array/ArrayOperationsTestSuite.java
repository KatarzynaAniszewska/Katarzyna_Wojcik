package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){

        //Given
        int[]numbers={1,3,8,9,15,25,40};
        //When
       double average = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(14.428,average,0.001);


    }
}
