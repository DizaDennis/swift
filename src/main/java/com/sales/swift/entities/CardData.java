package com.sales.swift.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CardData {

    private Long id;
    private Integer totalShipments;
    private Integer totalRevenue;
    private Integer numberOfCustomers;
    private Integer numberOfProspects;
    private Integer numberOfLeads;
    private Integer totalCount;
    private Integer previousMonthTotalCount;
    private Double percentageChange;

    private Integer numberOfProjects;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalShipments() {
        return totalShipments;
    }

    public void setTotalShipments(Integer totalShipments) {
        this.totalShipments = totalShipments;
    }

    public Integer getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Integer totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Integer getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(Integer numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public Integer getNumberOfProspects() {
        return numberOfProspects;
    }

    public void setNumberOfProspects(Integer numberOfProspects) {
        this.numberOfProspects = numberOfProspects;
    }

    public Integer getNumberOfLeads() {
        return numberOfLeads;
    }

    public void setNumberOfLeads(Integer numberOfLeads) {
        this.numberOfLeads = numberOfLeads;
    }

    public Integer getNumberOfProjects() {
        return numberOfProjects;
    }

    public void setNumberOfProjects(Integer numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPreviousMonthTotalCount() {
        return previousMonthTotalCount;
    }

    public void setPreviousMonthTotalCount(Integer previousMonthTotalCount) {
        this.previousMonthTotalCount = previousMonthTotalCount;
    }

    public Double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(Double percentageChange) {
        this.percentageChange = percentageChange;
    }
}
