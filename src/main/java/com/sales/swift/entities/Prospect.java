package com.sales.swift.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
public class Prospect {

    private Long id;
    private String companyName;
    private String companyNumber;
    private String contactPerson;
    private String emailAddress;
    private Set<Customer> customer = new HashSet<>();
    private String industry;
    private String website;
    private Integer parcelVolume;
    private Double monthlySpend;
    private String currentSupplier;
    private Byte currentSupplierInvoice;
    private Date lastContactDate;
    private String lastContactType;
    private Boolean ratesPresented;
    private String notes;
    private Leads lead;
    private Boolean activeProspect; // If the prospect is not active -> they declined
    private User user;
    private Set<Comment> comments = new HashSet<>();


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

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * mappedBy = "" represents the field to use in customer when mapping back
     * Using manyToOne to account for the cost centres
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "prospect")
    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
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

    public Integer getParcelVolume() {
        return parcelVolume;
    }

    public void setParcelVolume(Integer parcelVolume) {
        this.parcelVolume = parcelVolume;
    }

    public Double getMonthlySpend() {
        return monthlySpend;
    }

    public void setMonthlySpend(Double monthlySpend) {
        this.monthlySpend = monthlySpend;
    }

    public String getCurrentSupplier() {
        return currentSupplier;
    }

    public void setCurrentSupplier(String currentSupplier) {
        this.currentSupplier = currentSupplier;
    }

    @Lob
    public Byte getCurrentSupplierInvoice() {
        return currentSupplierInvoice;
    }

    public void setCurrentSupplierInvoice(Byte currentSupplierInvoice) {
        this.currentSupplierInvoice = currentSupplierInvoice;
    }

    public Date getLastContactDate() {
        return lastContactDate;
    }

    public void setLastContactDate(Date lastContactDate) {
        this.lastContactDate = lastContactDate;
    }

    public String getLastContactType() {
        return lastContactType;
    }

    public void setLastContactType(String lastContactType) {
        this.lastContactType = lastContactType;
    }

    public Boolean getRatesPresented() {
        return ratesPresented;
    }

    public void setRatesPresented(Boolean ratesPresented) {
        this.ratesPresented = ratesPresented;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getActiveProspect() {
        return activeProspect;
    }

    public void setActiveProspect(Boolean activeProspect) {
        this.activeProspect = activeProspect;
    }

    @OneToOne
    public Leads getLead() {
        return lead;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prospect")
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setLead(Leads lead) {
        this.lead = lead;
    }

    @Override
    public String toString() {
        return "Prospect{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyNumber=" + companyNumber +
                ", contactPerson='" + contactPerson + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", customer=" + customer +
                ", industry='" + industry + '\'' +
                ", website='" + website + '\'' +
                ", parcelVolume=" + parcelVolume +
                ", monthlySpend=" + monthlySpend +
                ", currentSupplier='" + currentSupplier + '\'' +
                ", currentSupplierInvoice=" + currentSupplierInvoice +
                ", lastContactDate=" + lastContactDate +
                ", lastContactType='" + lastContactType + '\'' +
                ", ratesPresented=" + ratesPresented +
                ", notes='" + notes + '\'' +
                ", lead=" + lead +
                ", activeProspect=" + activeProspect +
                '}';
    }
}
