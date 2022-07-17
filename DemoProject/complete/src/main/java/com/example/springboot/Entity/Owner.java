package com.example.springboot.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@NamedQuery(name="Owner.findbySSN",query="select o from Owner o where o.SSN=?1")
public class Owner {
@Id
private String ownerName;
private String SSN;
@ManyToOne(targetEntity = Company.class)
private Company comp;
}
