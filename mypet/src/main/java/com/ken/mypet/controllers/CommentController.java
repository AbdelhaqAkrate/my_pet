package com.ken.mypet.controllers;

import java.util.ArrayList;
import java.util.List;

import com.ken.mypet.dto.CommentDto;
import com.ken.mypet.entities.Comment;
import com.ken.mypet.response.CommentResponse;
import com.ken.mypet.services.Impl.CommentServiceImpl;
import com.ken.mypet.services.Impl.PersonServiceImpl;
import com.ken.mypet.services.Impl.PostServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private PostServiceImpl postService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable long id) {
       List<Comment> comments = commentService.findByPostId(id);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDto commentDto = new CommentDto();
            commentDto.setId(comment.getId());
            commentDto.setComment(comment.getComment());
            commentDto.setDate(comment.getDate());
            commentDto.setTime(comment.getTime());
            commentDto.setPost_id(comment.getPostComment().getId());
            commentDto.setPerson_id(comment.getPersonComment().getId());
            commentDtos.add(commentDto);
        }
       return new ResponseEntity<>(commentDtos, HttpStatus.OK);
   }
   @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentResponse>> getAllComments() {
         List<Comment> comments = commentService.findAll();
          List<CommentResponse> responses = new ArrayList<>();
          for (Comment comment : comments) {
                CommentResponse response = new CommentResponse();
                response.setId(comment.getId());
                response.setComment(comment.getComment());
                response.setDate(comment.getDate());
                response.setTime(comment.getTime());
                response.setPost_id(comment.getPostComment().getId());
                response.setPerson_id(comment.getPersonComment().getId());
                response.setName(comment.getPersonComment().getName());
                responses.add(response);
          }
         return new ResponseEntity<>(responses, HttpStatus.OK);
    }
     @PostMapping(value = "/add")
     public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto dto) {
          Comment comment = new Comment();
          comment.setComment(dto.getComment());
          comment.setDate(dto.getDate());
          comment.setTime(dto.getTime());
          System.out.println(dto.getTime());
          comment.setPersonComment(personService.findById(dto.getPerson_id()));
         System.out.println("selected person : " + personService.findById(dto.getPerson_id()));
          comment.setPostComment(postService.findById(dto.getPost_id()));
          commentService.save(comment);
          return new ResponseEntity<>(dto, HttpStatus.OK);
     }

//   @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto dto) {
//        Comment comment = new Comment();
//        comment.setComment(dto.getComment());
//        comment.setDate(dto.getDate());
//        comment.setTime(dto.getTime());
//        comment.setPersonComment(personService.findById(dto.getPerson_id()));
//        comment.setPostComment(postService.findById(dto.getPost_id()));
//        commentService.save(comment);
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }
}
