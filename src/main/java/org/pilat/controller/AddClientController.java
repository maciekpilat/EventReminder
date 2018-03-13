/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import java.util.List;
import org.pilat.model.Adress;
import org.pilat.model.AdressType;
import org.pilat.model.Client;
import org.pilat.repository.AdressRepository;
import org.pilat.repository.AdressTypeRepository;
import org.pilat.repository.ClientRepository;
import org.pilat.repository.SetStreetNameRepository;
import org.pilat.utility.IterableToCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pilat
 */
@Controller
public class AddClientController {

    @Autowired
    SetStreetNameRepository setStreetNameRepository;
    @Autowired
    AdressTypeRepository adressTypeRepository;
    @Autowired
    IterableToCollection iterableToCollection;
    @Autowired
    AdressRepository adressRepository;
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/addclient")
    public String addClientGet(Model model) {

        //dropdown z bazy danych
        List<AdressType> list = iterableToCollection.makeCollection(adressTypeRepository.findAll());
        model.addAttribute("lists", list);
        
        // wyswietlam klientow
        List<Client> clientsList = iterableToCollection.makeCollection(clientRepository.findAll());
        model.addAttribute("clientsList", clientsList);
        
        
        

        return "addclient";
    }

    @PostMapping("/addclient")
    public String addClientPost(
            @RequestParam("adressType1") long adressType,
            @RequestParam("adressStreetNumber1") String adressStreetNumber,
            @RequestParam("adressStreetName1") String adressStreetName,
            @RequestParam("adressCity1") String sdressCity,
            @RequestParam("adressAdministrativeArea1") String adressAdministrative,
            @RequestParam("adressPostalCode1") String adressPostalCode,
            @RequestParam("adressCountry1") String adressCountry,
            @RequestParam("clientTitle") String clientTitle,
            @RequestParam("clientFirstName") String clientFirstName,
            @RequestParam("clientLastName") String clientLastName,
            @RequestParam("clientCompanyName") String clientCompanyName,
            Model model) {

        // na potrzeby dropdown z bazy danych
        List<AdressType> list = iterableToCollection.makeCollection(adressTypeRepository.findAll());
        model.addAttribute("lists", list);
        
        // wyświetlam klientow
        List<Client> clientsList = iterableToCollection.makeCollection(clientRepository.findAll());
        model.addAttribute("clientsList", clientsList);

        Client client = new Client(adressType, clientTitle, clientFirstName, clientLastName, clientCompanyName, null, null);
        
        adressRepository.save(new Adress(adressType, adressStreetNumber, adressStreetName, sdressCity, adressAdministrative, adressPostalCode, adressCountry, null, client, null));
        clientRepository.save(client);
        return "addclient";
    }

}
