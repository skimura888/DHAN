package jp.co.axiz.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.SelectForm;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.SelectService;

@Repository
public class SelectServiceImpl implements SelectService{

	@Autowired
	UserDao ud;

	@Override
	public List<User> find(SelectForm form) {
		String id = form.getUserId();
		String name = form.getUserName();
		String tel = form.getTelephone();
		Integer uid = 0;

		boolean isId = false;
		boolean isName = false;
		boolean isTel = false;

		if(!("".equals(id))) {
			isId = true;
			uid = Integer.parseInt(id);
		}
		if(!("".equals(name))) {
			isName = true;
		}
		if(!("".equals(tel))) {
			isTel = true;
		}

		List<User> list = new ArrayList<User>();
		if(isId && isName && isTel) {
			list = ud.findByIdNameTel(uid, name, tel);
		}else if(isId && isName) {
			list = ud.findByIdName(uid, name);
		}else if(isId && isTel) {
			list = ud.findByIdTel(uid, tel);
		}else if(isName && isTel) {
			list = ud.findByNameTel(name, tel);
		}else if(isId) {
			list = ud.findById(uid);
		}else if(isName) {
			list = ud.findByName(name);
		}else if(isTel) {
			list = ud.findByTel(tel);
		}else {
			list = ud.findAll();
		}

		return list;

	}
}
