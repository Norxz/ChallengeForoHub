package com.desafio.foro.domain;

import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;

import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private Set<Profile> profile;
    
    
    public User () {
    }
    
    public User (Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public Long getId () {
        return id;
    }
    
    public void setId (Long id) {
        this.id = id;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getPassword () {
        return password;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
    
    public Set<Profile> getProfile () {
        return profile;
    }
    
    public void setProfile (Set<Profile> profile) {
        this.profile = profile;
    }
}

