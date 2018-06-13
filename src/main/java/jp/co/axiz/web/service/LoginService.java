package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.Admin;

public interface LoginService {
	public Admin findByIdAndPass(String id, String pass) ;
}
