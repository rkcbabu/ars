/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.service;

import com.waa.ars.domain.RentalInfo;
import java.util.List;


public interface RentalInfoService {
        List<RentalInfo> findAll();

	RentalInfo findOne(String rentalInfoID);
	
	void save(RentalInfo rentalInfo);
}
