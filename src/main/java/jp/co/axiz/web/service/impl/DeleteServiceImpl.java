package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService{

@Autowired
UserDao ud;

	public UserInfo findById(Integer id) {
		List<UserInfo> list = ud.findById(id);
		if(list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	public void delete(Integer id) {
		ud.delete(id);
		return;
	}
}
