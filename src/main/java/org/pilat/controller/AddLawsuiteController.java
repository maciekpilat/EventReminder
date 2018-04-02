/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.controller;

import java.util.List;
import org.pilat.utility.IterableToCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.pilat.repository.CourtDepartmentRepository;
import org.pilat.model.CourtDepartment;

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
    
    
    @GetMapping("/addlawsuit")
    public String addLawSuite(Model model){

        List<CourtDepartment> list = iterableToCollection.makeCollection(courtDepartmentRepository.findAll());
        System.out.println(list.toString());
        model.addAttribute("lists", list);

        return "addlawsuit";
    }
    
}
