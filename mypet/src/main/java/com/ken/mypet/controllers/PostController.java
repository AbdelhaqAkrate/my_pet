package com.ken.mypet.controllers;

import com.ken.mypet.services.PersonService;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.*;
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

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostService postService;
    private PersonService personService;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtHelper jwtHelper;
    private UserDetails userDetails;

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
        post.setContent(postDto.getDescription());
        Person person = personService.findById(postDto.getPerson_id());
        post.setPerson(person);
        try {
            postService.savePost(post);
            return ResponseEntity.ok("Post created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Post not created");
        }

    }
}
