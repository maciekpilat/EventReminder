/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.service;
import java.util.List;
import org.pilat.model.EventTable;
/**
 *
 * @author Pilat
 */
public interface EventTableService {

public void saveEvent(EventTable e);

public void deleteEventById(long id);

public EventTable findEventById(long id);

public List<EventTable> findAllEvents();
}
