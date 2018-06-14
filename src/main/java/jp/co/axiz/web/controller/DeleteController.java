package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.DeleteForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.DeleteService;

@Controller
public class DeleteController {

	@Autowired
	DeleteService ds;

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String jamp(@ModelAttribute("form") DeleteForm form, Model model) {
		return "delete";
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute("form") DeleteForm form, Model model, HttpSession session) {
		Integer id = form.getId();
		UserInfo ui = ds.findById(id);
		if(ui==null) {
			model.addAttribute("msg", "入力されたデータは存在しません");
			return "delete";
		}
		model.addAttribute("User", ui);

		return "deleteConfirm";
	}

	@RequestMapping(value="/deleteConfirm", method=RequestMethod.POST)
	public String deleteConfirm(@ModelAttribute("form") DeleteForm form, Model model, HttpSession session) {
		ds.delete(form.getId());
		session.removeAttribute("changeId");
		return "deleteResult";
	}
}
