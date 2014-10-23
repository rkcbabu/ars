/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa.ars.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author CKarki
 */

@Entity(name="APARTMENT")
public class Apartment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    
    private String roomCount;
    private String rate;
    private String facilities;
    private String status;
    
    @Transient
    private List<MultipartFile> apartImages;   
    
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> fileNames = new HashSet();
            
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User owner;
    
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<RentalInfo> rentalInfos;
            
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private List<Picture> pictures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Picture> getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(List<Picture> pictures) {
//        this.pictures = pictures;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(String roomCount) {
        this.roomCount = roomCount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MultipartFile> getApartImages() {
        return apartImages;
    }

    public void setApartImages(List<MultipartFile> apartImages) {
        this.apartImages = apartImages;
    }

    public ArrayList<String> getFileNames() {
        return new ArrayList<String>(fileNames);
    }

    public void setFileNames(Set<String> fileNames) {
        this.fileNames = fileNames;
    }

    

//    public List<RentalInfo> getRentalInfos() {
//        return rentalInfos;
//    }
//
//    public void setRentalInfos(List<RentalInfo> rentalInfos) {
//        this.rentalInfos = rentalInfos;
//    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

}
