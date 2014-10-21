/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.controller;

import com.waa.ars.domain.Apartment;
import com.waa.ars.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author CKarki
 */

@Controller
@RequestMapping("/apartment")
public class ApartmentController {
    
    @Autowired
    ApartmentService apartmentService;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String saveApartment(@ModelAttribute("newApartment") Apartment apartment){     
        return "apartmentForm";
    }
    
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newApartment") Apartment apartment, BindingResult result){
        
        if(result.hasErrors())
        {
            return "apartmentForm";
        }
        
        try{
        apartmentService.addApartment(apartment);
        }
        catch(Exception ex)
        {
            System.out.println("Apartment transaction failed");
        }
        return "apartment";
    }
    
    
        
    
}
