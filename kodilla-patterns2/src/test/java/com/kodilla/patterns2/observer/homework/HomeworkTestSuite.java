package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {
    @Test
    public void testUpdate() {
        //given
        Mentor kasia = new Mentor("Kasia");
        Mentor andrzej = new Mentor("Andrzej");
        Mentor monika = new Mentor("Monika");
        Mentor iza = new Mentor("iza");

        Homework decemberGroup =  new DecemberGroupHomework();
        Homework octoberGroup = new OctoberGroupHomeworks();

        decemberGroup.registerObserver(kasia);
        decemberGroup.registerObserver(andrzej);
        decemberGroup.registerObserver(monika);
        octoberGroup.registerObserver(monika);
        octoberGroup.registerObserver(iza);
        //When
        decemberGroup.addHomework("20.1 patterns");
        decemberGroup.addHomework("10.2 spring");
        octoberGroup.addHomework("1.3 object programing");
        octoberGroup.addHomework("15.3 hibernate");
        //Then
        assertEquals(2,kasia.getUpdateCount());
        assertEquals(2,andrzej.getUpdateCount());
        assertEquals(4,monika.getUpdateCount());
        assertEquals(2,iza.getUpdateCount());


    }
}
