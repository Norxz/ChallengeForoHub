package com.desafio.foro.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String message;
    
    @Column(name = "cration_date")
    private LocalDateTime crationDate;
    
    private Boolean solution;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    
    public Reply () {
    }
    
    public Reply (Long id, String message, LocalDateTime crationDate, Boolean solution, User author, Topic topic) {
        this.id = id;
        this.message = message;
        this.crationDate = crationDate;
        this.solution = solution;
        this.author = author;
        this.topic = topic;
    }
    
    public Long getId () {
        return id;
    }
    
    public void setId (Long id) {
        this.id = id;
    }
    
    public String getMessage () {
        return message;
    }
    
    public void setMessage (String message) {
        this.message = message;
    }
    
    public LocalDateTime getCrationDate () {
        return crationDate;
    }
    
    public void setCrationDate (LocalDateTime crationDate) {
        this.crationDate = crationDate;
    }
    
    public Boolean getSolution () {
        return solution;
    }
    
    public void setSolution (Boolean solution) {
        this.solution = solution;
    }
    
    public User getAuthor () {
        return author;
    }
    
    public void setAuthor (User author) {
        this.author = author;
    }
    
    public Topic getTopic () {
        return topic;
    }
    
    public void setTopic (Topic topic) {
        this.topic = topic;
    }
}
