package com.pebriq.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/view")
	public String view() {
		
		return "view";
	}
	
	@RequestMapping("/content/contentView")
	public String contentVeiw(Model model) {
		
		model.addAttribute("id", "pebriq");
		
		return "content/contentView";
	}
	
	@RequestMapping("/model/modelEx")
	public String modelEx(Model model) {
		
		model.addAttribute("data", "test");
		
		return "model/modelEx";
	}
	
	@RequestMapping("modelAndView/modelView")
	public ModelAndView modelAndView() {
		
		ModelAndView mv =  new ModelAndView();
		mv.addObject("id", "pebriq");
		mv.setViewName("modelAndView/modelView");
		
		return mv;
	
	}
}
