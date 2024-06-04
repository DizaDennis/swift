package com.sales.swift.entities;


import jakarta.persistence.*;

import java.util.Set;

/**
 * Supplier entity to capture courier partners details
 * TODO: Include signed credit app, rates and invoices
 * @author dennisdiza
 */

@Entity
public class Supplier {

    private Long id;
    private String supplierName;
    private String supplierAddress;
    private String repName;
    private String repNumber;
    private String repEmailAddress;
    private Set<SupplierCourierServices> supplierCourierServices; // Intermediary class to form the M:M relationship



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getRepNumber() {
        return repNumber;
    }

    public void setRepNumber(String repNumber) {
        this.repNumber = repNumber;
    }

    public String getRepEmailAddress() {
        return repEmailAddress;
    }

    public void setRepEmailAddress(String repEmailAddress) {
        this.repEmailAddress = repEmailAddress;
    }


    @OneToMany(mappedBy = "supplier")
    public Set<SupplierCourierServices> getSupplierCourierServices() {
        return supplierCourierServices;
    }

    public void setSupplierCourierServices(Set<SupplierCourierServices> supplierCourierServices) {
        this.supplierCourierServices = supplierCourierServices;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
