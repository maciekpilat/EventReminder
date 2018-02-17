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
public class CourtDepartmentName {
    @Id
    @GeneratedValue
    private long courtDepartmentNameId;
    private String courtDepartmentName1;
    private String courtDepartmentName2;
    private String courtDepartmentName3;
    private String courtDepartmentName4;
    private String courtDepartmentName5;
    private String courtDepartmentName6;
    private String courtDepartmentName7;
    private String courtDepartmentName8;

    @Override
    public String toString() {
        return "CourtDepartmentName{" + "courtDepartmentNameId=" + courtDepartmentNameId + ", courtDepartmentName1=" + courtDepartmentName1 + ", courtDepartmentName2=" + courtDepartmentName2 + ", courtDepartmentName3=" + courtDepartmentName3 + ", courtDepartmentName4=" + courtDepartmentName4 + ", courtDepartmentName5=" + courtDepartmentName5 + ", courtDepartmentName6=" + courtDepartmentName6 + ", courtDepartmentName7=" + courtDepartmentName7 + ", courtDepartmentName8=" + courtDepartmentName8 + '}';
    }

    public CourtDepartmentName(String courtDepartmentName1, String courtDepartmentName2, String courtDepartmentName3, String courtDepartmentName4, String courtDepartmentName5, String courtDepartmentName6, String courtDepartmentName7, String courtDepartmentName8) {
        this.courtDepartmentName1 = courtDepartmentName1;
        this.courtDepartmentName2 = courtDepartmentName2;
        this.courtDepartmentName3 = courtDepartmentName3;
        this.courtDepartmentName4 = courtDepartmentName4;
        this.courtDepartmentName5 = courtDepartmentName5;
        this.courtDepartmentName6 = courtDepartmentName6;
        this.courtDepartmentName7 = courtDepartmentName7;
        this.courtDepartmentName8 = courtDepartmentName8;
    }

    public CourtDepartmentName(){
        
    }
    
    /**
     * @return the courtDepartmentNameId
     */
    public long getCourtDepartmentNameId() {
        return courtDepartmentNameId;
    }

    /**
     * @param courtDepartmentNameId the courtDepartmentNameId to set
     */
    public void setCourtDepartmentNameId(long courtDepartmentNameId) {
        this.courtDepartmentNameId = courtDepartmentNameId;
    }

    /**
     * @return the courtDepartmentName1
     */
    public String getCourtDepartmentName1() {
        return courtDepartmentName1;
    }

    /**
     * @param courtDepartmentName1 the courtDepartmentName1 to set
     */
    public void setCourtDepartmentName1(String courtDepartmentName1) {
        this.courtDepartmentName1 = courtDepartmentName1;
    }

    /**
     * @return the courtDepartmentName2
     */
    public String getCourtDepartmentName2() {
        return courtDepartmentName2;
    }

    /**
     * @param courtDepartmentName2 the courtDepartmentName2 to set
     */
    public void setCourtDepartmentName2(String courtDepartmentName2) {
        this.courtDepartmentName2 = courtDepartmentName2;
    }

    /**
     * @return the courtDepartmentName3
     */
    public String getCourtDepartmentName3() {
        return courtDepartmentName3;
    }

    /**
     * @param courtDepartmentName3 the courtDepartmentName3 to set
     */
    public void setCourtDepartmentName3(String courtDepartmentName3) {
        this.courtDepartmentName3 = courtDepartmentName3;
    }

    /**
     * @return the courtDepartmentName4
     */
    public String getCourtDepartmentName4() {
        return courtDepartmentName4;
    }

    /**
     * @param courtDepartmentName4 the courtDepartmentName4 to set
     */
    public void setCourtDepartmentName4(String courtDepartmentName4) {
        this.courtDepartmentName4 = courtDepartmentName4;
    }

    /**
     * @return the courtDepartmentName5
     */
    public String getCourtDepartmentName5() {
        return courtDepartmentName5;
    }

    /**
     * @param courtDepartmentName5 the courtDepartmentName5 to set
     */
    public void setCourtDepartmentName5(String courtDepartmentName5) {
        this.courtDepartmentName5 = courtDepartmentName5;
    }

    /**
     * @return the courtDepartmentName6
     */
    public String getCourtDepartmentName6() {
        return courtDepartmentName6;
    }

    /**
     * @param courtDepartmentName6 the courtDepartmentName6 to set
     */
    public void setCourtDepartmentName6(String courtDepartmentName6) {
        this.courtDepartmentName6 = courtDepartmentName6;
    }

    /**
     * @return the courtDepartmentName7
     */
    public String getCourtDepartmentName7() {
        return courtDepartmentName7;
    }

    /**
     * @param courtDepartmentName7 the courtDepartmentName7 to set
     */
    public void setCourtDepartmentName7(String courtDepartmentName7) {
        this.courtDepartmentName7 = courtDepartmentName7;
    }

    /**
     * @return the courtDepartmentName8
     */
    public String getCourtDepartmentName8() {
        return courtDepartmentName8;
    }

    /**
     * @param courtDepartmentName8 the courtDepartmentName8 to set
     */
    public void setCourtDepartmentName8(String courtDepartmentName8) {
        this.courtDepartmentName8 = courtDepartmentName8;
    }

    
 
}
