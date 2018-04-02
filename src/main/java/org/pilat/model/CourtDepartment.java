/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

/**
 *
 * @author Pilat
 */
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class CourtDepartment {

    @Id
    @GeneratedValue
    private Long departmentId;
    private String courtDepartmentName;
    @ManyToOne
    @JoinColumn(name = "courtId")
    private Court court;
    @OneToMany(mappedBy = "courtDepartment")
    private List<Adress> adres;
    @OneToMany(mappedBy = "courtDepartment")
    private List<ContactData> contactData;
    @OneToMany(mappedBy = "courtDepartment")
    private List<Lawsuit> lawsuit;

    /**
     * @return the departmentId
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
     * @return the adres
     */
    public List<Adress> getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(List<Adress> adres) {
        this.adres = adres;
    }

    /**
     * @return the contactData
     */
    public List<ContactData> getContactData() {
        return contactData;
    }

    /**
     * @param contactData the contactData to set
     */
    public void setContactData(List<ContactData> contactData) {
        this.contactData = contactData;
    }

    /**
     * @return the lawsuit
     */
    public List<Lawsuit> getLawsuit() {
        return lawsuit;
    }

    /**
     * @param lawsuit the lawsuit to set
     */
    public void setLawsuit(List<Lawsuit> lawsuit) {
        this.lawsuit = lawsuit;
    }

    /**
     * @return the courtDepartmentName
     */
    public String getCourtDepartmentName() {
        return courtDepartmentName;
    }

    /**
     * @param courtDepartmentName the courtDepartmentName to set
     */
    public void setCourtDepartmentName(String courtDepartmentName) {
        this.courtDepartmentName = courtDepartmentName;
    }
    
}
