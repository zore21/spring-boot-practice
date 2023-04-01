package com.example.blog.excepttions;

public class BadRequestException extends Exception{

    private Object fieldValue;

    public BadRequestException(

            Object fieldValue){

        super(String.format("%s is not valid: ",
                 fieldValue));


        this.fieldValue = fieldValue;

    }

}
