package com.example.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title", length = 100, nullable = false)
    private String postTitle;

    @Column(length = 1000, nullable = false)
    private String postContent;

    @Column(length = 1000, nullable = false)
    private String postImageName;

    private Date postAddDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User user;





}
