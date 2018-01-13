package com.kodilla.patterns.factory.task;

import java.time.LocalDate;

public final class ShoppingTask implements Task {
    final String taskName;
    final String whatToBuy;
    final double quantity;


    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {
        String s= quantity+" "+whatToBuy;
        return new StringBuilder(s).toString();
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if(LocalDate.now().getDayOfMonth()%2==0);
        return true;
    }

}
