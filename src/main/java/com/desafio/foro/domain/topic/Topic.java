package com.desafio.foro.domain.topic;


import com.desafio.foro.domain.Course;
import com.desafio.foro.domain.Reply;
import com.desafio.foro.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Topic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String message;
    
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    
    private  String status;
    
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reply> replies;
    
    public Topic () {
    }
    
    public Topic (String title, String message, LocalDateTime creationDate, String status, User author, Course course) {
        this.title = title;
        this.message = message;
        this.creationDate = creationDate;
        this.status = status;
        this.author = author;
        this.course = course;
    }
    
    public Long getId () {
        return id;
    }
    
    public void setId (Long id) {
        this.id = id;
    }
    
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
    
    public LocalDateTime getCreationDate () {
        return creationDate;
    }
    
    public void setCreationDate (LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    
    public String getStatus () {
        return status;
    }
    
    public void setStatus (String status) {
        this.status = status;
    }
    
    public User getAuthor () {
        return author;
    }
    
    public void setAuthor (User author) {
        this.author = author;
    }
    
    public Course getCourse () {
        return course;
    }
    
    public void setCourse (Course course) {
        this.course = course;
    }
    
    public List<Reply> getReplies () {
        return replies;
    }
    
    public void setReplies (List<Reply> replies) {
        this.replies = replies;
    }
}
