package com.sprint.services;

import com.sprint.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }

    public CommentRepository getCommentRepository(){
        return commentRepository;
    }
}
