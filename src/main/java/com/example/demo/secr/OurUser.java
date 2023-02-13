package com.example.demo.secr;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="User")
public class OurUser {
	
	@Id
	@GeneratedValue
  private int uid;
  private String uname;
  private int password;
  @ManyToMany
  @JoinTable(name="user_role",
  joinColumns = {@JoinColumn(name="uid")},
  inverseJoinColumns = {@JoinColumn(name="rid")}
		  )
  private List<Role> roles;
  
  
  
	
	
	

}
