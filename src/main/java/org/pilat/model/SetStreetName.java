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
public class SetStreetName {

    @Id
    @GeneratedValue
    private long streetId;
    private String streetName;

    public SetStreetName(long streetId, String streetName) {
        this.streetId = streetId;
        this.streetName = streetName;
    }

    public SetStreetName() {

    }

    @Override
    public String toString() {
        return "SetStreetName{" + "streetId=" + streetId + ", streetName=" + streetName + '}';
    }

    /**
     * @return the streetId
     */
    public long getStreetId() {
        return streetId;
    }

    /**
     * @param streetId the streetId to set
     */
    public void setStreetId(long streetId) {
        this.streetId = streetId;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

}
