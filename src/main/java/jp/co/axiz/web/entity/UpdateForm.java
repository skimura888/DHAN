package jp.co.axiz.web.entity;

public class UpdateForm {

	private Integer id;
	private String name;
	private String tel;
	private String pass;

	private String forName;
	private String forTel;
	private String forPass;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getForName() {
		return forName;
	}
	public void setForName(String forName) {
		this.forName = forName;
	}
	public String getForTel() {
		return forTel;
	}
	public void setForTel(String forTel) {
		this.forTel = forTel;
	}
	public String getForPass() {
		return forPass;
	}
	public void setForPass(String forPass) {
		this.forPass = forPass;
	}
}
