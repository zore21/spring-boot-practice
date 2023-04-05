package com.example.blog.payloads;

import com.example.blog.entities.Category;
import com.example.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String postTitle;

    private String postContent;

    private String postImageName;

    private Date postAddDate;

    private CategoryDto postCategory;

    private UserDto postUser;

}
