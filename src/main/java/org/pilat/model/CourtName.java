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
public class CourtName {

    @Id
    @GeneratedValue
    private long courtNameId;
    private String courtName1;
    private String courtName2;
    private String courtName3;

    CourtName(String courtName1, String courtName2, String courtName3) {
        this.courtName1 = courtName1;
        this.courtName2 = courtName2;
        this.courtName3 = courtName3;
    }

    public CourtName(){
        
    }

    @Override
    public String toString() {
        return "CourtName{" + "courtNameId=" + courtNameId + ", courtName1=" + courtName1 + ", courtName2=" + courtName2 + ", courtName3=" + courtName3 + '}';
    }
    
    
    /**
     * @return the courtNameId
     */
    public long getCourtNameId() {
        return courtNameId;
    }

    /**
     * @param courtNameId the courtNameId to set
     */
    public void setCourtNameId(long courtNameId) {
        this.courtNameId = courtNameId;
    }

    /**
     * @return the courtName1
     */
    public String getCourtName1() {
        return courtName1;
    }

    /**
     * @param courtName1 the courtName1 to set
     */
    public void setCourtName1(String courtName1) {
        this.courtName1 = courtName1;
    }

    /**
     * @return the courtName2
     */
    public String getCourtName2() {
        return courtName2;
    }

    /**
     * @param courtName2 the courtName2 to set
     */
    public void setCourtName2(String courtName2) {
        this.courtName2 = courtName2;
    }

    /**
     * @return the courtName3
     */
    public String getCourtName3() {
        return courtName3;
    }

    /**
     * @param courtName3 the courtName3 to set
     */
    public void setCourtName3(String courtName3) {
        this.courtName3 = courtName3;
    }
    
    

}
