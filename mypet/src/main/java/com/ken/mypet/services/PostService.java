package com.ken.mypet.services;

import java.util.List;

import com.ken.mypet.entities.Post;

public interface PostService {
    public Post savePost(Post post);
    public void deletePost(long id);
    public Post updatePost(long id, Post post);
    public List<Post> findAll();
    public List<Post> findByPersonId(Integer id);
}
