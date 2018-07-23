package com.capg.ewallet.bean;

public class Ewallet_AccountBean {

	private int account_number;
    private double balance;
    private Ewallet_CustomerBean details;
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Ewallet_CustomerBean getDetails() {
		return details;
	}
	public void setDetails(Ewallet_CustomerBean details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Ewallet_AccountBean [account_number=" + account_number + ", balance=" + balance + ", details=" + details
				+ "]";
	}
    
	
	
}
