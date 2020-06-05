package com.spring.mvc;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {
	
	@Size(min=1, max=10, message="1~10자로 입력하세요.")
	private String id;
	
	@NotEmpty(message="필수 입력 항목입니다.")
	private String pwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
