/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.controller;

import com.waa.ars.domain.User;
import com.waa.ars.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kunda_000
 */

@Controller
public class UserController
{
    
    @Autowired
    UserService userService;
    
    
    
    
    @RequestMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("newUser", new User());
        
        return "register";
    }
    
    
    
    
    
    
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("newUser") User newUser, BindingResult result, HttpServletRequest request, Model model)
    {
        model.addAttribute("newUser", newUser);

        if(result.hasErrors())
            return "register";
        
        String md5password = DigestUtils.md5DigestAsHex(newUser.getPassword().getBytes());
        newUser.setPassword(md5password);
        
        MultipartFile loadedPicture = newUser.getPicture();
        
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        
        if(loadedPicture != null && !loadedPicture.isEmpty())
        {
            try
            {
                String randString = RandomStringUtils.randomAlphanumeric(10);
                String newfilename = newUser.getUsername() + "_" + randString + ".jpg";
                
                loadedPicture.transferTo(new File(rootDirectory+"\\resources\\userpics\\"+newfilename));
                
                newUser.setProfileImage(newfilename);
                
            } catch (Exception ex){
                throw new RuntimeException("Product Image saving failed", ex);
            }
            
        }
        
        try{
            userService.registerUser(newUser);
        }catch(Exception e){
            System.err.println("User Registration Failed");
        }
        
        return "redirect:/";
    }
    
    
    
    
    
    
    
    
    
    
}
