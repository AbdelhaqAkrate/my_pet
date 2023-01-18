package com.ken.mypet.services;

import java.util.List;

import com.ken.mypet.dto.CommentDto;
import com.ken.mypet.entities.Comment;

public interface CommentService {
    public List<Comment> findByPostId(long id);
    public List<Comment> findAll();
    public Comment save(Comment comment);
    public void deleteByPostId(long id);
    public Comment findById(long id);
}
