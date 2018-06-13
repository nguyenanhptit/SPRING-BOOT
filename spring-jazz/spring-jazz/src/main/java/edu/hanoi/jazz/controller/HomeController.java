package edu.hanoi.jazz.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableWebSecurity
@ComponentScan("edu.hanoi")
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "Hello Jazz Clazz");
		return mv;
	}

	@RequestMapping(value = "/nguoi-dung", method = RequestMethod.GET)
	public ModelAndView forUser() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "This is protected page!");
		return mv;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView mv = new ModelAndView("login");
		if (error != null)
			mv.addObject("error", error);
		return mv;
	}
}