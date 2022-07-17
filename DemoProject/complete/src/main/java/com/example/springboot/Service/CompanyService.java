package com.example.springboot.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.DAO.CompanyDAO;
import com.example.springboot.Entity.Company;
import com.example.springboot.Entity.Owner;

@Service
public class CompanyService {
    @Autowired
	CompanyDAO companyDAO;

	@Transactional
	public Integer createNewCompany(Company company) {
		Integer response =0;
		try {
			companyDAO.saveCompany(company);	
		} catch (Exception e) {
			response=1;
			e.getMessage();
		}
		return response;	
	}
	@Transactional
	public List<Company> getAllCompany() {
		List<Company> companyLst=new ArrayList<Company>();
		try {
			companyLst=companyDAO.getAllCompany();	
		} catch (Exception e) {
			e.getMessage();
		}
		return companyLst;	
	}
	@Transactional
	public Company getCompany(String companyId) {
		Company response =new Company();
		try {
			response=companyDAO.getCompany(companyId);	
		} catch (Exception e) {
			e.getMessage();
		}
		return response;	
	}
	@Transactional
	public Integer updateCompany(Company com) {
		Integer response =0;
		try {
			companyDAO.updateCompany(com);	
		} catch (Exception e) {
			response=1;
			e.getMessage();
		}
		return response;	
	}
	@Transactional
	public Integer addOwner(String companyId,Owner owner) {
		Integer response =0;
		try {
			companyDAO.addOwner(companyId, owner);	
		} catch (Exception e) {
			response=1;
			e.getMessage();
		}
		return response;	
	}
	

}
