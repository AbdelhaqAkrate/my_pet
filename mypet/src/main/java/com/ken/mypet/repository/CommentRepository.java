package com.ken.mypet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ken.mypet.entities.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer>{

    @Query("SELECT c FROM Comment c WHERE c.postComment.id = :id")
    List<Comment> findByPostId(@Param("id") Long id);
    //get all comments
    @Query("SELECT c FROM Comment c")
    List<Comment> findAll();
    //save 
    public Comment save(Comment comment);
    //delete by post id
    @Query("DELETE FROM Comment c WHERE c.postComment.id = :id")
    public void deleteByPostId(@Param("id") Long id);
    //find by comment id
    @Query("SELECT c FROM Comment c WHERE c.id = :id")
    public Comment findById(@Param("id") Long id);
}
