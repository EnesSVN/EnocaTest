package com.example.enocatest.service;

import com.example.enocatest.entity.Comment;
import com.example.enocatest.entity.Tutorial;
import com.example.enocatest.repository.CommentRepository;
import com.example.enocatest.repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

   private CommentRepository commentRepository;


   public CommentService(CommentRepository commentRepository){
       this.commentRepository = commentRepository;
   }

   public List<Comment>getAllCommentByTutorialId(Long tutorialId){
       return commentRepository.findByTutorialId(tutorialId);
   }

   public Optional<Comment> getComment(Long id){
       return commentRepository.findById(id);
   }

   public Comment createComment(Comment comment){
       return commentRepository.save(comment);
   }

   public Comment updateComment(Comment comment){
       return commentRepository.save(comment);
   }

   public void deleteComment(Long id){
       commentRepository.deleteById(id);
   }




}
