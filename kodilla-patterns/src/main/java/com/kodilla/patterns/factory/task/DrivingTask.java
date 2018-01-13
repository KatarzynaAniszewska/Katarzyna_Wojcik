package com.kodilla.patterns.factory.task;

import java.time.LocalDate;

public final class DrivingTask implements Task {
    final String taskName;
    final String where;
    final String using;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {
        return new StringBuilder(where).append(" by " + using).toString();
    }

    @Override
    public String getTaskName() {
        return taskName;

    }

    @Override
    public boolean isTaskExecuted() {
        if(LocalDate.now().getDayOfMonth() % 2 == 0);
        return true;

    }
}
