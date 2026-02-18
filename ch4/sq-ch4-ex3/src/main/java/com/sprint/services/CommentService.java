package com.sprint.services;

import com.sprint.model.Comment;
import com.sprint.proxies.CommentNotificationProxy;
import com.sprint.repositories.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    public CommentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy){

        this. commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
