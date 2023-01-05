package com.ken.mypet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ken.mypet.entities.Post;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    @Query("SELECT p FROM Post p WHERE p.person.id = ?1")
    public Iterable<Post> findByPersonId(Integer id);
    @Query("DELETE FROM Post p WHERE p.id = ?1")
    public void deleteById(long id);
    @Query("SELECT p FROM Post p WHERE p.id = ?1")
    public Post findById(long id);
    @Query("SELECT p FROM Post p")
    public List<Post> findAll();
    
}
