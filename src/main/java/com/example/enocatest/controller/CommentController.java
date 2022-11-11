package com.example.enocatest.controller;

import com.example.enocatest.entity.Comment;
import com.example.enocatest.exception.ResourceNotFoundException;
import com.example.enocatest.service.CommentService;
import com.example.enocatest.service.TutorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    private TutorialService tutorialService;

    private CommentService commentService;


    public CommentController(TutorialService tutorialService,
                             CommentService commentService) {
        this.tutorialService = tutorialService;
        this.commentService = commentService;
    }

    @GetMapping("/tutorial/{tutorialId}/comment")
    public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(@PathVariable(value = "tutorialId")
                                                                        Long tutorialId) {
        List<Comment> comments = commentService.getAllCommentByTutorialId(tutorialId);
        return  new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> getCommentByTutorialId(@PathVariable(value = "id") Long id) {
        Comment comment = commentService.getComment(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }


    @PostMapping("/tutorial/{tutorialId}/comment")
    public ResponseEntity<Comment> createComment(@PathVariable(value = "tutorialId") Long tutorialId,
                                                 @RequestBody Comment comment) {
        Comment comment1 = tutorialService.getTutorialById(tutorialId).map(tutorial -> {
            comment.setTutorial(tutorial);
            return commentService.createComment(comment);
        }).orElseThrow(() -> new RuntimeException("Not found Tutorial with id = " + tutorialId));

        return new ResponseEntity<>(comment1, HttpStatus.CREATED);
    }

    @PutMapping("/update/comment/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable(name = "id") Long id,
                                                 @RequestBody Comment comment){
        Comment comment1 = commentService.getComment(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));
        comment1.setContent(comment.getContent());
        return new ResponseEntity<>(commentService.updateComment(comment1), HttpStatus.OK);
    }

    @DeleteMapping("/delete/comment/{id}")
    public ResponseEntity<Map<String,Boolean>>  deleteComment(@PathVariable("id") long id) {
        commentService.deleteComment(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
