

package com.waa.ars.controller;

import com.waa.ars.domain.Address;
import com.waa.ars.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AddressController
{
    @Autowired
    AddressService addressService;
    
    @RequestMapping("/add")
    public String addAddress(Model model)
    {
        model.addAttribute("address",new Address());
        
        return "addressForm";
    }
    
    
    
}
