package com.crm.controller;

import com.crm.entity.Comment;
import com.crm.entity.Post;
import com.crm.repository.CommentRepository;
import com.crm.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private PostRepository postRepository;
    private CommentRepository commentRep;

    public CommentController(PostRepository postRepository, CommentRepository commentRep) {
        this.postRepository = postRepository;
        this.commentRep = commentRep;
    }

    @PostMapping
    public String CreateComment(
            @RequestBody Comment comment,
            @RequestParam long postId
            ){
        Post post = postRepository.findById(postId).get();
        comment.setPost(post);

        commentRep.save(comment);
        return "Comment created successfully!";
    }
}
