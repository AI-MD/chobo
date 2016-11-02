package android.sample;

import java.io.Serializable;

/*
 * 각 멤버에 대한 정보를 객체로 만들어 사용하기 위해 맴버 클래스 만듬
 */

public class UserrVO  implements Serializable  {
	
	private String name;
	private String city;
	private String age;
	
	
	private static final long serialVersionUID = 1000000L;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public static long getSerialversionuid() {
		  return serialVersionUID;
		 }
		
	
}
