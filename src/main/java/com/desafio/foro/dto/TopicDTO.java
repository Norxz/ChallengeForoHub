package com.desafio.foro.dto;

import jakarta.validation.constraints.NotNull;

public class TopicDTO {
    
    @NotNull (message = "El título no puede ser nulo")
    private String title;
    
    @NotNull(message = "El mensaje no puede ser nulo")
    private String message;
    
    @NotNull(message = "El estado no puede ser nulo")
    private String status;
    
    @NotNull(message = "El ID del autor no puede ser nulo")
    private Long authorId;
    
    @NotNull(message = "El ID del curso no puede ser nulo")
    private Long courseId;
    
    public String getTitle () {
        return title;
    }
    
    public void setTitle (String title) {
        this.title = title;
    }
    
    public String getMessage () {
        return message;
    }
    
    public void setMessage (String message) {
        this.message = message;
    }
    
    public String getStatus () {
        return status;
    }
    
    public void setStatus (String status) {
        this.status = status;
    }
    
    public Long getAuthorId () {
        return authorId;
    }
    
    public void setAuthorId (Long authorId) {
        this.authorId = authorId;
    }
    
    public Long getCourseId () {
        return courseId;
    }
    
    public void setCourseId (Long courseId) {
        this.courseId = courseId;
    }
}
