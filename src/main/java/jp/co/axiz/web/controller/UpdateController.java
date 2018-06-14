package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.UpdateForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UpdateService;

@Controller
public class UpdateController {

	@Autowired
	UpdateService us;

	@RequestMapping(value="/update", method =RequestMethod.GET)
	public String jump(@ModelAttribute("form") UpdateForm form, Model model) {
		return "update";
	}

	@RequestMapping(value="/update", method =RequestMethod.POST)
	public String update(@ModelAttribute("form") UpdateForm form, Model model, HttpSession session) {
		Integer id =form.getId();
		UserInfo u = us.findById(id);
		if(u==null) {
			return "update";
		}

		UserInfo afterUser = new UserInfo();
		afterUser.setUserId(u.getUserId());
		afterUser.setUserName(u.getUserName());
		afterUser.setTelephone(u.getTelephone());
		afterUser.setPassword(u.getPassword());

		session.setAttribute("beforeUser", u);
		session.setAttribute("afterUser", afterUser);


		return "updateInput";


	}

	@RequestMapping(value="/updateInput", method =RequestMethod.POST)
	public String updateInput(@ModelAttribute("form") UpdateForm form, Model model, HttpSession session) {
		String newName = form.getName();
		String newTel = form.getTel();
		String newPass = form.getPass();

		UserInfo afterUser = (UserInfo) session.getAttribute("afterUser");

		String errmsg = null;

		if (newPass == null || newPass.isEmpty()) {
			errmsg = "PASSは必須です";
		} else {
			afterUser.setPassword(newPass);
		}

		if (newTel == null || newTel.isEmpty()) {
			errmsg = "TELは必須です";
		} else {
			afterUser.setTelephone(newTel);
		}

		if (newName == null || newName.isEmpty()) {
			errmsg = "名前は必須です";
		} else {
			afterUser.setUserName(newName);
		}

		if (errmsg != null) {
			model.addAttribute("errmsg", errmsg);
			return "updateInput";
		}

		UserInfo beforeUser = (UserInfo) session.getAttribute("beforeUser");
		boolean isName=beforeUser.getUserName().equals(afterUser.getUserName());
		boolean isTel =beforeUser.getTelephone().equals(afterUser.getTelephone());
		boolean isPass =beforeUser.getPassword().equals(afterUser.getPassword());


		if (isName && isTel && isPass) {
			model.addAttribute("msg", "１項目以上変更してください");
			return "updateInput";
		}
		if (isPass) {
			model.addAttribute("rePass", afterUser.getPassword());
		}

		return "updateConfirm";
	}

	@RequestMapping(value="/updateConfirm", method =RequestMethod.POST)
	public String updateConfirm(@ModelAttribute("form") UpdateForm form, Model model, HttpSession session) {
		String rePass = form.getPass();
		UserInfo afterUser = (UserInfo) session.getAttribute("afterUser");

		if (!afterUser.getPassword().equals(rePass)) {
			model.addAttribute("msg", "前画面で入力したパスワードと一致しません");
			return "updateConfirm";
		}

		us.update(afterUser);

		session.removeAttribute("beforeUser");
		session.removeAttribute("afterUser");

		return "updateResult";
	}
}
