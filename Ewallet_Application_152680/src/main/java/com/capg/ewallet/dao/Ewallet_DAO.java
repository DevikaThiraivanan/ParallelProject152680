package com.capg.ewallet.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capg.ewallet.bean.Ewallet_AccountBean;

public class Ewallet_DAO implements IEwallet_DAO {

	double balance;
	int flag = 0;
	Ewallet_AccountBean adetails = new Ewallet_AccountBean();
	public static Map<Integer, Ewallet_AccountBean> map = new HashMap<Integer, Ewallet_AccountBean>();
	public static List<String> transactions = new ArrayList<String>();

	public int login(String user_name, String password) {

		for (Integer key : map.keySet()) {
			adetails = map.get(key);

			if (adetails.getDetails().getUser_name().equals(user_name)&& adetails.getDetails().getPassword().equals(password)) {
				return 1;
			}

		}

		return 0;

	}

	public int createAccount(Ewallet_AccountBean adetails) {

		map.put(adetails.getAccount_number(), adetails);
		System.out.println(map.toString());
		for (Integer key : map.keySet()) {
			System.out.println("key" + key);
		}
		for (Ewallet_AccountBean value : map.values()) {
			System.out.println("value=" + value.getAccount_number() + " " + value.getBalance());
		}

		return 1;
	}

	public int deposit(double amount) {

		balance = adetails.getBalance() + amount;
		adetails.setBalance(balance);

		System.out.println("Your Balance Is" + adetails.getBalance());
		System.out.println(adetails.getBalance());
		String deposit = "the amount" + amount + "is deposited";
		transactions.add(deposit);
		return 1;

	}

	public int withdraw(double amount) {

		balance = adetails.getBalance() - amount;
		adetails.setBalance(balance);

		System.out.println("Your Balance Is" + adetails.getBalance());
		System.out.println(adetails.getBalance());
		String withdraw = "the amount" + amount + "withdrawn";
		transactions.add(withdraw);

		return 0;
	}

	public int fundTransfer(int account_number, double amount) {
		for (Integer key : map.keySet()) {
			adetails = map.get(key);
			if (adetails.getAccount_number() == account_number) {
				balance = adetails.getBalance() + amount;
				adetails.setBalance(balance);
				flag = 1;
			}
			if (flag == 0) {
				balance = adetails.getBalance() - amount;
				adetails.setBalance(balance);
			}
		}
		String transfer = "the amount" + amount + "is transfered to accountnumber " + account_number;
		transactions.add(transfer);
		return 0;
	}

	public List printTransaction() {

		return transactions;
	}

	public void showBalance(int account_number) {

		for (Integer key : map.keySet()) {
			adetails = map.get(key);
			if (adetails.getAccount_number() == account_number) {
				System.out.println(adetails.getBalance());
			}

		}
		System.out.println(transactions);

	}
}
