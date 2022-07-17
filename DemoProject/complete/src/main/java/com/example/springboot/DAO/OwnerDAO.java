package com.example.springboot.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.springboot.Entity.Owner;
import com.example.springboot.Repository.OwnerRepository;

@Component
public class OwnerDAO{
    @Autowired
    OwnerRepository cr;
   
   public Owner getSSN(String ssn){
    Owner owner=cr.findbySSN(ssn);
    return owner;
   }
   
}
