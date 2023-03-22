package com.example.blog.excepttions;

public class ResourceNotfoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Integer fieldValue;

    public ResourceNotfoundException(
            String resourceName,
            String fieldName,
            Integer fieldValue){

        super(String.format("%s not found with %s : %d",
                resourceName, fieldName, fieldValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

}
