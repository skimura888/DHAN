package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.UserInfo;

public interface UpdateService {

	public UserInfo findById(Integer id);

	public void update(UserInfo ui);


}
