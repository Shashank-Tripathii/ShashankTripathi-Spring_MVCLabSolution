package com.learning.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	// Root Request we are diverting the request to the Home JSP
	@RequestMapping("/")
	public String showHomePage() {
		return "Home";
	}

}
