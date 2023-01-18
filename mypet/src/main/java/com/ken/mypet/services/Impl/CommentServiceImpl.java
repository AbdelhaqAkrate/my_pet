package com.ken.mypet.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ken.mypet.entities.Comment;
import com.ken.mypet.repository.CommentRepository;
import com.ken.mypet.services.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findByPostId(long id) {
        return commentRepository.findByPostId(id);
    }
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
    public void deleteByPostId(long id) {
        commentRepository.deleteByPostId(id);
    }
    public Comment findById(long id) {
        return commentRepository.findById(id);
    }
}


