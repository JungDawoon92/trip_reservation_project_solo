package com.spring.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

		@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
		public String login(Model model) {
			model.addAttribute("loginBean", new LoginBean());
			// loginForm.jsp 가 처음 실행될 때 loginBean 이 없으면 오류 발생
			
//			return "loginForm";
			return "loginForm2";
			
		}
		
		@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
		public String login(@Valid LoginBean loginBean, BindingResult result) {
			if(result.hasErrors()) {
//				return "loginForm";
				return "loginForm2";
			}
			return "result";
			
		}
	}
	

