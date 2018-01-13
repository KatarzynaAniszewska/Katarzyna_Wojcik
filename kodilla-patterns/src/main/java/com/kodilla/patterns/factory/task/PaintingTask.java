package com.kodilla.patterns.factory.task;

import java.time.LocalDate;

public final class PaintingTask implements Task {
    final String taskName;
    final String color;
    final String whatToPaint;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String executeTask() {
        return new StringBuilder(whatToPaint).append(" on "+color).toString();
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
