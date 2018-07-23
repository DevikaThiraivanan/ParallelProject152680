package com.capg.ewallet.service;

public class Ewallet_DataValidation {

	
	public boolean  validateCustomerName(String customer_name)
	{
		if(customer_name!=null)
		{
			return true;
		}
		else {
		return false;
	}}
	
	
	public boolean  validateGender(String gender)
	{
		if(gender.equals("Male")||gender.equals("Female"))
		{
			return true;
		}
		else {
		return false;
	}}
	public boolean  validatePhoneNumber(String contact_number)
	{
		if(contact_number.length()==10)
		{
			return true;
		}
		else {
		return false;
	}}
	
	public boolean  validateAadhar(String aadhar_number)
	{
		if(aadhar_number.length()==12)
		{
			return true;
		}
		else {
		return false;
	}}
	
	public boolean validateAge(int age)  
	{
		if(age!=0)
		{
			return true;
		}
		else {
		return false;
	}}
	public boolean validateEmail(String email_id)  
	{
		if(email_id.endsWith((".com")))
		{
			return true;
		}
		else {
		return false;
	}}

	
	
}
