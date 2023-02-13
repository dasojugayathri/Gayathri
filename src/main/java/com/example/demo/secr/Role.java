package com.example.demo.secr;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Role {
	
	@Id
	@GeneratedValue
	private int rid;
	private String rname;

}
