package com.example.blog.services;

import com.example.blog.entities.Post;
import com.example.blog.payloads.PostDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {

    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    Post updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all posts
    List<Post> getAllPosts();

    //get single post
    Post getPostById(Integer postId);

    //get all posts by category
    List<Post> getPostsByCategory(Integer categoryId);

    //get all posts by users
    List<Post> getPostsByUser(Integer userId);

    //search posts by keyword
    List<Post> searchPosts(String keyword);

}
