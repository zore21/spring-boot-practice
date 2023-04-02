package com.example.blog.repositories;

import com.example.blog.entities.Category;
import com.example.blog.entities.Post;
import com.example.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

}
