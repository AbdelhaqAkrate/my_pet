package com.ken.mypet.controllers;

import com.ken.mypet.response.PostsResponse;
import com.ken.mypet.services.CommentService;
import com.ken.mypet.services.PersonService;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.ken.mypet.dto.PostDto;
import com.ken.mypet.entities.Person;
import com.ken.mypet.entities.Post;
import com.ken.mypet.helpers.JwtHelper;
import com.ken.mypet.services.PostService;
import com.ken.mypet.services.Impl.CommentServiceImpl;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PostController {
   @Autowired
   private PostService postService;
   @Autowired
   private PersonService personService;
   @Autowired
   private CommentServiceImpl commentService;

   //here is the date on string format
   String pattern = "dd/MM/yyyy";
   SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
   String date = simpleDateFormat.format(new Date());




   public PostService getPersonService() {
       return postService;
   }
   @PostMapping("/new")
   public ResponseEntity<?> newPost(@RequestBody PostDto postDto) {
       System.out.println("newPost");
       Post post = new Post();
       post.setTitle(postDto.getTitle());
       post.setContent(postDto.getDescription());
       post.setDate(postDto.getDate());
       postDto.setTime(post.getTime());
       Person person = personService.findById(postDto.getPerson_id());
       post.setPerson(person);
       try {
           postService.savePost(post);
           return ResponseEntity.ok("Post created");
       } catch (Exception e) {
           return ResponseEntity.badRequest().body("Post not created");
       }
   }
    @GetMapping("/all")
    public ResponseEntity<?> getAllPosts() {
        List<Post> posts = postService.findAll();
        List<PostsResponse> response = new ArrayList<>();
        for (Post post : posts) {
            PostsResponse resp = new PostsResponse();
            resp.setId(post.getId());
            resp.setDescription(post.getContent());
            resp.setTitle(post.getTitle());
            resp.setDate(post.getDate());
            resp.setTime(post.getTime());
            resp.setName(post.getPerson().getName());
            resp.setPerson_id(post.getPerson().getId());
            response.add(resp);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //delete post
    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePost(@PathVariable long id) {
        try {
            System.out.println("deleete");
            commentService.deleteByPostId(id);
            postService.deletePost(id);

            return ResponseEntity.ok("Post deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Post not deleted");
        }
    }
}
