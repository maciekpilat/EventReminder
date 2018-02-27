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
public class PartyType {

    @Id
    @GeneratedValue
    private long partyTypeId;
    private String partyTypeName;

    /**
     * @return the partyTypeId
     */
    public long getPartyTypeId() {
        return partyTypeId;
    }

    /**
     * @param partyTypeId the partyTypeId to set
     */
    public void setPartyTypeId(long partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    /**
     * @return the partyTypeName
     */
    public String getPartyTypeName() {
        return partyTypeName;
    }

    /**
     * @param partyTypeName the partyTypeName to set
     */
    public void setPartyTypeName(String partyTypeName) {
        this.partyTypeName = partyTypeName;
    }

}
