/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.controller;

import com.waa.ars.domain.User;
import com.waa.ars.service.UserService;
import java.io.File;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kunda_000
 */

@Controller
@SessionAttributes("newUser")
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
    
    
    
    
    
    
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("newUser") User newUser, BindingResult result, HttpServletRequest request, Model model)
    {
        model.addAttribute("newUser", newUser);

        if(result.hasErrors())
            return "register";
        
        String md5password = DigestUtils.md5DigestAsHex(newUser.getPassword().getBytes());
        newUser.setPassword(md5password);
        
        MultipartFile loadedPicture = newUser.getPicture();
        
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String randString = RandomStringUtils.randomAlphanumeric(10);
        
        if(loadedPicture != null && !loadedPicture.isEmpty())
        {
            try
            {
                
                String newfilename = newUser.getUsername() + "_" + randString + ".jpg";
                
                loadedPicture.transferTo(new File(rootDirectory+"\\resources\\userpics\\"+newfilename));
                
                newUser.setProfileImage(newfilename);
                
            } catch (Exception ex){
                throw new RuntimeException("Product Image saving failed", ex);
            }
        }
        
        newUser.setVerificationCode(randString);
        
        try{
            userService.registerUser(newUser);    
        }catch(Exception e){
            System.out.println("User Registration Failed");
        }
        
        return "redirect:/";
    }
    
    
    
    
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping("/profile")
    public String userProfile(Principal principal, Model model)
    {
        
        model.addAttribute("newUser", userService.getUserByUsername(principal.getName()));
        
        return "profile";
    }
    
    
    
    
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
    public String editProfile()
    {
        
        //model.addAttribute("currentUser", userService.getUserByUsername(principal.getName()));
        
        return "register";
    }
    
    
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("newUser") User user, BindingResult result, Model model)
    {
        if(result.hasErrors())
            return "register";
        
        
        
        
        
        
        
        
        
        userService.registerUser(user);
        
        return "redirect:/profile";
    }
    
    
}
