package com.sprint.services;

import com.sprint.model.Comment;
import com.sprint.proxies.CommentNotificationProxy;
import com.sprint.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
     @Autowired
     private CommentRepository commentRepository;
     @Autowired
     private CommentNotificationProxy commentNotificationProxy;

     public void publishComment(Comment comment){
         commentRepository.storeComment(comment);
         commentNotificationProxy.sendComment(comment);
     }
}
