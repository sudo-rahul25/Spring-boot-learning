package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/contact")
	public String home() {
		System.out.println("home page");
		return "contact";
	}
}
