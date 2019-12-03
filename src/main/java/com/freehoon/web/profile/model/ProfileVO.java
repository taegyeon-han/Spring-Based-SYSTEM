package com.freehoon.web.profile.model;

public class ProfileVO 
{
	String ID_CARD_SERIAL;
	String DEPARTMENT; //부서
	String POSITION; //직책
	String LEVEL; //공무원 급수
	String TELEP_HONE;
	String HAND_PHONE;
	String EMAIL;
	String ADDRESS;
	String STATUS; //재직 휴직 상태 
	String REASON; //휴직 중이면 휴직 사유
	String WOR_KDATE;
	String END_WORK_DATE;
	String BIRTH;
	String name;
	String person_image;
	String JOBS;
	String identifier;
	
	public String getID_CARD_SERIAL() {
		return ID_CARD_SERIAL;
	}
	public void setID_CARD_SERIAL(String iD_CARD_SERIAL) {
		ID_CARD_SERIAL = iD_CARD_SERIAL;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public String getPOSITION() {
		return POSITION;
	}
	public void setPOSITION(String pOSITION) {
		POSITION = pOSITION;
	}
	public String getLEVEL() {
		return LEVEL;
	}
	public void setLEVEL(String lEVEL) {
		LEVEL = lEVEL;
	}
	public String getTELEP_HONE() {
		return TELEP_HONE;
	}
	public void setTELEP_HONE(String tELEP_HONE) {
		TELEP_HONE = tELEP_HONE;
	}
	public String getHAND_PHONE() {
		return HAND_PHONE;
	}
	public void setHAND_PHONE(String hAND_PHONE) {
		HAND_PHONE = hAND_PHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getREASON() {
		return REASON;
	}
	public void setREASON(String rEASON) {
		REASON = rEASON;
	}
	public String getWOR_KDATE() {
		return WOR_KDATE;
	}
	public void setWOR_KDATE(String wOR_KDATE) {
		WOR_KDATE = wOR_KDATE;
	}
	public String getEND_WORK_DATE() {
		return END_WORK_DATE;
	}
	public void setEND_WORK_DATE(String eND_WORK_DATE) {
		END_WORK_DATE = eND_WORK_DATE;
	}
	public String getBIRTH() {
		return BIRTH;
	}
	public void setBIRTH(String bIRTH) {
		BIRTH = bIRTH;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPerson_image() {
		return person_image;
	}
	public void setPerson_image(String person_image) {
		this.person_image = person_image;
	}
	public String getJOBS() {
		return JOBS;
	}
	public void setJOBS(String jOBS) {
		JOBS = jOBS;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	
	
}