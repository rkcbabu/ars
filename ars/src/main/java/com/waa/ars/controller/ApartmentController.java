/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.controller;

import com.waa.ars.domain.Apartment;
import com.waa.ars.service.ApartmentService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addApartmentForm(@ModelAttribute("newApartment")Apartment apartment){
      
        return "apartmentForm";
    }
    
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String processAddNewApartmentForm(@ModelAttribute("newApartment") Apartment apartment, BindingResult result,
            HttpServletRequest request,Model map){
        
        if(result.hasErrors())
        {
            return "apartmentForm";
        }
        
        List<MultipartFile> apartImages = apartment.getApartImages();
        Set<String> fileNames = new HashSet<String>();
        
        if(apartImages!=null && !apartImages.isEmpty()){
            for(MultipartFile multipartFile : apartImages){
                
               // String fileName = multipartFile.getOriginalFilename();
                String randString = RandomStringUtils.randomAlphanumeric(10);
                String fileName = randString + ".jpg";
                String rootDirectory = request.getSession().getServletContext().getRealPath("/");
                try {
                    multipartFile.transferTo(new File(rootDirectory+"\\resources\\apartImages\\"+fileName));
                } catch (Exception ex) {
                    System.out.println("Apartment Image Saving failed");
                }    
                fileNames.add(fileName);
                
            }    
        }
        apartment.setFileNames(fileNames);
        //map.addAttribute("apartImages",fileNames);
       
        try{
        apartmentService.addApartment(apartment);
        }
        catch(Exception ex)
        {
            System.out.println("Apartment transaction failed");
        }
        return "apartment";
    }
    
//    @RequestMapping("/view")
//    public String viewApartment(){
//        return "apartment";
//    }
    


    
    @RequestMapping(value = "/view/{apartmentId}", method = RequestMethod.GET)
    public String displayApartment(@PathVariable("apartmentId") Integer apartmentId, Model model) {
        model.addAttribute("apartment", apartmentService.getApartmentById(apartmentId));
        return "displayApartment";
    }
        
    
}
