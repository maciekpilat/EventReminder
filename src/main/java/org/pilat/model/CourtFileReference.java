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
public class CourtFileReference {
@Id
@GeneratedValue
private long courtFileReferenceId;
private String courtFileReference1;
private String courtFileReference2;
private String courtFileReference3;
private String courtFileReference4;
private String courtFileReference5;
private String courtFileReference6;
private String courtFileReference7;
private String courtFileReference8;
private String courtFileReference9;
private String courtFileReference10;
private String courtFileReference11;
private String courtFileReference12;

    @Override
    public String toString() {
        return "CourtFileReference{" + "courtFileReferenceId=" + courtFileReferenceId + ", courtFileReference1=" + courtFileReference1 + ", courtFileReference2=" + courtFileReference2 + ", courtFileReference3=" + courtFileReference3 + ", courtFileReference4=" + courtFileReference4 + ", courtFileReference5=" + courtFileReference5 + ", courtFileReference6=" + courtFileReference6 + ", courtFileReference7=" + courtFileReference7 + ", courtFileReference8=" + courtFileReference8 + ", courtFileReference9=" + courtFileReference9 + ", courtFileReference10=" + courtFileReference10 + ", courtFileReference11=" + courtFileReference11 + ", courtFileReference12=" + courtFileReference12 + '}';
    }

    public CourtFileReference() {
    }

    
    public CourtFileReference(String courtFileReference1, String courtFileReference2, String courtFileReference3, String courtFileReference4, String courtFileReference5, String courtFileReference6, String courtFileReference7, String courtFileReference8, String courtFileReference9, String courtFileReference10, String courtFileReference11, String courtFileReference12) {
        this.courtFileReference1 = courtFileReference1;
        this.courtFileReference2 = courtFileReference2;
        this.courtFileReference3 = courtFileReference3;
        this.courtFileReference4 = courtFileReference4;
        this.courtFileReference5 = courtFileReference5;
        this.courtFileReference6 = courtFileReference6;
        this.courtFileReference7 = courtFileReference7;
        this.courtFileReference8 = courtFileReference8;
        this.courtFileReference9 = courtFileReference9;
        this.courtFileReference10 = courtFileReference10;
        this.courtFileReference11 = courtFileReference11;
        this.courtFileReference12 = courtFileReference12;
    }


    /**
     * @return the courtFileReferenceId
     */
    public long getCourtFileReferenceId() {
        return courtFileReferenceId;
    }

    /**
     * @param courtFileReferenceId the courtFileReferenceId to set
     */
    public void setCourtFileReferenceId(long courtFileReferenceId) {
        this.courtFileReferenceId = courtFileReferenceId;
    }

    /**
     * @return the courtFileReference1
     */
    public String getCourtFileReference1() {
        return courtFileReference1;
    }

    /**
     * @param courtFileReference1 the courtFileReference1 to set
     */
    public void setCourtFileReference1(String courtFileReference1) {
        this.courtFileReference1 = courtFileReference1;
    }

    /**
     * @return the courtFileReference2
     */
    public String getCourtFileReference2() {
        return courtFileReference2;
    }

    /**
     * @param courtFileReference2 the courtFileReference2 to set
     */
    public void setCourtFileReference2(String courtFileReference2) {
        this.courtFileReference2 = courtFileReference2;
    }

    /**
     * @return the courtFileReference3
     */
    public String getCourtFileReference3() {
        return courtFileReference3;
    }

    /**
     * @param courtFileReference3 the courtFileReference3 to set
     */
    public void setCourtFileReference3(String courtFileReference3) {
        this.courtFileReference3 = courtFileReference3;
    }

    /**
     * @return the courtFileReference4
     */
    public String getCourtFileReference4() {
        return courtFileReference4;
    }

    /**
     * @param courtFileReference4 the courtFileReference4 to set
     */
    public void setCourtFileReference4(String courtFileReference4) {
        this.courtFileReference4 = courtFileReference4;
    }

    /**
     * @return the courtFileReference5
     */
    public String getCourtFileReference5() {
        return courtFileReference5;
    }

    /**
     * @param courtFileReference5 the courtFileReference5 to set
     */
    public void setCourtFileReference5(String courtFileReference5) {
        this.courtFileReference5 = courtFileReference5;
    }

    /**
     * @return the courtFileReference6
     */
    public String getCourtFileReference6() {
        return courtFileReference6;
    }

    /**
     * @param courtFileReference6 the courtFileReference6 to set
     */
    public void setCourtFileReference6(String courtFileReference6) {
        this.courtFileReference6 = courtFileReference6;
    }

    /**
     * @return the courtFileReference7
     */
    public String getCourtFileReference7() {
        return courtFileReference7;
    }

    /**
     * @param courtFileReference7 the courtFileReference7 to set
     */
    public void setCourtFileReference7(String courtFileReference7) {
        this.courtFileReference7 = courtFileReference7;
    }

    /**
     * @return the courtFileReference8
     */
    public String getCourtFileReference8() {
        return courtFileReference8;
    }

    /**
     * @param courtFileReference8 the courtFileReference8 to set
     */
    public void setCourtFileReference8(String courtFileReference8) {
        this.courtFileReference8 = courtFileReference8;
    }

    /**
     * @return the courtFileReference9
     */
    public String getCourtFileReference9() {
        return courtFileReference9;
    }

    /**
     * @param courtFileReference9 the courtFileReference9 to set
     */
    public void setCourtFileReference9(String courtFileReference9) {
        this.courtFileReference9 = courtFileReference9;
    }

    /**
     * @return the courtFileReference10
     */
    public String getCourtFileReference10() {
        return courtFileReference10;
    }

    /**
     * @param courtFileReference10 the courtFileReference10 to set
     */
    public void setCourtFileReference10(String courtFileReference10) {
        this.courtFileReference10 = courtFileReference10;
    }

    /**
     * @return the courtFileReference11
     */
    public String getCourtFileReference11() {
        return courtFileReference11;
    }

    /**
     * @param courtFileReference11 the courtFileReference11 to set
     */
    public void setCourtFileReference11(String courtFileReference11) {
        this.courtFileReference11 = courtFileReference11;
    }

    /**
     * @return the courtFileReference12
     */
    public String getCourtFileReference12() {
        return courtFileReference12;
    }

    /**
     * @param courtFileReference12 the courtFileReference12 to set
     */
    public void setCourtFileReference12(String courtFileReference12) {
        this.courtFileReference12 = courtFileReference12;
    }



    
}
