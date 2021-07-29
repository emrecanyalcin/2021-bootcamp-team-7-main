package com.team7.backend.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.team7.backend.model.Comment;



@Service
public interface CommentService {

    public List<Comment> retrieveAllComments() throws ExecutionException, InterruptedException;

    public int saveComment(Comment comment) throws ExecutionException,InterruptedException;

    public List<Comment> retrieveCommentsById(String pictureId) throws ExecutionException, InterruptedException;



}

