package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.service.InsertService;

@Service
public class InsertServiceImpl implements InsertService{

	@Autowired
	UserDao ud;

	public void insert(String name, String tel, String pass) {
		ud.insert(name, tel, pass);
	}
}
