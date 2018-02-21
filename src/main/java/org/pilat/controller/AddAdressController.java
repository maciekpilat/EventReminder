/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.pilat.repository.SetStreetNameRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Pilat
 */
@Controller

public class AddAdressController {

    @Autowired
    SetStreetNameRepository setStreetNameRepository;

    // to wywołuje null pointer exception
    //List<SetStreetName> streetList = (List<SetStreetName>) setStreetNameRepository.findAll();

    @GetMapping("/addadress")
    public String addAdress() {

        return "addadress";
    }
}
