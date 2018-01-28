/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.service;

import java.util.List;
import org.pilat.model.EventTable;
import org.pilat.repository.EventTableRepo;

/**
 *
 * @author Pilat
 */
public class EventTableServiceImp implements EventTableService {

    EventTableRepo er;

    public void saveEvent(EventTable et) {
        er.save(et);
    }

    public void deleteEventById(long id) {
        er.delete(id);
    }

    public EventTable findEventById(long id) {
        EventTable et = er.findOne(id);
        return et;
    }

    public List<EventTable> findAllEvents() {

        return (List<EventTable>) er.findAll();
    }
}
