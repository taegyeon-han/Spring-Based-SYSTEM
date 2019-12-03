package com.freehoon.web.login.model;


public class IDVO {

	String ID_CARD_SERIAL;
	String name;
	String pwd;
	String re_pwd;
	String uid;
	String identifier;
	

	public String getID_CARD_SERIAL() {
		return ID_CARD_SERIAL;
	}
	
	public void setID_CARD_SERIAL(String iD_CARD_SERIAL) {
		ID_CARD_SERIAL = iD_CARD_SERIAL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRe_pwd() {
		return re_pwd;
	}
	public void setRe_pwd(String re_pwd) {
		this.re_pwd = re_pwd;
	}
	public String getUid() {
		uid= "4"+ID_CARD_SERIAL;
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	
	

	
}