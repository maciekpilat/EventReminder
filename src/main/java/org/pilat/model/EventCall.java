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
public class EventCall extends Event{

private String eventType = "ROZMOWA TELEFONICZNA";

    @Override
    public String toString() {
        return "EventCall{" + "eventType=" + eventType + '}';
    }

    public EventCall(long userId, String eventNote, Timestamp eventStartDate, Timestamp eventEndDate) {
        super(userId, eventNote, eventStartDate, eventEndDate);
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



}
