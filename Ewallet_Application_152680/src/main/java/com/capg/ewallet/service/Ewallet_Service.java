package com.capg.ewallet.service;

import java.util.List;

import com.capg.ewallet.bean.Ewallet_AccountBean;
import com.capg.ewallet.dao.Ewallet_DAO;

public class Ewallet_Service implements IEwallet_Service {
	Ewallet_DAO dao = new Ewallet_DAO();

	public int login(String user_name, String password) {

		return dao.login(user_name, password);
	}

	public int createAccount(Ewallet_AccountBean adetails) {

		return dao.createAccount(adetails);
	}

	public int deposit(double amount) {

		return dao.deposit(amount);
	}

	public int withdraw(double amount) {

		return dao.withdraw(amount);
	}

	public int fundTransfer(int account_number, double amount) {

		return dao.fundTransfer(account_number, amount);
	}

	public List printTransaction() {

		return dao.printTransaction();
	}

	public void showBalance(int account_number) {

		dao.showBalance(account_number);

	}

}
