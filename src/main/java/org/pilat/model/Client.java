/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.pilat.model.Adress;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    private long clientType; // osoba fizyczna firma
    private String clientTitle;
    private String clientFirstName;
    private String clientLastName;
    private String clientCompanyName;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Adress> clientAdress;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Lawsuit> clientLawsuit;

    public Client(long clientType, String clientTitle, String clientFirstName, String clientLastName, String clientCompanyName, List<Adress> clientAdress, List<Lawsuit> clientLawsuit) {
        this.clientType = clientType;
        this.clientTitle = clientTitle;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientCompanyName = clientCompanyName;
        this.clientAdress = clientAdress;
        this.clientLawsuit = clientLawsuit;
    }

    public Client() {
    }

    
    
    /**
     * @return the clientId
     */
    public long getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the clientType
     */
    public long getClientType() {
        return clientType;
    }

    /**
     * @param clientType the clientType to set
     */
    public void setClientType(long clientType) {
        this.clientType = clientType;
    }

    /**
     * @return the clientTitle
     */
    public String getClientTitle() {
        return clientTitle;
    }

    /**
     * @param clientTitle the clientTitle to set
     */
    public void setClientTitle(String clientTitle) {
        this.clientTitle = clientTitle;
    }

    /**
     * @return the clientFirstName
     */
    public String getClientFirstName() {
        return clientFirstName;
    }

    /**
     * @param clientFirstName the clientFirstName to set
     */
    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    /**
     * @return the clientLastName
     */
    public String getClientLastName() {
        return clientLastName;
    }

    /**
     * @param clientLastName the clientLastName to set
     */
    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    /**
     * @return the clientCompanyName
     */
    public String getClientCompanyName() {
        return clientCompanyName;
    }

    /**
     * @param clientCompanyName the clientCompanyName to set
     */
    public void setClientCompanyName(String clientCompanyName) {
        this.clientCompanyName = clientCompanyName;
    }

    /**
     * @return the clientAdress
     */
    public List<Adress> getClientAdress() {
        return clientAdress;
    }

    /**
     * @param clientAdress the clientAdress to set
     */
    public void setClientAdress(List<Adress> clientAdress) {
        this.clientAdress = clientAdress;
    }

    /**
     * @return the clientLawsuit
     */
    public List<Lawsuit> getClientLawsuit() {
        return clientLawsuit;
    }

    /**
     * @param clientLawsuit the clientLawsuit to set
     */
    public void setClientLawsuit(List<Lawsuit> clientLawsuit) {
        this.clientLawsuit = clientLawsuit;
    }

    
}
