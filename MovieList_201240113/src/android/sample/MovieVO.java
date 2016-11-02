package android.sample;

import java.io.Serializable;

/*
 * �� ����� ���� ������ ��ü�� ����� ����ϱ� ���� �ɹ� Ŭ���� ����
 */

public class MovieVO  implements Serializable  {
	
	private String m_Name;
	private String S_day;
	private String d_day;
	private String location;
	
	
	private static final long serialVersionUID = 1000000L;
	
	
	public String getM_Name() {
		return m_Name;
	}


	public void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}


	public String getS_day() {
		return S_day;
	}


	public void setS_day(String s_day) {
		S_day = s_day;
	}


	public String getD_day() {
		return d_day;
	}


	public void setD_day(String d_day) {
		this.d_day = d_day;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public static long getSerialversionuid() {
		  return serialVersionUID;
		 }
		
	
}
