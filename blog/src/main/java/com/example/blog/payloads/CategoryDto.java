package com.example.blog.payloads;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min = 4, message = "title should be atleast of 4 characters")
    private String categoryTitle;

    @NotBlank
    @Size(min = 5, message = "description should be atleast of 4 characters")
    private String categoryDescription;

}
