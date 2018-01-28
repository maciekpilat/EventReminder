/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table(name = "eventTable")
public class EventTable {

    @Id
    @GeneratedValue
    private long eventId;
    private long userId;
    private String eventNote;
    private Timestamp eventStartDate;
    private Timestamp eventEndDate;
    private String eventType;
    private String senderMail;
    private String recieverMail;

    @Override
    public String toString() {
        return "eventTableClass{" + ", userId=" + userId + ", eventNote=" + eventNote + ", eventStartDate=" + eventStartDate + ", eventEndDate=" + eventEndDate + ", eventType=" + eventType + ", senderMail=" + senderMail + ", recieverMail=" + recieverMail + '}';
    }

    public EventTable(long userId, String eventNote, Timestamp eventStartDate, Timestamp eventEndDate, String eventType, String senderMail, String recieverMail) {
        this.userId = userId;
        this.eventNote = eventNote;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventType = eventType;
        this.senderMail = senderMail;
        this.recieverMail = recieverMail;
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
     * @return the eventNote
     */
    public String getEventNote() {
        return eventNote;
    }

    /**
     * @param eventNote the eventNote to set
     */
    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }

    /**
     * @return the eventStartDate
     */
    public Timestamp getEventStartDate() {
        return eventStartDate;
    }

    /**
     * @param eventStartDate the eventStartDate to set
     */
    public void setEventStartDate(Timestamp eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    /**
     * @return the eventEndDate
     */
    public Timestamp getEventEndDate() {
        return eventEndDate;
    }

    /**
     * @param eventEndDate the eventEndDate to set
     */
    public void setEventEndDate(Timestamp eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    /**
     * @return the eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * @return the senderMail
     */
    public String getSenderMail() {
        return senderMail;
    }

    /**
     * @param senderMail the senderMail to set
     */
    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    /**
     * @return the recieverMail
     */
    public String getRecieverMail() {
        return recieverMail;
    }

    /**
     * @param recieverMail the recieverMail to set
     */
    public void setRecieverMail(String recieverMail) {
        this.recieverMail = recieverMail;
    }

}
