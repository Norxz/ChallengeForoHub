package com.desafio.foro.Exception;

public class TopicNotFoundException extends RuntimeException{
    
    public TopicNotFoundException(String message) {
        super(message);
    }

}
