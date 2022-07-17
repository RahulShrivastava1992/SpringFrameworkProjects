package com.example.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Entity.Company;
import com.example.springboot.Entity.Owner;
import com.example.springboot.Entity.Response;
import com.example.springboot.Service.CompanyService;
import com.example.springboot.Service.OwnerService;

@RestController
public class HelloController {
    @Autowired
	CompanyService cs;
	@Autowired
	OwnerService os;
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	@PostMapping("/createNewCompany")
	public Response createNewCompany(@RequestBody Company company) {
        Integer res=cs.createNewCompany(company);
		Response response=new Response();
		if(res==0){
			response.setReponseCd("200");
			response.setResMsg("Company created successfully");
		}
		else{
			response.setReponseCd("100");
			response.setResMsg("Company creation unsuccessfull");
		}
		return response;
	}
	@GetMapping("/getCompanyList")
	public List<Company> getCompanyList() {
        List<Company> res=cs.getAllCompany();
		return res;
	}
	@GetMapping("/getCompany")
	public Company getCompany(@RequestBody String companyId) {
        Company res=cs.getCompany(companyId);
		return res;
	}
	@PostMapping("/updateCompany")
	public Response updateCompany(@RequestBody Company company) {
        Integer res=cs.updateCompany(company);
		Response response=new Response();
		if(res==0){
			response.setReponseCd("200");
			response.setResMsg("Company updated successfully");
		}
		else{
			response.setReponseCd("100");
			response.setResMsg("Company updation unsuccessfull");
		}
		return response;
	}
	@PostMapping("/addOwner/{companyId}")
	public Response addOwner(@PathVariable String companyId, @RequestBody Owner owner) {
        Integer res=cs.addOwner(companyId, owner);
		Response response=new Response();
		if(res==0){
			response.setReponseCd("200");
			response.setResMsg("Company created successfully");
		}
		else{
			response.setReponseCd("100");
			response.setResMsg("Company creation unsuccessfull");
		}
		return response;
	}
	@GetMapping("/checkSSN")
	public Response checkSSN(@RequestBody String ssn) {
        Owner res=os.getSSN(ssn);
		Response response=new Response();
		if(res!=null && res.getSSN()!=null){
			response.setReponseCd("200");
			response.setResMsg("SSN is valid");
		}
		else if(res==null){
			response.setReponseCd("100");
			response.setResMsg("SSN is invalid");
		}
		return response;
	}
}
