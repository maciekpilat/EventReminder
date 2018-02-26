/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class User {
@Id
@GeneratedValue
private long userId;
private String userMail;
@Column(nullable = false, unique = true)
private String userLogin;
private String userPassword;
@OneToMany(cascade = CascadeType.REFRESH)
private List<Scan> scanList;

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userMail=" + userMail + ", userLogin=" + getUserLogin() + ", userPassword=" + userPassword + ", scanList=" + scanList + '}';
    }




    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return the userMail
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * @param userMail the userMail to set
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the scanList
     */
    public List<Scan> getScanList() {
        return scanList;
    }

    /**
     * @param scanList the scanList to set
     */
    public void setScanList(List<Scan> scanList) {
        this.scanList = scanList;
    }

    /**
     * @return the userLogin
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * @param userLogin the userLogin to set
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }



}
