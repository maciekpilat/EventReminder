/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import java.util.List;
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
import org.pilat.repository.LawsuitRepository;

/**
 *
 * @author Pilat
 */
@Controller
public class AddLawsuiteController {

    @Autowired
    IterableToCollection iterableToCollection;
    @Autowired
    CourtDepartmentRepository courtDepartmentRepository;
    @Autowired
    PartyTypeRepository partyTypeRepository;
    @Autowired
    LawsuitRepository lawsuitRepository;

    @GetMapping("/addlawsuit")
    public String getAddLawSuite(Model model) {

        Lawsuit lawsuit = new Lawsuit();
        CourtDepartment courtDepartment = new CourtDepartment();

        // do modelu dodajemy obiekty na dane
        model.addAttribute("lawsuit", lawsuit);
        model.addAttribute("courtDepartment", courtDepartment);

        List<CourtDepartment> list = iterableToCollection.makeCollection(courtDepartmentRepository.findAll());
        model.addAttribute("lists", list);

        return "addlawsuit";
    }

    @PostMapping("/addlawsuit")
    public String postAddLawSuite(@Valid @ModelAttribute("lawsuit") Lawsuit lawsuit,
            BindingResult result, ModelMap model) {

        lawsuitRepository.save(lawsuit);
        return "addlawsuit";
    }

}
