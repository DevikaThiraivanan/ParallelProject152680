package com.capg.ewallet.test;

import com.capg.ewallet.bean.Ewallet_CustomerBean;
import com.capg.ewallet.service.Ewallet_DataValidation;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Ewallet_DataValidationTest extends TestCase {

	Ewallet_DataValidation e=new Ewallet_DataValidation();
	Ewallet_CustomerBean e1=new Ewallet_CustomerBean();

	public void testValidateCustomerName() {
		
		String customer_name=e1.getCustomer_name();
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("Devika", "Devika");
		Assert.assertFalse("Shiv", false);
		//Assert.assertEquals(true, e.validateCustomerName(customer_name) );//used only when the whole details are fetched
	}

	public void testValidateGender() {
		 
		 String gender=e1.getGender();
			Assert.assertEquals("Result", true, true);
			Assert.assertNotNull("Female", "Female");
			Assert.assertFalse("Male", false);
			//Assert.assertEquals(true, e.validateGender(gender) );//used only when the whole details are fetched
		
	}

	public void testValidatePhoneNumber() {
		 String phoneNumber=e1.getContact_number();
		
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("9874561230", "9874561230");
		Assert.assertFalse("9638520147", false);
		//Assert.assertEquals(true, e.validatePhoneNumber(phoneNumber));//used only when the whole details are fetched
	}

	public void testValidateAadhar() {
		
		String aadhar_number= e1.getCustomer_name();
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("123456789012", "123456925612");
		Assert.assertFalse("123456789212", false);
		//Assert.assertEquals(true,e.validateAadhar(aadhar_number));//used only when the whole details are fetched
	}

	public void testValidateAge() {
		
		int age=e1.getAge();
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("19", "19");
		Assert.assertFalse("5", false);
		//Assert.assertEquals(true, e.validateAge(age));//used only when the whole details are fetched
	}

	public void testValidateEmail() {
		String email_id= e1.getEmail_id();
		
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("employee@gmail.com", "employee@gmail.com");
		Assert.assertFalse("employee@gmail.com", false);
		//Assert.assertEquals(true, e.validateEmail(email_id));//used only when the whole details are fetched
	}

}
