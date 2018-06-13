package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.SelectForm;

@Controller
public class SelectController {
	@RequestMapping(value="/select", method =RequestMethod.GET)
	public String index(@ModelAttribute("selectForm") SelectForm form, Model model) {
		model.addAttribute("msg", "welcome");
		return "select";
	}
}
