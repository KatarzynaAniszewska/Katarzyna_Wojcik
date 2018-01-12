package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    //Given
    public void testDefaultSharingStrategies() {
        User jim = new Millenials("Jim");
        User john = new ZGeneration("John");
        User anna = new YGeneration("anna");

        //When

        String jimsSocialNetwork = jim.share();
        String johnsSocialNetwork = john.share();
        String annasSocialNetwork = anna.share();

        //Then
        Assert.assertEquals("Facebook", jimsSocialNetwork);
        Assert.assertEquals("Twitter", johnsSocialNetwork);
        Assert.assertEquals("Snapchat", annasSocialNetwork);
    }
    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User jim = new Millenials("Jim");
        String jimsSocialNetwork = jim.share();
        System.out.println("Jim's favourite SN was " + jimsSocialNetwork);
        jim.sharePost(new SnapchatPublisher());
        jimsSocialNetwork = jim.share();
        System.out.println("Jim's favourite SN is now "+jimsSocialNetwork);
        Assert.assertEquals("Snapchat",jimsSocialNetwork);


    }
}
