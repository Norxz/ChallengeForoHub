package com.desafio.foro.domain.user;

import com.desafio.foro.domain.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@Table (name = "user")
@Entity (name = "Usuario")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String name;
    
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private Set<com.desafio.foro.domain.Profile> profiles;
    
    
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
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        return List.of (new SimpleGrantedAuthority ("ROLE_USER"));
    }
    
    public String getPassword () {
        return password;
    }
    
    @Override
    public String getUsername () {
        return "";
    }
    
    @Override
    public boolean isAccountNonExpired () {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked () {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }
    
    @Override
    public boolean isEnabled () {
        return true;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
    
    public Set<Profile> getProfiles () {
        return profiles;
    }
    
    public void setProfiles (Set<Profile> profiles) {
        this.profiles = profiles;
    }
}

