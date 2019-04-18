package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser(1, "John", 'M', 1990, 1, 10, 0));
        theForumUserList.add(new ForumUser(2, "Tom", 'M', 1980, 2, 11, 11));
        theForumUserList.add(new ForumUser(3, "Any", 'F', 2004, 3, 12, 100));
        theForumUserList.add(new ForumUser(4, "Frank", 'M', 2005, 4, 21, 1));
        theForumUserList.add(new ForumUser(5, "Hanna", 'F', 2003, 5, 13, 200));
        theForumUserList.add(new ForumUser(6, "Julia", 'F', 2002, 6, 13, 5));
        theForumUserList.add(new ForumUser(7, "George", 'M', 1950, 7, 14, 250));
    }

    public List<ForumUser> getListForumUser() {
        return new ArrayList<>(theForumUserList);
    }
}
