/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.pilat.model.Adress;
import org.pilat.model.CourtDepartment;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Court {

    @Id
    @GeneratedValue
    private long courtId;
    private String courtName;
    @OneToMany
    private List<Adress> adress;
    @OneToMany
    private List<CourtDepartment> courtDepartmentList;
    

    /**
     * @return the courtId
     */
    public long getCourtId() {
        return courtId;
    }

    /**
     * @param courtId the courtId to set
     */
    public void setCourtId(long courtId) {
        this.courtId = courtId;
    }

    /**
     * @return the courtName
     */
    public String getCourtName() {
        return courtName;
    }

    /**
     * @param courtName the courtName to set
     */
    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    /**
     * @return the courtDepartmentList
     */
    public List<CourtDepartment> getCourtDepartmentList() {
        return courtDepartmentList;
    }

    /**
     * @param courtDepartmentList the courtDepartmentList to set
     */
    public void setCourtDepartmentList(List<CourtDepartment> courtDepartmentList) {
        this.courtDepartmentList = courtDepartmentList;
    }

    /**
     * @return the adress
     */
    public List<Adress> getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(List<Adress> adress) {
        this.adress = adress;
    }


    
    

}
