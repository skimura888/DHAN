package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.User;

public interface UserDao {
	public List<User> findAll();
	public List<User> findById(Integer id);
	public List<User> findByName(String name);
	public List<User> findByTel(String tel);
	public List<User> findByIdName(Integer id, String name);
	public List<User> findByIdTel(Integer id, String tel);
	public List<User> findByNameTel(String name, String tel);
	public List<User> findByIdNameTel(Integer id, String name, String tel);
	public Integer findMax();

	public void insert(String name, String tel, String pass);

	public void update(String name, String tel, String pass, Integer id);

	public void delete(Integer id);

}
