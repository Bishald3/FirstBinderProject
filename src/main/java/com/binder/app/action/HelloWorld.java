package com.binder.app.action;

import com.binder.app.action.Users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorld {
	
	@RequestMapping("/")
	public String HelloPage(){
		return "login";
	}
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public ModelAndView UserInfo(){
		
		Users urs = new Users();
		
		List<String> list = getList();
		//return back to userInfo.jsp
		ModelAndView model = new ModelAndView("UserInfo");
		model.addObject("lists", list);
		return model;
	}
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}
}
