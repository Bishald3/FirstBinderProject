package com.binder.app.common;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.binder.app.action.Users;


@Controller
public class Services {
	
	@RequestMapping("/")
	public String login(){
		Logger.getLogger("test for login page:");
		return "login";
	}
	
	@RequestMapping("/UserForm")
	public String DisplayUserForm(){
		return "UserForm";
	}
	
}
