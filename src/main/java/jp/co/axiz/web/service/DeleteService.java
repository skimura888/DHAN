package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.UserInfo;

public interface DeleteService {
	public UserInfo findById(Integer id);
	public void delete(Integer id);
}
