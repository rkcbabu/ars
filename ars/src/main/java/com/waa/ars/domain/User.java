/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.waa.ars.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;



@Entity(name="USERS")
public class User {
    
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private boolean enabled;
    
    private String profileImage;
    
    @Transient
    private MultipartFile picture;

    
    
    @OneToOne
    private Address address;
    
    @OneToMany
    private List<Apartment> apartments;
    
    @OneToMany
    private List<RentalInfo> rentalInfo;

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
          

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public List<RentalInfo> getRentalInfo() {
        return rentalInfo;
    }

    public void setRentalInfo(List<RentalInfo> rentalInfo) {
        this.rentalInfo = rentalInfo;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
    
    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getProfileImage()
    {
        return profileImage;
    }

    public void setProfileImage(String profileImage)
    {
        this.profileImage = profileImage;
    }

    public MultipartFile getPicture()
    {
        return picture;
    }

    public void setPicture(MultipartFile picture)
    {
        this.picture = picture;
    }
    
}
