/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.pilat.model.Client;
import org.pilat.utility.IterableToCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.pilat.repository.CourtDepartmentRepository;
import org.pilat.model.CourtDepartment;
import org.pilat.model.PartyType;
import org.pilat.repository.PartyTypeRepository;
import org.pilat.model.Lawsuit;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.pilat.model.CourtDepartment;
import org.pilat.model.Party;
import org.pilat.repository.ClientRepository;
import org.pilat.repository.LawsuitRepository;
import org.pilat.formwrap.PartyFormWrap;
import org.pilat.repository.PartyRepository;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 *
 * @author Pilat
 */
@ControllerAdvice
@Controller
public class AddPartyController {

    @Autowired
    IterableToCollection iterableToCollection;
    @Autowired
    CourtDepartmentRepository courtDepartmentRepository;
    @Autowired
    PartyTypeRepository partyTypeRepository;
    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    ClientRepository clientRepository;
    //@Autowired
    //PartyFormWrap partyFormWrap;
    //@Autowired
    //PartyFormWrapRepository partyFormWrapRepository;
    @Autowired
    PartyRepository partyRepository;

    @ModelAttribute
    @GetMapping("/addparty")
    public String getAddParty(Model model) {

// pobieram z bazy typy stron i przekazuje je do dropdown
        List<PartyType> list = iterableToCollection.makeCollection(partyTypeRepository.findAll());
        model.addAttribute("lists", list);

        Party party = new Party();
        model.addAttribute("party", party);

        return "addparty";
    }

    @PostMapping("/addparty")
    public String postAddParty(Model model, @ModelAttribute Party party) {

        List<PartyType> list = iterableToCollection.makeCollection(partyTypeRepository.findAll());
        model.addAttribute("lists", list);

        model.addAttribute("party", party);

        partyRepository.save(party);

        return "addparty";
    }

//    @GetMapping("/addparty")
//    public String getAddParty(Model model, @ModelAttribute("aaa") PartyFormWrap partyFormWrap) {
//
//// pobieram z bazy typy stron i przekazuje je do dropdown
//        List<PartyType> list = iterableToCollection.makeCollection(partyTypeRepository.findAll());
//        model.addAttribute("lists", list);
//
//        return "addparty";
//    }
//
//    @PostMapping("/addparty")
//    public String postAddParty(Model model, @ModelAttribute("aaa") PartyFormWrap partyFormWrap) {
//
//        
//        partyFormWrapRepository.save(partyFormWrap);
//       // clientRepository.save(partyFormWrap.getClient());
//        
//        return "addparty";
//    }
}
