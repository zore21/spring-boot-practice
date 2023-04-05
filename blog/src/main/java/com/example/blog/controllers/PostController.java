package com.example.blog.controllers;

import com.example.blog.entities.Post;
import com.example.blog.payloads.PostDto;
import com.example.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {


    @Autowired
    private PostService postService;

    // create posts api
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
    ){
        PostDto createPost = this.postService.createPost(postDto,
                userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    // update posts api
    @PutMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> updatePost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
    ){
        return null;
    }

    // get posts by users
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
        List<PostDto> postsByUser = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
    }

    // get posts by category
    @GetMapping("/category/{categoryId}/posts")
        public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDto> postsByCategory = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(postsByCategory, HttpStatus.OK);
    }

    // get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> allPostDtos = this.postService.getAllPosts();
        return new ResponseEntity<List<PostDto>>(allPostDtos, HttpStatus.OK);
    }

    // get single post by id

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId){
        PostDto singlePostDto = this.postService.getPostById(postId);
        return  new ResponseEntity<PostDto>(singlePostDto, HttpStatus.OK);
    }

}