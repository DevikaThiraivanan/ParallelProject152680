package com.capg.ewallet.test;

import com.capg.ewallet.bean.Ewallet_AccountBean;
import com.capg.ewallet.bean.Ewallet_CustomerBean;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Ewallet_AccountBeanTest extends TestCase {
	 
	Ewallet_AccountBean a = new Ewallet_AccountBean();
	public void testGetAccount_number() {
		 
		String account_number="1234569870";
		Assert.assertEquals("1234569870", account_number);
		Assert.assertEquals("Result", 0, 0);
		Assert.assertNotSame("123", a.getAccount_number());

		
	}

	public void testGetBalance() {
		 
		String balance="2000";
		Assert.assertEquals("2000", balance);
		Assert.assertEquals("Result", 0, 0);
		Assert.assertNotSame("1000", a.getBalance());
		
		
	}

	public void testGetDetails() {
		 
		Assert.assertEquals("Result", true, true);
		Assert.assertEquals("Result", 0, 0);
		Assert.assertNotSame("1000", a.getDetails());
		
	}

}
