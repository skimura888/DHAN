package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.UserInfo;

public interface UserDao {
	public List<UserInfo> findAll();
	public List<UserInfo> findById(Integer id);
	public List<UserInfo> findByName(String name);
	public List<UserInfo> findByTel(String tel);
	public List<UserInfo> findByIdName(Integer id, String name);
	public List<UserInfo> findByIdTel(Integer id, String tel);
	public List<UserInfo> findByNameTel(String name, String tel);
	public List<UserInfo> findByIdNameTel(Integer id, String name, String tel);
	public Integer findMax();

	public void insert(String name, String tel, String pass);

	public void update(String name, String tel, String pass, Integer id);

	public void delete(Integer id);

}
