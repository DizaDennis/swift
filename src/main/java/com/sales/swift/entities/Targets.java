package com.sales.swift.entities;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Target entity created to keep track of performance
 * Values are pulled and displayed on the dashboard
 * @author dennisdiza
 */


@Entity
public class Targets {

    private Long id;
    private Integer newCustomers;
    private Integer targetShipments;
    private Double targetRevenue;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNewCustomers() {
        return newCustomers;
    }

    public void setNewCustomers(Integer newCustomers) {
        this.newCustomers = newCustomers;
    }

    public Integer getTargetShipments() {
        return targetShipments;
    }

    public void setTargetShipments(Integer targetShipments) {
        this.targetShipments = targetShipments;
    }

    public Double getTargetRevenue() {
        return targetRevenue;
    }

    public void setTargetRevenue(Double targetRevenue) {
        this.targetRevenue = targetRevenue;
    }

    @ManyToMany(mappedBy = "targets")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
