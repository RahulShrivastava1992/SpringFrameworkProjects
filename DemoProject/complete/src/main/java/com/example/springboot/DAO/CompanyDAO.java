package com.example.springboot.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.springboot.Entity.Company;
import com.example.springboot.Entity.Owner;
import com.example.springboot.Repository.CompanyRepository;

@Component
public class CompanyDAO{
    @Autowired
    CompanyRepository cr;
   public Company saveCompany(Company com){
    cr.save(com);
    return com;
   }
   public List<Company> getAllCompany(){
    List<Company> comLst=cr.findAll();
    return comLst;
   }
   public Company getCompany(String companyId){
    Company comLst=cr.findById(companyId).orElse(null);
    return comLst;
   }
   public Company updateCompany(Company company){
    Company com=cr.findById(company.getCompanyId()).orElse(null);
    com.setCompanyName(company.getCompanyName());
    com.setCountry(company.getCountry());
    com.setOwnerLst(company.getOwnerLst());
    com.setPhoneNumber(company.getPhoneNumber());
    cr.save(com);
    return com;
   }
   public Company addOwner(String companyId,Owner owner){
    Company com=cr.findById(companyId).orElse(null);
    List<Owner> lstOwner=com.getOwnerLst();
    lstOwner.add(owner);
    com.setOwnerLst(lstOwner);
    cr.save(com);
    return com;
   }
}
