package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.SelectForm;
import jp.co.axiz.web.entity.User;

public interface SelectService {
	public List<User> find(SelectForm form);
}
