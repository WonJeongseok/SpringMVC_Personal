package com.pebriq.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pebriq.member.Member;
import com.pebriq.member.StudentInformation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest .getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmId";
	}
	
	@RequestMapping("board/checkId")
	public String checkId(@RequestParam("id") String id,
								  @RequestParam("pw") int pw,
								  Model model) {
		
		model.addAttribute("id" , id);
		model.addAttribute("pw", pw);
		
		return "board/checkId";
		
	}
	
	//	데이터가 많을경우 코드량이 너무 많아진다.
	/*@RequestMapping("/member/join")
	public String joinData(@RequestParam("name") String name,@RequestParam("id") String id, 
									@RequestParam("pw") String pw,@RequestParam("email") String email, Model model) {
		
		Member member = new Member();
		member.setId(id);
		member.setEmail(email);
		member.setName(name);
		member.setPw(pw);
		
		model.addAttribute("memberInfo", member);
		
		
		return "member/join";		
	}*/
	
	@RequestMapping("/member/join")
	public String joinData(Member member) {
		return "member/join";
	}
	
	@RequestMapping("/index")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
		
		System.out.println("RequestMethod.GET");
		
		String id = httpServletRequest.getParameter("id");
		System.out.println("id : " + id);
		model.addAttribute("studentId", id);
		
		return "member/student";
		
	}
	
	@RequestMapping("student/studentIndex")
	public String studentIndex() {
		return "student/studentIndex";
	}
	
	@RequestMapping("/studentView")
	public String studentView(@ModelAttribute("studentInfo") StudentInformation studentInformation) {
		return "student/studentView";
	}
	
	
}












