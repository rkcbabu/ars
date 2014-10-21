/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.controller;

import com.waa.ars.domain.User;
import com.waa.ars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String register(@ModelAttribute("user") User user, Model model)
    {
        model.addAttribute("user", user);
        
        return "register";
    }
    
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model)
    {
        model.addAttribute("user", user);

        if(result.hasErrors())
            return "register";
        
        String md5password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5password);
        
        userService.registerUser(user);
        
        return "register";
    }
    
}
