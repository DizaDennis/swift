package com.sales.swift.entities;

import jakarta.persistence.*;

/**
 *Intermediary class for Supplier / Courier Services
 */


@Entity
public class SupplierCourierServices {
    private Long id;
    private Supplier supplier;
    private CourierServices courierServices;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    @ManyToOne
    @JoinColumn(name="courier_services_id")
    public CourierServices getCourierServices() {
        return courierServices;
    }

    public void setCourierServices(CourierServices courierServices) {
        this.courierServices = courierServices;
    }
}
