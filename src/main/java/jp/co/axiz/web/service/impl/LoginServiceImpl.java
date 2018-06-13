package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.impl.AdminDaoImpl;
import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AdminDaoImpl adi;

	@Override
	public Admin findByIdAndPass(String id, String pass) {
		Admin a = adi.findByIdAndPass(id, pass);

		if(a == null) {
			return null;
		}

		return a;

	}
}
