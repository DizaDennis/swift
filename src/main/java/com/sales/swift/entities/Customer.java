package com.sales.swift.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/***
 * Customer entity class created to capture all customer info
 * Company docs can be saved to keep all account related items in one place
 * Customer entity will allow user to capture and view detailed info on the customer
 * @author dennisdiza
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
public class Customer {

    private Long id;
    private String companyName;
    private String companyNumber;
    private String address;
    private String accountsPerson;
    private String decisionMaker;
    private byte[] companyRegistrationDocs;
    private byte[] sarsDocs;
    private byte[] creditApp;
    private byte[] rateCard;
    private String users; // customer users
    private Double openInvoiceValue;
    private String openInvoices;
    private Double currentInvoiceValue;
    private Double currentMonthShipments;
    private Byte invoices; // for invoices that have been approved and sent to the customer
    private Byte statement; // for statements that have been approved and sent to the customer
    private Double totalBilling;
    private String previousCourier;
    private Prospect prospect;
    private String notes;
    private Boolean trading;
    private Set<Comment> comments = new HashSet<>();
    private User user;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(String decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public byte[] getCompanyRegistrationDocs() {
        return companyRegistrationDocs;
    }

    public void setCompanyRegistrationDocs(byte[] companyRegistrationDocs) {
        this.companyRegistrationDocs = companyRegistrationDocs;
    }

    public byte[] getSarsDocs() {
        return sarsDocs;
    }

    public void setSarsDocs(byte[] sarsDocs) {
        this.sarsDocs = sarsDocs;
    }

    public byte[] getCreditApp() {
        return creditApp;
    }

    public void setCreditApp(byte[] creditApp) {
        this.creditApp = creditApp;
    }

    public byte[] getRateCard() {
        return rateCard;
    }

    public void setRateCard(byte[] rateCard) {
        this.rateCard = rateCard;
    }

    public Double getCurrentMonthShipments() {
        return currentMonthShipments;
    }

    public void setCurrentMonthShipments(Double currentMonthShipments) {
        this.currentMonthShipments = currentMonthShipments;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Double getOpenInvoiceValue() {
        return openInvoiceValue;
    }

    public void setOpenInvoiceValue(Double openInvoiceValue) {
        this.openInvoiceValue = openInvoiceValue;
    }

    public String getOpenInvoices() {
        return openInvoices;
    }

    public void setOpenInvoices(String openInvoices) {
        this.openInvoices = openInvoices;
    }

    public Double getCurrentInvoiceValue() {
        return currentInvoiceValue;
    }

    public void setCurrentInvoiceValue(Double currentInvoiceValue) {
        this.currentInvoiceValue = currentInvoiceValue;
    }

    @Lob
    public Byte getInvoices() {
        return invoices;
    }

    public void setInvoices(Byte invoices) {
        this.invoices = invoices;
    }
    @Lob
    public Byte getStatement() {
        return statement;
    }

    public void setStatement(Byte statement) {
        this.statement = statement;
    }

    public Double getTotalBilling() {
        return totalBilling;
    }

    public void setTotalBilling(Double totalBilling) {
        this.totalBilling = totalBilling;
    }

    @ManyToOne
    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    public String getPreviousCourier() {
        return previousCourier;
    }

    public void setPreviousCourier(String previousCourier) {
        this.previousCourier = previousCourier;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getTrading() {
        return trading;
    }

    public void setTrading(Boolean trading) {
        this.trading = trading;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="customer")
    public Set<Comment> getComment() {
        return comments;
    }

    public void setComment(Set<Comment> comments) {
        this.comments = comments;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountsPerson() {
        return accountsPerson;
    }

    public void setAccountsPerson(String accountsPerson) {
        this.accountsPerson = accountsPerson;
    }
}
