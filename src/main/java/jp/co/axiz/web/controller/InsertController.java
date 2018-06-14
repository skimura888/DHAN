package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.InsertForm;
import jp.co.axiz.web.service.InsertService;

@Controller
public class InsertController {


	@Autowired
	InsertService is;

	@RequestMapping(value="/insert", method =RequestMethod.GET)
	public String janp(@ModelAttribute("form") InsertForm form, Model model) {
		return "insert";
	}

	@RequestMapping(value="/insert", method =RequestMethod.POST)
	public String insert(@ModelAttribute("form") InsertForm form, Model model, HttpSession session) {
		String name = form.getName();
		String tel = form.getTel();
		String pass = form.getPass();

		if (name == null || name.isEmpty()) {
			model.addAttribute("msg", "必須項目を入力してください");
			return "insert";
		}
		if (tel == null || tel.isEmpty()) {
			model.addAttribute("msg", "必須項目を入力してください");
			return "insert";
		}
		if (pass == null || pass.isEmpty()) {
			model.addAttribute("msg", "必須項目を入力してください");
			return "insert";
		}

		session.setAttribute("form", form);
		return "insertConfirm";
	}

	@RequestMapping(value="/insertConfirm", method =RequestMethod.POST)
	public String insertConfirm(@ModelAttribute("form") InsertForm form, Model model, HttpSession session) {
		InsertForm beform = (InsertForm)session.getAttribute("form");
		String pass = beform.getPass();

		String name = form.getName();
		String tel = form.getTel();
		String rePass = form.getPass();

		if(pass.equals(rePass)) {
			is.insert(name, tel, rePass);
			Integer max = is.findMax();
			session.setAttribute("changeId", max);
			session.removeAttribute("form");
			return "insertResult";
		}
		model.addAttribute("msg", "パスワードが一致しませんでした");
		return "insertConfirm";
	}
}
