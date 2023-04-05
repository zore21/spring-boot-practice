package com.example.blog.services.impl;

import com.example.blog.entities.Category;
import com.example.blog.entities.Post;
import com.example.blog.entities.User;
import com.example.blog.excepttions.ResourceNotfoundException;
import com.example.blog.payloads.PostDto;
import com.example.blog.repositories.CategoryRepository;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UserRepository;
import com.example.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDto createPost(PostDto postDto,
                           Integer userId,
                           Integer categoryId) {

        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotfoundException("User", "user id", userId)
                        );

        Category category = this.categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotfoundException("category", "category id", categoryId)
                        );

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setPostImageName("default.png");
        post.setPostAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepository.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = this.postRepository.findAll();
        List<PostDto> postDtos = allPosts.stream()
                .map(
                        (post) -> this.modelMapper.map(post, PostDto.class)
                )
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotfoundException("post", "post id", postId)
        );
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new ResourceNotfoundException("category", "category id", categoryId)
                        );
        List<Post> posts = this.postRepository.findByCategory(category);
        List<PostDto> postDtos = posts.stream().map(
                post -> this.modelMapper.map(posts, PostDto.class)
        ).collect(Collectors.toList());


        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotfoundException("user", "user id", userId)
                );
        List<Post> posts = this.postRepository.findByUser(user);
        List<PostDto> postDtos = posts.stream().map(
                post -> this.modelMapper.map(posts, PostDto.class)
        ).collect(Collectors.toList());

        return postDtos;
                                                }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}
