/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.controller;

import com.waa.ars.domain.Apartment;
import com.waa.ars.domain.User;
import com.waa.ars.service.ApartmentService;
import com.waa.ars.service.UserService;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author CKarki
 */

@Controller
@RequestMapping("/apartment")
public class ApartmentController {
    
    @Autowired
    ApartmentService apartmentService;
    
    @Autowired
    UserService userService;
    
    
    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addApartmentForm(@ModelAttribute("newApartment")Apartment apartment){
      
        return "apartmentForm";
    }
    
    
    
    
    @Secured("ROLE_USER")
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String processAddNewApartmentForm(@ModelAttribute("newApartment") Apartment apartment, BindingResult result, Principal principal, 
            HttpServletRequest request,Model map){
        
        if(result.hasErrors())
        {
            return "apartmentForm";
        }
        
        User user = userService.getUserByUsername(principal.getName());
        user.getApartments().add(apartment);
        apartment.setOwner(user);
        
        List<MultipartFile> apartImages = apartment.getApartImages();
        Set<String> fileNames = new HashSet<String>();
        
        if(apartImages!=null && !apartImages.isEmpty()){
            for(MultipartFile multipartFile : apartImages){
                
               // String fileName = multipartFile.getOriginalFilename();
                String randString = RandomStringUtils.randomAlphanumeric(20);
                String fileName = randString + ".jpg";
                String rootDirectory = request.getSession().getServletContext().getRealPath("/");
                try {
                    multipartFile.transferTo(new File(rootDirectory+"\\resources\\apartImages\\"+fileName));
                    fileNames.add(fileName);
                } catch (Exception ex) {
                    System.out.println("Apartment Image Saving failed");
                }    
                
                
            }    
        }
        apartment.setFileNames(fileNames);
        
        //map.addAttribute("apartImages",fileNames);
       
        try{
            apartmentService.addApartment(apartment);
//            userService.registerUser(user);
        }
        catch(Exception ex)
        {
            System.out.println("Apartment transaction failed");
        }
        return "redirect:/user/apartments";
    }
    
//    @RequestMapping("/view")
//    public String viewApartment(){
//        return "apartment";
//    }
    


    
    @RequestMapping(value = "/view/{apartmentId}", method = RequestMethod.GET)
    public String displayApartment(@PathVariable("apartmentId") Integer apartmentId, Model model) {
        model.addAttribute("apartment", apartmentService.getApartmentById(apartmentId));
        return "apartment";
    }
    
    @Secured("ROLE_USER")
    @RequestMapping(value = "/edit/{apartmentId}", method = RequestMethod.GET)
    public String editApartment(@PathVariable("apartmentId") Integer apartmentId,Principal principal, Model model) {
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        
        if(apartment.getOwner().getUsername().equals(principal.getName()))
        {
            model.addAttribute("newApartment", apartment);
            return "apartmentForm";
        }else{
            return "/403";
        }
        
    }
        
    
}
