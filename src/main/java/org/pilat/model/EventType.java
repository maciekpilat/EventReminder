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
public enum EventType {
    
    mail("WYSŁANIE POCZTY"),
    call("ROZMOWA TELEFONICZNA"),
    hearing("ROZPRAWA");
    
    

    private String name;

    private EventType(String name) {
        this.name = name;
    }

//    public String eventTypeName() {
//        return getName();
//    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}