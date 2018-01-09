package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    @BeforeClass
    public static void log(){
        Logger.getInstance().log("User21313613");
    }

    @Test
    public void getLastLogTestSuite() {
        //Given
        // When
        String lastLog = Logger.getInstance().getLastLog();
        Assert.assertEquals("User21313613",lastLog);
    }
}
