/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.pilat.repository.SetStreetNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.pilat.repository.AdressTypeRepository;
import org.pilat.model.AdressType;
import org.pilat.utility.IterableToCollection;
import org.springframework.ui.Model;

/**
 *
 * @author Pilat
 */
@Controller

public class AddAdressController {

    @Autowired
    SetStreetNameRepository setStreetNameRepository;
    @Autowired
    AdressTypeRepository adressTypeRepository;
    @Autowired
    IterableToCollection iterableToCollection;

    @RequestMapping("/addadress")
    public String addAdress(Model model) {

        List<AdressType> list = iterableToCollection.makeCollection(adressTypeRepository.findAll());
        model.addAttribute("lists", list);

        return "addadress";
    }

    @PostMapping(value = "/addadress")
    public String getAdress(
            @RequestParam("adressStreetNumber1") String adressStreetNumber,
            @RequestParam("adressStreetName1") String adressStreetName,
            @RequestParam("adressCity1") String sdressCity,
            @RequestParam("adressPostalCode1") String adressPostalCode,
            @RequestParam("adressCountry1") String adressCountry,
            @RequestParam("adressAdministrativeArea1") String adressAdministrative,
            @RequestParam("adressType1") String adressType,
            Model model) {
     
        List<AdressType> list = iterableToCollection.makeCollection(adressTypeRepository.findAll());
        model.addAttribute("lists", list);
        
        System.out.println("ODPALAM POST");
        System.out.println(adressStreetName);
        System.out.println(adressType);

        return "addadress";
    }
}
