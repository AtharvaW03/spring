package com.sprint;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment){
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

//    public void deleteComment(Comment comment){
//        logger.info("Deleting comment: " + comment.getText());
//    }
//
//    public void editComment(Comment comment){
//        logger.info("Editing comment: " + comment.getText());
//    }


}
