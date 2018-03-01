/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.pilat.model.CourtDepartment;

/**
 *
 * @author Pilat
 */
// pakiet z danymi kontaktowymi to się łączy pod sądy, klientów itp.
@Entity
@Table
public class ContactData {
    @Id
    @GeneratedValue
private long contactDataId;
private String telephone1;
private String telephone2;
private String telephone3;
private String mail1;
private String mail2;
private String mail3;
private String else1;
private String else2;
private String else3;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "courtDepartmentId")
private CourtDepartment courtDepartment;


    @Override
    public String toString() {
        return "ContatctData{" + "contactDataId=" + contactDataId + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + ", telephone3=" + telephone3 + ", mail1=" + mail1 + ", mail2=" + mail2 + ", mail3=" + mail3 + ", else1=" + else1 + ", else2=" + else2 + ", else3=" + else3 + '}';
    }

    public ContactData(String telephone1, String telephone2, String telephone3, String mail1, String mail2, String mail3, String else1, String else2, String else3) {
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.telephone3 = telephone3;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.mail3 = mail3;
        this.else1 = else1;
        this.else2 = else2;
        this.else3 = else3;
    }

    public ContactData() {
    }

    /**
     * @return the contactDataId
     */
    public long getContactDataId() {
        return contactDataId;
    }

    /**
     * @param contactDataId the contactDataId to set
     */
    public void setContactDataId(long contactDataId) {
        this.contactDataId = contactDataId;
    }

    /**
     * @return the telephone1
     */
    public String getTelephone1() {
        return telephone1;
    }

    /**
     * @param telephone1 the telephone1 to set
     */
    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    /**
     * @return the telephone2
     */
    public String getTelephone2() {
        return telephone2;
    }

    /**
     * @param telephone2 the telephone2 to set
     */
    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    /**
     * @return the telephone3
     */
    public String getTelephone3() {
        return telephone3;
    }

    /**
     * @param telephone3 the telephone3 to set
     */
    public void setTelephone3(String telephone3) {
        this.telephone3 = telephone3;
    }

    /**
     * @return the mail1
     */
    public String getMail1() {
        return mail1;
    }

    /**
     * @param mail1 the mail1 to set
     */
    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    /**
     * @return the mail2
     */
    public String getMail2() {
        return mail2;
    }

    /**
     * @param mail2 the mail2 to set
     */
    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    /**
     * @return the mail3
     */
    public String getMail3() {
        return mail3;
    }

    /**
     * @param mail3 the mail3 to set
     */
    public void setMail3(String mail3) {
        this.mail3 = mail3;
    }

    /**
     * @return the else1
     */
    public String getElse1() {
        return else1;
    }

    /**
     * @param else1 the else1 to set
     */
    public void setElse1(String else1) {
        this.else1 = else1;
    }

    /**
     * @return the else2
     */
    public String getElse2() {
        return else2;
    }

    /**
     * @param else2 the else2 to set
     */
    public void setElse2(String else2) {
        this.else2 = else2;
    }

    /**
     * @return the else3
     */
    public String getElse3() {
        return else3;
    }

    /**
     * @param else3 the else3 to set
     */
    public void setElse3(String else3) {
        this.else3 = else3;
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
