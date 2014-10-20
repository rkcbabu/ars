/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.domain;

import java.util.List;

/**
 *
 * @author CKarki
 */
public class Buyer extends User {
    
    private int id;
    private List<RentalInfo> rentalInfo ;

      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public List<RentalInfo> getRentalInfo() {
        return rentalInfo;
    }

    public void setRentalInfo(List<RentalInfo> rentalInfo) {
        this.rentalInfo = rentalInfo;
    }

  
    
}
