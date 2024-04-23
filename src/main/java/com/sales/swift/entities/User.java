package com.sales.swift.entities;

import com.sales.swift.security.Authority;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    private Long id;
    private String username;
    private String password;
    private String name;
    /*
    Including the following here to avoid having to inherit from UserRepo
    Reminder: Using a HashSet -> Doesn't guarantee ordering. Set interface, Serializable & Cloneable are implemented
    Comes from Spring Security
     */
    private Set<Authority> authorities = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,mappedBy = "user")
    public Set<Authority> getAuthorities(){
        return authorities;
    }
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}