package com.example.springboot.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.DAO.OwnerDAO;
import com.example.springboot.Entity.Owner;

@Service
public class OwnerService {
    @Autowired
	OwnerDAO OwnerDAO;
	@Transactional
	public Owner getSSN(String ssn) {
		Owner response =new Owner();
		try {
			response=OwnerDAO.getSSN(ssn)	;
		} catch (Exception e) {
			e.getMessage();
		}
		return response;	
	}
	

}
