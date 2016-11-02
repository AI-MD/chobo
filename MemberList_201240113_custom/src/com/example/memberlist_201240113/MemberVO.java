package com.example.memberlist_201240113;

import java.io.Serializable;

/*
 * 각 멤버에 대한 정보를 객체로 만들어 사용하기 위해 맴버 클래스 만듬
 */

public class MemberVO  implements Serializable  {
	private String name;
	private String addr;
	private String phoneNum;
	
	
	private static final long serialVersionUID = 1000000L;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public static long getSerialversionuid() {
		  return serialVersionUID;
		 }
		
	
}
