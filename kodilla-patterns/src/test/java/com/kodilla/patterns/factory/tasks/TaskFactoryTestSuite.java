package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.task.DrivingTask;
import com.kodilla.patterns.factory.task.Task;
import com.kodilla.patterns.factory.task.TaskFactory;
import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVINGtASK);

        //Then
        Assert.assertEquals("DrivingTask1",drivingTask.getTaskName());
        Assert.assertEquals("Germany by motorcycle",drivingTask.executeTask());
    }
    @Test
    public void testFactoryPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTINGtASK);

        //Then
        Assert.assertEquals("PaintingTask1",paintingTask.getTaskName());
        Assert.assertEquals("ceiling on blue",paintingTask.executeTask());
    }
    @Test
    public void testFactoryShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPINGtASK);

        //Then
        Assert.assertEquals("ShoppingTask1",shoppingTask.getTaskName());
        Assert.assertEquals("50.0 cars",shoppingTask.executeTask());
    }
}
