package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    public List<String> userNames();
    public int postsCount();
    public int commentsCount();
}
