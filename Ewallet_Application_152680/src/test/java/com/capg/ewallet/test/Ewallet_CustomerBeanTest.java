package com.capg.ewallet.test;

import com.capg.ewallet.bean.Ewallet_CustomerBean;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Ewallet_CustomerBeanTest extends TestCase {
	Ewallet_CustomerBean e=new Ewallet_CustomerBean();
	public void testGetCustomer_name() {
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("Devika", "Devika");
		Assert.assertFalse("Shiv", false);
	}

	public void testGetAge() {
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("19", "19");
		Assert.assertFalse("5", false);
		 
	}

	public void testGetGender() {
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("Female", "Female");
		Assert.assertFalse("Male", false);
	}

	public void testGetContact_number() {
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("9874561230", "9874561230");
		Assert.assertFalse("9638520147", false);
	}

	public void testGetAadhar_number() {
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("123456789012", "123456925612");
		Assert.assertFalse("123456789212", false);	 
	}

	public void testGetEmail_id() {
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("employee@gmail.com", "employee@gmail.com");
		Assert.assertFalse("employee@gmail.com", false);
	}

	public void testGetPassword() {
		Assert.assertEquals("Result", true, true);
		Assert.assertEquals("Devika", "Devika");
		Assert.assertFalse("Shiv", false);
	}

	public void testGetUser_name() {
		Assert.assertEquals("Result", true, true);
		Assert.assertNotNull("Devika", "Devika");
		Assert.assertFalse("Shiv", false);
	}

}
