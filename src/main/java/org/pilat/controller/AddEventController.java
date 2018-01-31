/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import java.sql.Timestamp;
import org.pilat.model.EventTable;
import org.pilat.model.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.pilat.repository.EventTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pilat
 */
@Controller
public class AddEventController {

    @Autowired
    EventTableRepo er;

    @RequestMapping("/addevent")
    public String addEvent(Model model) {

//enum do dropdown
        model.addAttribute("enumValues", EventType.values());

        System.out.println("ODPALAM EventController!");

        return "addevent";
    }

    @PostMapping("/addevent")
    public String addAdressForm(Model model,
            @RequestParam("eventType") String eventType,
            @RequestParam("eventNote") String eventNote,
            @RequestParam("eventStartDate") Timestamp eventStartDate,
            @RequestParam("eventEndDate") Timestamp eventEndDate
            
    ) {

        model.addAttribute("enumValues", EventType.values());
        
        String senderMail = null;
        String recieverMail = null;
        
        
        EventTable et = new EventTable(0, eventNote, eventStartDate, eventEndDate, eventType, senderMail, recieverMail);

        System.out.println("Zapisuję!" + " " + et.toString());

        er.save(et);

        System.out.println("Zapisałem!" + " " + et.toString());

        return "addevent";
    }
}