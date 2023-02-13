package com.example.demo.secr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OurUserDetailsService implements UserDetailsService {
 
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("User Name given::"+username);
	 OurUser ouruser =userRepo.getUserName(username);	
		
	if(ouruser!=null) {
		log.info("User Details::"+ouruser.getUname()+"::"+ouruser.getPassword());
	}	
	
	List<Role> roles=userRepo.getRoles(username);
	log.info("Roles objects::"+roles);
	String[]strRoles=new String[roles.size()];
	
	for( int i=0;i<roles.size();i++) 
	{
		strRoles[i]=roles.get(i).getRname();
	}
		
	log.info("Role Strings::"+strRoles);	
	 UserDetails ud=User.builder().username(ouruser.getUname())
			                      .password("{noop}"+ouruser.getPassword())
			                      .roles(strRoles).build();	
		
		return ud;
	}

}
