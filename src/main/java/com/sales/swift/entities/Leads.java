package com.sales.swift.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Leads")
public class Leads {

    private Long id;
    private String companyName;
    private Integer companyNumber;
    private String industry;
    private String website;
    private String currentSupplier;
    private String notes;
    private Prospect prospect;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(Integer companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCurrentSupplier() {
        return currentSupplier;
    }

    public void setCurrentSupplier(String currentSupplier) {
        this.currentSupplier = currentSupplier;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToOne
    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }
}

