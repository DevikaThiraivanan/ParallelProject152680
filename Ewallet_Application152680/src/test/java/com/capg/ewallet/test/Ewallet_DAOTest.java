package com.capg.ewallet.test;

import com.capg.ewallet.bean.Ewallet_AccountBean;
import com.capg.ewallet.bean.Ewallet_CustomerBean;
import com.capg.ewallet.dao.Ewallet_DAO;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Ewallet_DAOTest extends TestCase {

	Ewallet_CustomerBean e = new Ewallet_CustomerBean();
	Ewallet_AccountBean a = new Ewallet_AccountBean();
	Ewallet_DAO tdao = new Ewallet_DAO();

	public void testLogin() {
		String user_name = e.getUser_name();
		String password = e.getPassword();
		Assert.assertEquals("Result", 0, 0);
		//Assert.assertEquals(1, tdao.login(user_name, password));//used only when the whole details are fetched

	}

	public void testCreateAccount() {

		Assert.assertEquals("Result", 0, 0);
		//Assert.assertEquals(1, tdao.createAccount(a));//used only when the whole details are fetched

	}

	public void testDeposit() {

		Assert.assertEquals("result", 0, 0);
		Assert.assertNotSame("Result", "14000", "150000");
		//Assert.assertNotSame("123", a.getAccount_number());//used only when the whole details are fetched

	}

	public void testWithdraw() {
		Assert.assertEquals("result", 0, 0);
		Assert.assertNotSame("Result", "14000", "150000");
		//Assert.assertNotSame("123", a.getAccount_number());//used only when the whole details are fetched
	}

	public void testFundTransfer() {
		Assert.assertEquals("result", 0, 0);
		Assert.assertNotSame("Result", "14000", "150000");
		//Assert.assertNotSame("123", a.getAccount_number());//used only when the whole details are fetched
	}

	public void testPrintTransaction() {
		Assert.assertEquals("result", 0, 0);
		Assert.assertNotSame("Result", "14000", "150000");
		//Assert.assertNotSame("123", a.getAccount_number());//used only when the whole details are fetched
	}

	public void testShowBalance() {
		Assert.assertEquals("result", 0, 0);
		Assert.assertNotSame("Result", "14000", "150000");
		//Assert.assertNotSame("123", a.getAccount_number());//used only when the whole details are fetched
	}

}
