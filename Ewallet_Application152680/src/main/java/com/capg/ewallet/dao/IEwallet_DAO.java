package com.capg.ewallet.dao;

import java.util.List;

import com.capg.ewallet.bean.Ewallet_AccountBean;

public interface IEwallet_DAO {
	
	int login(String user_name, String password) throws Exception;

	int createAccount(Ewallet_AccountBean adetails);

	int deposit(double amount);

	int withdraw(double amount);

	void showBalance(int account_number);

	int fundTransfer(int account_number, double amount);

	List printTransaction();


}
