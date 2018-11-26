package config;

import java.io.Serializable;

public class JsonFormatter implements Serializable{
	private static final long serialVersionUID = 1L;
	private int status;
	private String token;
	private String phone;
	private String name;
	private String country;

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JsonFormatter(int status, String token, String phone, String name, String country) {
		this.status=status;
		this.token=token;
		this.phone = phone;
		this.name = name;
		this.country = country;
	}
	
	
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
