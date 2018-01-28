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

public class Event {


    private long eventId;
    private long userId;
    private String eventNote;
    private Timestamp eventStartDate;
    private Timestamp eventEndDate;

    @Override
    public String toString() {
        return "Event{" + "eventId=" + eventId + ", userId=" + userId + ", eventNote=" + eventNote + ", eventStartDate=" + eventStartDate + ", eventEndDate=" + eventEndDate + '}';
    }

    public Event(long userId, String eventNote, Timestamp eventStartDate, Timestamp eventEndDate) {
        this.userId = userId;
        this.eventNote = eventNote;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }
    
    /**
     * @return the eventId
     */
    public long getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(long eventId) {
        this.eventId = eventId;
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

}
