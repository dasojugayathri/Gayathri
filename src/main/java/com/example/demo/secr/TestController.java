package com.example.demo.secr;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PreAuthorize("hasRole('USER')")
	@GetMapping("hii")
	public String m1() {
		return "hello";
		
	}
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("test1")
	public String m2() {
		return "hello hii";
		
	}
    @PreAuthorize("hasRole('MANAGER')")
	@GetMapping("test2")
	public String m3() {
		return "how r u";
		
	}
}
