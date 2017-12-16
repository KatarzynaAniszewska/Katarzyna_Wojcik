package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(){
        forumUserList.add(new ForumUser(1000,"Aaaaa",'m',
                1990,10,10,55));
        forumUserList.add(new ForumUser(1001,"Bbbbbb",'f',
                2000,10,11,66));
        forumUserList.add(new ForumUser(1002,"Ccccc",'m',
                2001,8,1,88));
        forumUserList.add(new ForumUser(1003,"Dddddd",'f',
                1989,7,10,0));
        forumUserList.add(new ForumUser(1004,"Eeeeee",'m',
                1988,6,10,111));
        forumUserList.add(new ForumUser(1005,"Fffffff",'f',
                1993,10,10,122));
    }
    public List<ForumUser>getList(){
        return new ArrayList<>(forumUserList);
    }
}

