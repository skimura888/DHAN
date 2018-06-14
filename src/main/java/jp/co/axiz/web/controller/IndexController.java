package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.entity.LoginForm;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(@ModelAttribute("form") LoginForm form, Model model) {
		return "index";
	}
	@RequestMapping("/menu")
	public String menu(@ModelAttribute("form") LoginForm form, Model model) {
		return "menu";
	}
}
