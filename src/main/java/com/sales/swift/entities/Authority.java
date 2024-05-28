package com.sales.swift.security;


import com.sales.swift.entities.User;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 2774440902886870231L;
    private Long id;
    private String authority;
    private User user;


    @Override
    public String getAuthority() {
        return this.authority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
