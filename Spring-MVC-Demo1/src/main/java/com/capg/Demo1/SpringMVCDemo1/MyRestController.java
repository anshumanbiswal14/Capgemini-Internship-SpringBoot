package com.capg.Demo1.SpringMVCDemo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@GetMapping("/hi")
	public String sayHello() {
		
		return "Hello Anshuman!";
	}

}
