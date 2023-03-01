package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.LoginDao;
import com.domain.Login;


@Controller
public class LoginController {
	
	@Autowired
	LoginDao loginDao;
	
	@RequestMapping("/")
	public String loginPage() {
		return "login";
	}
	@RequestMapping(value = "/login")
	public String Authentication(@RequestParam("userName") String username , @RequestParam("password") String password, Model m) {
		
		List<Login> login = loginDao.UserExist(username, password);
		System.out.println(login);
		if(login.isEmpty()) {
			m.addAttribute("user", username);
			return "login";
		}else {
			m.addAttribute("user",username);
			return "homepage";
		}
	}
}
