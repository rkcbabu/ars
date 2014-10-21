/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa.ars.controller;

import com.waa.ars.domain.RentalInfo;
import com.waa.ars.domain.Status;
import com.waa.ars.service.RentalInfoService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/rentalInfo")
@Controller
public class RentalInfoController {

    @Autowired
    RentalInfoService rentalInfoService;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String bookApartment(@Valid @ModelAttribute("rentalInfo")  RentalInfo  rentalInfo, BindingResult result, HttpServletRequest request, Model model) {
        if(result.hasErrors())
            return "home";
        rentalInfo.setBookDate(new Date());
        rentalInfo.setStatus(Status.BOOKED);
        try{
            rentalInfoService.save(rentalInfo);
        }catch(Exception e){
            // later we send it to client ; 
            System.err.println("Booking process failed.");
        }
         return "redirect:/";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
//		binder.setValidator(productValidator);
        binder.setAllowedFields("apartmentId");
    }
}
