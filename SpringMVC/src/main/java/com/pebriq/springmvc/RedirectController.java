package com.pebriq.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pebriq.member.StudentInformation;

@Controller
public class RedirectController {

	@RequestMapping("student/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		if(id.equals("abc")) {
			return "student/studentConfirm";
		}else {
			return "redirect:studentError";
		}
		
	}

	@RequestMapping("student/studentOk")
	public String studentOk(Model model) {
		return "student/studentOk";
	}
	
	@RequestMapping("student/studentError")
	public String studentError(Model model) {
		return "student/studentError";
	}
	
}
