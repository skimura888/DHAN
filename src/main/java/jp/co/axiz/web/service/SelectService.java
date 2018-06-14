package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.SelectForm;
import jp.co.axiz.web.entity.UserInfo;

public interface SelectService {
	public List<UserInfo> find(SelectForm form);
}
