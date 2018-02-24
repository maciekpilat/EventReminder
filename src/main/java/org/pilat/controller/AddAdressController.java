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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pilat
 */
@Controller

public class AddAdressController {

    @Autowired
    SetStreetNameRepository setStreetNameRepository;

    @GetMapping("/addadress")
    public String addAdress() {

        return "addadress";
    }

    @PostMapping(value="/addadress")
    public String getAdress(@RequestParam("adressStreetNumber1") String adressStreetNumber, @RequestParam("adressStreetName1") String adressStreetName, @RequestParam("adressCity1") String sdressCity, @RequestParam("adressPostalCode1") String adressPostalCode, @RequestParam("adressCountry1") String adressCountry, @RequestParam("adressAdministrativeArea1") String adressAdministrative) {
        //System.out.println("ODPALAM POST");
        // System.out.println(adressStreetName);

        return "addadress";
    }
}
