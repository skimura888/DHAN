package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.entity.LoginForm;
import jp.co.axiz.web.service.LoginService;

@Controller
public class AuthController {

	@Autowired
	LoginService ls;

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String index(@ModelAttribute("loginForm") LoginForm form, Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") LoginForm form, Model model) {
		String id =form.getId();
		String pass =form.getPass();

		Admin a = ls.findByIdAndPass(id, pass);
		if(a==null) {
		return "login";
		}

		return "menu";
	}


}
