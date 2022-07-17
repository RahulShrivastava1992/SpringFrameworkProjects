package com.example.springboot.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Company {
@Id
private String companyId;
private String companyName;
private String country;
private String phoneNumber;
@OneToMany(targetEntity=Owner.class)
private List<Owner> ownerLst;


}
