package spring5_rest_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@GetMapping("/read")
	public ModelAndView getMemberById(@RequestParam(value ="id") long id) {
		ModelAndView mav = new ModelAndView("member/get", "id",id);
		return mav;
	}
	
	@GetMapping("/update")
	public ModelAndView updateMember(@RequestParam(value = "id") long id) {
		ModelAndView mav = new ModelAndView("member/update", "id",id);
		return mav;
	}
	
	@GetMapping("/new")
	public ModelAndView newMember() {
		ModelAndView mav = new ModelAndView("member/register");
		return mav;
	}
}
