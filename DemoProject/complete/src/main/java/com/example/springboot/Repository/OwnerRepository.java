package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entity.Owner;

@Repository
public interface OwnerRepository  extends JpaRepository<Owner ,String>{

    Owner findbySSN(String ssn);



}
