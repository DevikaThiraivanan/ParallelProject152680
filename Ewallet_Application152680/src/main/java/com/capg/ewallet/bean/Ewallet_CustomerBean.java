package com.capg.ewallet.bean;

public class Ewallet_CustomerBean {
	
	private String customer_name;
	private int age;
	private String gender;
	private String contact_number;
	private long aadhar_number;
	private String email_id;
	private String password;
	private String user_name;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public long getAadhar_number() {
		return aadhar_number;
	}
	public void setAadhar_number(long aadhar_number) {
		this.aadhar_number = aadhar_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "Ewallet_CustomerBean [customer_name=" + customer_name + ", age=" + age + ", gender=" + gender
				+ ", contact_number=" + contact_number + ", aadhar_number=" + aadhar_number + ", email_id=" + email_id
				+ ", password=" + password + ", user_name=" + user_name + "]";
	}
	
	
	
	
	

}
