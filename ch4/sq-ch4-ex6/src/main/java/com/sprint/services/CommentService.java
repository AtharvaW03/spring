package com.sprint.services;

import com.sprint.model.Comment;
import com.sprint.proxies.CommentNotificationProxy;
import com.sprint.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    //added new parameter for each injection. add or remove param based on injection needs
    private final CommentNotificationProxy emailProxy;
    private final CommentNotificationProxy pushProxy;
    private final CommentRepository commentRepository;

    public CommentService(
            CommentRepository commentRepository,
            @Qualifier("PUSH") CommentNotificationProxy pushProxy,
            @Qualifier("EMAIL") CommentNotificationProxy emailProxy){

        this.pushProxy = pushProxy;
        this.emailProxy = emailProxy;
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        emailProxy.sendComment(comment);
        pushProxy.sendComment(comment);
    }
}
