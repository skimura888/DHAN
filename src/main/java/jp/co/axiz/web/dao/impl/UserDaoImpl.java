package jp.co.axiz.web.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.entity.UserMax;

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


	public List<UserInfo> findAll() {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_ALL,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return list;
	}

	public List<UserInfo> findById(Integer id) {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_ID,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				id);

		return list;
	}

	public List<UserInfo> findByName(String name) {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_NAME,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				name);
		return list;
	}

	public List<UserInfo> findByTel(String tel) {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_TEL,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				tel);
		return list;
	}

	public List<UserInfo> findByIdName(Integer id, String name) {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_ID_NAME,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				id,
				name);
		return list;
	}

	public List<UserInfo> findByIdTel(Integer id, String tel) {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_ID_TEL,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				id,
				tel);
		return list;
	}

	public List<UserInfo> findByNameTel(String name, String tel) {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_NAME_TEL,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				name,
				tel);
		return list;
	}

	public List<UserInfo> findByIdNameTel(Integer id, String name, String tel) {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_ID_NAME_TEL,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				id,
				name,
				tel);
		return list;
	}

	public Integer findMax() {
		List<UserMax> list = jdbcTemplate.query(SQL_SELECT_MAX,
				new BeanPropertyRowMapper<UserMax>(UserMax.class));
		UserMax um = list.get(0);

		return um.getMax();
	}

	public void insert(String name, String tel, String pass) {
		jdbcTemplate.update(SQL_INSERT,
				name,
				tel,
				pass);
	}

	public void update(String name, String tel, String pass, Integer id) {
		jdbcTemplate.update(SQL_UPDATE,
				name,
				tel,
				pass,
				id);

		return;
	}

	public void delete(Integer id) {
		jdbcTemplate.update(SQL_DELETE,
				id);

		return;
	}
}
