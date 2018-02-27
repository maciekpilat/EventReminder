/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Adress {

    @Id
    @GeneratedValue
    private long adressId;
    private long adressType;
    private String adressStreetNumber;
    private String adressStreetName;
    private String adressCity;
    private String adressAdministrativeArea;
    private String adressPostalCode;
    private String adressCountry;
    @ManyToOne
    private CourtDepartment courtDepartment;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Court court;

    public Adress(long adressType, String adressStreetNumber, String adressStreetName, String adressCity, String adressAdministrativeArea, String adressPostalCode, String adressCountry) {
        this.adressType = adressType;
        this.adressStreetNumber = adressStreetNumber;
        this.adressStreetName = adressStreetName;
        this.adressCity = adressCity;
        this.adressAdministrativeArea = adressAdministrativeArea;
        this.adressPostalCode = adressPostalCode;
        this.adressCountry = adressCountry;
    }

    public Adress() {
    }

    /**
     * @return the adressId
     */
    public long getAdressId() {
        return adressId;
    }

    /**
     * @param adressId the adressId to set
     */
    public void setAdressId(long adressId) {
        this.adressId = adressId;
    }

    /**
     * @return the adressCategory
     */
    public long getAdressType() {
        return adressType;
    }

    /**
     * @param adressCategory the adressCategory to set
     */
    public void setAdressType(long adressType) {
        this.adressType = adressType;
    }

    /**
     * @return the adressStreetNumber
     */
    public String getAdressStreetNumber() {
        return adressStreetNumber;
    }

    /**
     * @param adressStreetNumber the adressStreetNumber to set
     */
    public void setAdressStreetNumber(String adressStreetNumber) {
        this.adressStreetNumber = adressStreetNumber;
    }

    /**
     * @return the adressStreetName
     */
    public String getAdressStreetName() {
        return adressStreetName;
    }

    /**
     * @param adressStreetName the adressStreetName to set
     */
    public void setAdressStreetName(String adressStreetName) {
        this.adressStreetName = adressStreetName;
    }

    /**
     * @return the adressCity
     */
    public String getAdressCity() {
        return adressCity;
    }

    /**
     * @param adressCity the adressCity to set
     */
    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }

    /**
     * @return the adressAdministrativeArea
     */
    public String getAdressAdministrativeArea() {
        return adressAdministrativeArea;
    }

    /**
     * @param adressAdministrativeArea the adressAdministrativeArea to set
     */
    public void setAdressAdministrativeArea(String adressAdministrativeArea) {
        this.adressAdministrativeArea = adressAdministrativeArea;
    }

    /**
     * @return the adressPostalCode
     */
    public String getAdressPostalCode() {
        return adressPostalCode;
    }

    /**
     * @param adressPostalCode the adressPostalCode to set
     */
    public void setAdressPostalCode(String adressPostalCode) {
        this.adressPostalCode = adressPostalCode;
    }

    /**
     * @return the adressCountry
     */
    public String getAdressCountry() {
        return adressCountry;
    }

    /**
     * @param adressCountry the adressCountry to set
     */
    public void setAdressCountry(String adressCountry) {
        this.adressCountry = adressCountry;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the court
     */
    public Court getCourt() {
        return court;
    }

    /**
     * @param court the court to set
     */
    public void setCourt(Court court) {
        this.court = court;
    }

    /**
     * @return the courtDepartment
     */
    public CourtDepartment getCourtDepartment() {
        return courtDepartment;
    }

    /**
     * @param courtDepartment the courtDepartment to set
     */
    public void setCourtDepartment(CourtDepartment courtDepartment) {
        this.courtDepartment = courtDepartment;
    }
    
}
