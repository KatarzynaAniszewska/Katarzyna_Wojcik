package com.kodilla.testing.mock;

import com.kodilla.testing.stub.Temperatures;
import com.kodilla.testing.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        HashMap<Integer, Double> temperaturesMap = new HashMap<Integer, Double>();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        temperaturesMap.put(0, 25.5);
        temperaturesMap.put(1, 26.2);
        temperaturesMap.put(2, 24.8);
        temperaturesMap.put(3, 25.2);
        temperaturesMap.put(4, 26.1);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();


        //Then

    }
}
