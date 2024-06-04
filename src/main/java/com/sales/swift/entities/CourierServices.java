package com.sales.swift.entities;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Courier services class keeps track of the services provided to / by SWIFT
 * Keeping record of both the volume and value of the services
 *
 * @author dennisdiza
 */

@Entity
public class CourierServices {

    private Long id;
    private String document;
    private Integer documentVolume;
    private Double documentValue;
    private String tender;
    private Integer tenderVolume;
    private Double tenderValue;
    private String overnight;
    private Integer overnightVolume;
    private Double overnightValue;
    private String economy;
    private Integer economyVolume;
    private Double economyValue;
    private String road;
    private Integer roadVolume;
    private Double roadValue;
    private String sameDay;
    private Integer sameDayVolume;
    private Double sameDayValue;
    private String internationalDoc;
    private Integer internationalDocVolume;
    private Double internationalDocValue;
    private String internationalParcel;
    private Integer internationalParcelVolume;
    private Double internationalParcelValue;
    private Set<SupplierCourierServices> supplierCourierServices;




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTender() {
        return tender;
    }

    public void setTender(String tender) {
        this.tender = tender;
    }

    public String getOvernight() {
        return overnight;
    }

    public void setOvernight(String overnight) {
        this.overnight = overnight;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(String economy) {
        this.economy = economy;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getSameDay() {
        return sameDay;
    }

    public void setSameDay(String sameDay) {
        this.sameDay = sameDay;
    }

    public String getInternationalDoc() {
        return internationalDoc;
    }

    public void setInternationalDoc(String internationalDoc) {
        this.internationalDoc = internationalDoc;
    }

    public String getInternationalParcel() {
        return internationalParcel;
    }

    public void setInternationalParcel(String internationalParcel) {
        this.internationalParcel = internationalParcel;
    }

    @OneToMany(mappedBy = "courierServices")
    public Set<SupplierCourierServices> getSupplierCourierServices() {
        return supplierCourierServices;
    }

    public Integer getDocumentVolume() {
        return documentVolume;
    }

    public void setDocumentVolume(Integer documentVolume) {
        this.documentVolume = documentVolume;
    }

    public Double getDocumentValue() {
        return documentValue;
    }

    public void setDocumentValue(Double documentValue) {
        this.documentValue = documentValue;
    }

    public Integer getTenderVolume() {
        return tenderVolume;
    }

    public void setTenderVolume(Integer tenderVolume) {
        this.tenderVolume = tenderVolume;
    }

    public Double getTenderValue() {
        return tenderValue;
    }

    public void setTenderValue(Double tenderValue) {
        this.tenderValue = tenderValue;
    }

    public Integer getOvernightVolume() {
        return overnightVolume;
    }

    public void setOvernightVolume(Integer overnightVolume) {
        this.overnightVolume = overnightVolume;
    }

    public Double getOvernightValue() {
        return overnightValue;
    }

    public void setOvernightValue(Double overnightValue) {
        this.overnightValue = overnightValue;
    }

    public Integer getEconomyVolume() {
        return economyVolume;
    }

    public void setEconomyVolume(Integer economyVolume) {
        this.economyVolume = economyVolume;
    }

    public Double getEconomyValue() {
        return economyValue;
    }

    public void setEconomyValue(Double economyValue) {
        this.economyValue = economyValue;
    }

    public Integer getRoadVolume() {
        return roadVolume;
    }

    public void setRoadVolume(Integer roadVolume) {
        this.roadVolume = roadVolume;
    }

    public Double getRoadValue() {
        return roadValue;
    }

    public void setRoadValue(Double roadValue) {
        this.roadValue = roadValue;
    }

    public Integer getSameDayVolume() {
        return sameDayVolume;
    }

    public void setSameDayVolume(Integer sameDayVolume) {
        this.sameDayVolume = sameDayVolume;
    }

    public Double getSameDayValue() {
        return sameDayValue;
    }

    public void setSameDayValue(Double sameDayValue) {
        this.sameDayValue = sameDayValue;
    }

    public Integer getInternationalDocVolume() {
        return internationalDocVolume;
    }

    public void setInternationalDocVolume(Integer internationalDocVolume) {
        this.internationalDocVolume = internationalDocVolume;
    }

    public Double getInternationalDocValue() {
        return internationalDocValue;
    }

    public void setInternationalDocValue(Double internationalDocValue) {
        this.internationalDocValue = internationalDocValue;
    }

    public Integer getInternationalParcelVolume() {
        return internationalParcelVolume;
    }

    public void setInternationalParcelVolume(Integer internationalParcelVolume) {
        this.internationalParcelVolume = internationalParcelVolume;
    }

    public Double getInternationalParcelValue() {
        return internationalParcelValue;
    }

    public void setInternationalParcelValue(Double internationalParcelValue) {
        this.internationalParcelValue = internationalParcelValue;
    }

    public void setSupplierCourierServices(Set<SupplierCourierServices> supplierCourierServices) {
        this.supplierCourierServices = supplierCourierServices;
    }

}
