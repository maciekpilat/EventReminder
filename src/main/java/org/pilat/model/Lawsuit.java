/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Lawsuit {
    
    @Id
    @GeneratedValue
    private long lawsuitId;
    private String courtFileReference;

    @ManyToOne()
    @JoinColumn(name = "courtDepartmentId")
    private CourtDepartment courtDepartment;
    
    @OneToMany(mappedBy = "lawsuit")
    private List<Party> party;
    
    @ManyToOne()
    @JoinColumn(name = "clientId")
    private Client client;

    /**
     * @return the lawsuitId
     */
    public long getLawsuitId() {
        return lawsuitId;
    }

    /**
     * @param lawsuitId the lawsuitId to set
     */
    public void setLawsuitId(long lawsuitId) {
        this.lawsuitId = lawsuitId;
    }

    /**
     * @return the courtFileReference
     */
    public String getCourtFileReference() {
        return courtFileReference;
    }

    /**
     * @param courtFileReference the courtFileReference to set
     */
    public void setCourtFileReference(String courtFileReference) {
        this.courtFileReference = courtFileReference;
    }

//    /**
//     * @return the court
//     */
//    public Court getCourt() {
//        return court;
//    }
//
//    /**
//     * @param court the court to set
//     */
//    public void setCourt(Court court) {
//        this.court = court;
//    }

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

    /**
     * @return the party
     */
    public List<Party> getParty() {
        return party;
    }

    /**
     * @param party the party to set
     */
    public void setParty(List<Party> party) {
        this.party = party;
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
    
}
