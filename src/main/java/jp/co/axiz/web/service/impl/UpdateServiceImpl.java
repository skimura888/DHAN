package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService{

	@Autowired
	UserDao ud;

	@Override
	public UserInfo findById(Integer id) {
		List<UserInfo> userInfo = ud.findById(id);

		if(userInfo.size()!=0) {
			UserInfo u = userInfo.get(0);
			return u;
		}

		return null;
	}


	@Override
	public void update(UserInfo ui) {
		String name = ui.getUserName();
		String tel = ui.getTelephone();
		String pass = ui.getPassword();
		Integer id = ui.getUserId();
		ud.update(name, tel, pass, id);
		return;
	}
}
