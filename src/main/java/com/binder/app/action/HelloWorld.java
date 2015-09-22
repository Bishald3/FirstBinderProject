package com.binder.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloWorld {
	
	@RequestMapping("/")
	public String HelloPage(){
		return "hello";
	}
}
