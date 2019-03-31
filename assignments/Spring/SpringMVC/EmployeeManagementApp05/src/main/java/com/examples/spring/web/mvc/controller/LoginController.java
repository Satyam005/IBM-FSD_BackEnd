package com.examples.spring.web.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.exception.LoginException;
import com.examples.spring.web.mvc.model.Login;
import com.examples.spring.web.mvc.model.User;

/**
 * Handles requests for the application login page.
 */
@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)	
	public ModelAndView login(Model model) {

		return new ModelAndView("login", "command", new Login());
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ExceptionHandler(LoginException.class)
	public ModelAndView authenticate(@ModelAttribute Login login, Model model, HttpSession session) {
		
		if(session.getAttribute("username")==null)
			throw new LoginException("Invalid User or Password");
		else {
			
			String username = (String)session.getAttribute("username");
			String password = (String)session.getAttribute("password");
			if(login.getUserName().equalsIgnoreCase(username) && login.getPassword().equalsIgnoreCase(password))
			{
//				logger.info("Authentication success");
//				session.setAttribute("userName", login.getUserName());
				//model.addAttribute("userName", "admin");
				return new ModelAndView("redirect:/employee/list");
			}
			else
			{
//				logger.info("Authentication failed");
				throw new LoginException("Invalid User or Password");
//				return new ModelAndView("redirect:/login");
			}
		}
		
	}	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus sessionStatus)
	{		
		sessionStatus.setComplete();
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.invalidate();
		return "redirect:/";
	}
}