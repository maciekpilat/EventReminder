/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table(name = "scanTable")
public class Scan {

    @Id
    @GeneratedValue
    private long scanId;
    private String scanName;
    // ręcznie zmienione na LONGBLOB w bazie bo adnotacja nie działa. Why???
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private User userId;

    public Scan(String scanName, byte[] data) {
        this.scanName = scanName;
        this.data = data;
    }

    
    
    /**
     * @return the scanId
     */
    public long getScanId() {
        return scanId;
    }

    /**
     * @param scanId the scanId to set
     */
    public void setScanId(long scanId) {
        this.scanId = scanId;
    }

    /**
     * @return the scanName
     */
    public String getScanName() {
        return scanName;
    }

    /**
     * @param scanName the scanName to set
     */
    public void setScanName(String scanName) {
        this.scanName = scanName;
    }

    /**
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }


    
    

    

    
}
