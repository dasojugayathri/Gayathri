package com.example.demo.secr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)


public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
    	UserDetails user=User.builder()
    			                    .username("ammu")
    			                    .password("{noop}ammu")
    			                    .roles("USER")
    			                    .build();
    	 UserDetails user1=User.builder()
                              .username("bunny")
                              .password("{noop}bunny")
                              .roles("USER","ADMIN")
                              .build();
    	 UserDetails user2=User.builder()
                              .username("sony")
                              .password("{noop}sony")
                              .roles("USER","ADMIN","MANAGER")
                              .build();


    
    	return new InMemoryUserDetailsManager(user,user1,user2);
    }
	

}
