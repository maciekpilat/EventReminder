/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.model;

import java.sql.Timestamp;

/**
 *
 * @author Pilat
 */
public class EventMail extends Event{

private String eventType = "KORESPONDENCJA";
private String senderMail;
private String recieverMail;

    @Override
    public String toString() {
        return "EventMail{" + "eventType=" + eventType + ", senderMail=" + senderMail + ", recieverMail=" + recieverMail + '}';
    }

    public EventMail(String senderMail, String recieverMail, long userId, String eventNote, Timestamp eventStartDate, Timestamp eventEndDate) {
        super(userId, eventNote, eventStartDate, eventEndDate);
        this.senderMail = senderMail;
        this.recieverMail = recieverMail;
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
