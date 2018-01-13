package com.kodilla.patterns.factory.task;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.plaf.PanelUI;

public final class TaskFactory {
    public static final String SHOPPINGtASK="SHOPPINGtASK";
    public static final String PAINTINGtASK="PAINTINGtASK";
    public static final String DRIVINGtASK = "DRIVINGtASK";

    public final Task makeTask(final String taskClass){
        switch (taskClass){
            case SHOPPINGtASK:
                return new ShoppingTask("ShoppingTask1","cars",50);
            case PAINTINGtASK:
                return new PaintingTask("PaintingTask1","blue","ceiling");
            case DRIVINGtASK:
                    return new DrivingTask("DrivingTask1","Germany","motorcycle");
                    default:
                        return null;
        }
    }


}
