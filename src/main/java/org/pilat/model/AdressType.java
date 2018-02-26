/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class AdressType {

    /**
     * @return the adressTypeId
     */
    public long getAdressTypeId() {
        return adressTypeId;
    }

    /**
     * @param adressTypeId the adressTypeId to set
     */
    public void setAdressTypeId(long adressTypeId) {
        this.adressTypeId = adressTypeId;
    }

    /**
     * @return the adressTypeName
     */
    public String getAdressTypeName() {
        return adressTypeName;
    }

    /**
     * @param adressTypeName the adressTypeName to set
     */
    public void setAdressTypeName(String adressTypeName) {
        this.adressTypeName = adressTypeName;
    }
    @Id
    @GeneratedValue
    private long adressTypeId;
    private String adressTypeName;

    @Override
    public String toString() {
        return "AdressType{" + "adressTypeId=" + getAdressTypeId() + ", adressTypeName=" + getAdressTypeName() + '}';
    }
    
    
       
}
