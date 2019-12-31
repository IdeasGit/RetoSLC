package com.reto.slc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorMessage {

    private String exception;
    private String message;
    private String path;

    public ErrorMessage(Exception exception, String path){
        this(exception.getClass().getSimpleName(),exception.getMessage(), path);
    }

    @Override
    public String toString(){
        return "ErrorMessage [exception="+ exception +", message="+ message +", path="+ path +"]";
    }

}
