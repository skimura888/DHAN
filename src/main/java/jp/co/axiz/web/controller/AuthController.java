package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

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
	public String index(@ModelAttribute("form") LoginForm form, Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("form") LoginForm form, Model model, HttpSession session) {
		String id =form.getId();
		String pass =form.getPass();

		Admin a = ls.findByIdAndPass(id, pass);
		if(a==null) {
			model.addAttribute("msg", "IDまたはPASSが間違っています");
		return "login";
		}

		String login = a.getAdminName();
		session.setAttribute("login", login);
		return "menu";
	}

	@RequestMapping(value = "/logout", method=RequestMethod.POST)
	public String logout(@ModelAttribute("form") LoginForm form, Model model, HttpSession session) {

		session.invalidate();
		return "logout";
	}


}
