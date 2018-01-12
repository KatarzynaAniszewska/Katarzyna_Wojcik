package com.kodilla.patterns.strategy.social;

public class User {
    final private String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void   sharePost(SocialPublisher socialPublisher){
        this.socialPublisher = socialPublisher;
    }
    public String  share(){
        return socialPublisher.share();
    }
}

