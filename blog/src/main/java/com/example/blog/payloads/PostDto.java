package com.example.blog.payloads;

import com.example.blog.entities.Category;
import com.example.blog.entities.User;


import java.util.Date;

public class PostDto {

    private String postTitle;

    private String postContent;

    private String postImageName;

    private Date postAddDate;

    private Category postCategory;

    private User postUser;

}
