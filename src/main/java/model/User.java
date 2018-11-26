package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_tbl")
public class User {
	@Column(name = "FirstName")
	private String firstname;

	@Column(name = "LastName")
	private String lastname;

	@Column(name = "EmailAdd")
	private String email;
	
	@Id
	@Column(name="PhoneNumber")
	private String phonenumber;
  
	@Column(name="Password")
	private String password;
	
	@Column(name = "Country")
	private String countryservicecode;
	
	@Column(name="auth_token")
	private String authtoken;

	public String getAuthtoken() {
		return authtoken;
	}
	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}
	public User() {
		super();
	}
   public User(String phoneNumber, String password) {
	   this.phonenumber=phoneNumber;
	   this.password=password;
   }
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCountryservicecode() {
	return countryservicecode;
}
public void setCountryservicecode(String countryservicecode) {
	this.countryservicecode = countryservicecode;
} 


}
