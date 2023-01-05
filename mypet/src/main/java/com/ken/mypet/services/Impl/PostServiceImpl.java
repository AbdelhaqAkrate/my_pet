package com.ken.mypet.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ken.mypet.entities.Post;
import com.ken.mypet.repository.PostRepository;
import com.ken.mypet.services.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
    public Post updatePost(long id, Post post) {
        Post p = postRepository.findById(id);
        p.setContent(post.getContent());
        return postRepository.save(p);
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public List<Post> findByPersonId(Integer id) {
        return (List<Post>) postRepository.findByPersonId(id);
    }
}
