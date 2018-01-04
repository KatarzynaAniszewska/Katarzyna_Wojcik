package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculatorTestSuite {
    public void testCalculations(){
        //Given
        ApplicationContext context=
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator= context.getBean(Calculator.class);

        //When
        double valAdd = calculator.add(8,8);
        double valSub = calculator.sub(8,8);
        double valMul = calculator.mul(8,8);
        double valDiv = calculator.div(8,8);

        //Then
        Assert.assertEquals(16,valAdd,0);
        Assert.assertEquals(0,valSub,0);
        Assert.assertEquals(64,valMul,0);
        Assert.assertEquals(1,valDiv,0);
    }
}
