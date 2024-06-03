package com.sales.swift.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
public class User {

    private Long id;
    private String username;
    private String password;
    private String name;
    private Set <ToDoList> toDoList = new HashSet<>();
    private Set <Targets> targets;
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



    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    public Set<Authority> getAuthorities(){
        return authorities;
    }
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
    public Set<ToDoList> getToDoList() {
        return toDoList;
    }



    public void setToDoList(Set<ToDoList> toDoList) {
        this.toDoList = toDoList;
    }

    @ManyToMany
    public Set<Targets> getTargets() {
        return targets;
    }

    public void setTargets(Set<Targets> targets) {
        this.targets = targets;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
