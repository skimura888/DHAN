package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}
	@RequestMapping("/menu")
	public String menu(Model model) {
		return "menu";
	}
}
