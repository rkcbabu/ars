/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.service.impl;

import com.waa.ars.domain.RentalInfo;
import com.waa.ars.repository.RentalInfoRepository;
import com.waa.ars.service.RentalInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalInfoServiceImpl implements RentalInfoService {
    @Autowired
    RentalInfoRepository rentalInfoRepository; 

    @Override
    public List<RentalInfo> findAll() {
        
        return  rentalInfoRepository.findAll();
    }

    @Override
    public RentalInfo findOne(String rentalInfoID) {
        return rentalInfoRepository.findOne(rentalInfoID);
    }

    @Override
    public void save(RentalInfo rentalInfo) {
        rentalInfoRepository.save(rentalInfo);
    }
    
    
}
