package com.sprint.proxies;

import com.sprint.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
