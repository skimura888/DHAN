package jp.co.axiz.web.entity;

public class User {
	private Integer userId;
	private String userName;
	private String telephone;
	private String password;


	public User() {
	}

	public User(Integer userId, String userName, String telephone, String password) {
		this.userId = userId;
		this.userName = userName;
		this.telephone = telephone;
		this.password = password;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}

}
