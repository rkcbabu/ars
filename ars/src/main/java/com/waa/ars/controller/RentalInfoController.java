/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa.ars.controller;

import com.waa.ars.domain.Apartment;
import com.waa.ars.domain.RentalInfo;
import com.waa.ars.domain.Status;
import com.waa.ars.domain.User;
import com.waa.ars.service.ApartmentService;
import com.waa.ars.service.RentalInfoService;
import com.waa.ars.service.UserService;
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
    
    @Autowired
    UserService userService;
    
    @Autowired
    ApartmentService apartmentService;
    
    
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String bookApartment(  HttpServletRequest request, Model model) {
        RentalInfo rentalInfo = new RentalInfo();
        
        rentalInfo.setBookDate(new Date());
//        rentalInfo.setEndDate(new Date());
//        rentalInfo.setRentalDate(new Date());
//        rentalInfo.setStatus(Status.BOOKED);
        User u = userService.getUserByUsername("username"); //dummy
//        System.err.println(u.getEmail());
        
        rentalInfo.setUser(userService.getUserByUsername("username")); // dummy purpose ; 
        Apartment a = apartmentService.getApartmentById(1);
//        System.err.println(a.getId());
        
        rentalInfo.setApartment(a); // dummy purpose ;
//        if(result.hasErrors())
//            return "apartment";
        try{
            rentalInfoService.save(rentalInfo);
        }catch(Exception e){
            // later we send it to client ; 
            System.err.println("Booking process failed. "+e.getMessage());
        }
//         return "redirect:/";
         return "apartment";
    }

//    @InitBinder
//    public void initialiseBinder(WebDataBinder binder) {
////		binder.setValidator(productValidator);
//        binder.setAllowedFields("apartmentId");
//    }
}
