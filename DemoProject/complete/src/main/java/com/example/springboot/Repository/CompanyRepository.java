package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entity.Company;

@Repository
public interface CompanyRepository  extends JpaRepository<Company ,String>{



}
