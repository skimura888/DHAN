package jp.co.axiz.web.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.User;

@Repository
public class UserDaoImpl implements UserDao{


	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SQL_SELECT_ALL = "SELECT * FROM user_info";
	private static final String SQL_SELECT_ID = "SELECT * FROM user_info WHERE user_id = ?";
	private static final String SQL_SELECT_NAME = "SELECT * FROM user_info WHERE user_name = ?";
	private static final String SQL_SELECT_TEL = "SELECT * FROM user_info WHERE telephone = ?";
	private static final String SQL_SELECT_ID_NAME = "SELECT * FROM user_info WHERE user_id = ? AND user_name = ?";
	private static final String SQL_SELECT_ID_TEL = "SELECT * FROM user_info WHERE user_id = ? AND telephone = ?";
	private static final String SQL_SELECT_NAME_TEL = "SELECT * FROM user_info WHERE user_name = ? AND telephone = ?";
	private static final String SQL_SELECT_ID_NAME_TEL = "SELECT * FROM user_info WHERE user_id = ? AND user_name = ? AND telephone = ?";
	private static final String SQL_SELECT_MAX = "SELECT MAX(user_id) FROM user_info";

	private static final String SQL_INSERT = "INSERT INTO user_info(user_name, telephone, password) VALUES(?, ?, ?)";

	private static final String SQL_UPDATE = "UPDATE user_info SET user_name = ?, telephone = ?, password = ? WHERE user_id = ?";

	private static final String SQL_DELETE = "DELETE FROM user_info WHERE user_id = ?";

	private Connection connection;


	public List<User> findAll() {
		List<User> list = jdbcTemplate.query(SQL_SELECT_ALL,
				new BeanPropertyRowMapper<User>(User.class));

		return list;
	}

	public List<User> findById(Integer id) {
		List<User> list = jdbcTemplate.query(SQL_SELECT_ID,
				new BeanPropertyRowMapper<User>(User.class),
				id);

		return list;
	}

	public List<User> findByName(String name) {
		List<User> list = jdbcTemplate.query(SQL_SELECT_NAME,
				new BeanPropertyRowMapper<User>(User.class),
				name);
		return list;
	}

	public List<User> findByTel(String tel) {
		List<User> list = jdbcTemplate.query(SQL_SELECT_TEL,
				new BeanPropertyRowMapper<User>(User.class),
				tel);
		return list;
	}

	public List<User> findByIdName(Integer id, String name) {
		List<User> list = jdbcTemplate.query(SQL_SELECT_ID_NAME,
				new BeanPropertyRowMapper<User>(User.class),
				id,
				name);
		return list;
	}

	public List<User> findByIdTel(Integer id, String tel) {
		List<User> list = jdbcTemplate.query(SQL_SELECT_ID_TEL,
				new BeanPropertyRowMapper<User>(User.class),
				id,
				tel);
		return list;
	}

	public List<User> findByNameTel(String name, String tel) {
		List<User> list = jdbcTemplate.query(SQL_SELECT_NAME_TEL,
				new BeanPropertyRowMapper<User>(User.class),
				name,
				tel);
		return list;
	}

	public List<User> findByIdNameTel(Integer id, String name, String tel) {
		List<User> list = jdbcTemplate.query(SQL_SELECT_ID_NAME_TEL,
				new BeanPropertyRowMapper<User>(User.class),
				id,
				name,
				tel);
		return list;
	}

	public Integer findMax() {

		return null;
	}

	public void insert(String name, String tel, String pass) {
		return;
	}

	public void update(String name, String tel, String pass, Integer id) {
		return;
	}

	public void delete(Integer id) {
		return;
	}
}
