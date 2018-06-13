package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.AdminDao;
import jp.co.axiz.web.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_SELECT_ID_PASS = "SELECT * FROM admin WHERE admin_id = ? AND password = ?";

	@Override
	public Admin findByIdAndPass(String id, String pass) {
		List<Admin> list = jdbcTemplate.query(SQL_SELECT_ID_PASS,
				new BeanPropertyRowMapper<Admin>(Admin.class),
				id,
				pass);

		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}
}
