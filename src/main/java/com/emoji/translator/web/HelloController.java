package com.emoji.translator.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	  @GetMapping("/")
	  public String index() {
	    return "Greetings from Spring Boot!";
	  }
	  
	  
	  @GetMapping("/nadine")
	  public String nadine() {
	    return "Greetings from Nadine!";
	  }
	  
	  
	  
}
