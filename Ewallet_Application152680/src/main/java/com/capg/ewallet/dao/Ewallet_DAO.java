package com.capg.ewallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capg.ewallet.bean.Ewallet_AccountBean;
import com.capg.ewallet.bean.Ewallet_CustomerBean;

public class Ewallet_DAO implements IEwallet_DAO {

	Ewallet_AccountBean adetails = new Ewallet_AccountBean();
	Ewallet_CustomerBean details = new Ewallet_CustomerBean();

	public static List<String> transactions = new ArrayList<String>();

	static int accnum;
	int account_num;
	double balance;
 String detail;
	public int login(String user_name, String password) {
		Connection conn = JdbcUtil.getConnection();

		try {

			String q = "SELECT ewallet_customerbean.user_name,ewallet_customerbean.password,ewallet_customerbean.account_number from ewallet_customerbean,ewallet_accountbean where ewallet_customerbean.account_number=ewallet_accountbean.account_number";
			Statement p = conn.createStatement();

			ResultSet r = p.executeQuery(q);

			while (r.next()) {
				String username = r.getString("user_name");
				String pw = r.getString("password");

				if (username.equals(user_name) && pw.equals(password))

					accnum = r.getInt("account_number");

				return 1;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public int createAccount(Ewallet_AccountBean adetails) {

		try {

			Connection connect = JdbcUtil.getConnection();

			PreparedStatement preparedStatement = connect
					.prepareStatement("insert into  ewallet_customerbean values (?,?,?,?,?,?,?,?,?)");

			PreparedStatement preparedStatement1 = connect
					.prepareStatement("insert into  ewallet_accountbean values (?,?)");

			// Parameters start with 1
			preparedStatement1.setInt(2, adetails.getAccount_number());
			preparedStatement1.setDouble(1, adetails.getBalance());

			preparedStatement.setString(1, adetails.getDetails().getCustomer_name());
			preparedStatement.setInt(2, adetails.getDetails().getAge());
			preparedStatement.setLong(3, adetails.getDetails().getAadhar_number());
			preparedStatement.setString(4, adetails.getDetails().getGender());
			preparedStatement.setString(5, adetails.getDetails().getContact_number());
			preparedStatement.setString(6, adetails.getDetails().getEmail_id());
			preparedStatement.setString(7, adetails.getDetails().getPassword());
			preparedStatement.setString(8, adetails.getDetails().getUser_name());
			preparedStatement.setInt(9, adetails.getAccount_number());

			preparedStatement.execute();

			preparedStatement1.execute();

			connect.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 1;
	}

	public int deposit(double amount) {
		Connection connect = JdbcUtil.getConnection();

		account_num = accnum;

		try {

			String Query = "update ewallet_accountbean SET balance=balance+? where account_number=?";
			PreparedStatement preparestatement;
			preparestatement = connect.prepareStatement(Query);
			preparestatement.setDouble(1, amount);
			preparestatement.setInt(2, account_num);
			preparestatement.execute();

			connect.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		/*
		 * System.out.println( "Amount:"+amount+"Is Desposited"); String
		 * damount="Amount:"+amount+"Is Desposited"; transactions.add(damount);
		 */

		return 1;

	}

	public int withdraw(double amount) {

		Connection connect = JdbcUtil.getConnection();
		account_num = accnum;
		try {

			Statement st = connect.createStatement();
			String Query = "Select * from ewallet_accountbean where account_number='" + account_num + "'";
			ResultSet r = st.executeQuery(Query);

			while (r.next()) {
				balance = r.getDouble("balance");
			}

			if (balance > amount) {

				String Query2 = "update ewallet_accountbean SET balance=balance-? where account_number=?";
				PreparedStatement preparestatement;
				preparestatement = connect.prepareStatement(Query2);
				preparestatement.setDouble(1, amount);
				preparestatement.setInt(2, account_num);
				preparestatement.execute();

				connect.close();
				return 0;
			} else {
				System.out.println("INSUFFICIENT BALANCE");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 1;
	}

	public void showBalance(int account_number) {
		Connection connect = JdbcUtil.getConnection();
		account_num = accnum;

		try {
			Statement st = connect.createStatement();
			String Query = "Select * from ewallet_accountbean where account_number='" + account_num + "'";
			ResultSet r = st.executeQuery(Query);

			while (r.next())

			{
				balance = r.getDouble("balance");
			}

			System.out.println("BALANCE IS:" + balance);
			connect.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int fundTransfer(int account_number, double amount) {

		Connection connect = JdbcUtil.getConnection();
		account_num = accnum;

		try {

			String fundtrans = " THE AMOUNT" + amount + "IS TRANSFERRED TO"+ account_number;
			String insertfundtransactions="INSERT INTO Transaction values(?,?)";
			
			
			
			String Query = "update ewallet_accountbean SET balance=balance+? where account_number=?";

			PreparedStatement preparestatement;
			preparestatement = connect.prepareStatement(Query);
			preparestatement.setDouble(1, amount);
			preparestatement.setInt(2, account_number);
			preparestatement.executeUpdate();

			Statement st = connect.createStatement();
			String Query2 = "Select * from ewallet_accountbean where account_number='" + account_num + "'";
			ResultSet r = st.executeQuery(Query2);

			while (r.next()) {
				balance = r.getDouble("balance");
			}

			if (balance > amount) {

				String Query3 = "update ewallet_accountbean SET balance=balance-? where account_number=?";

				preparestatement = connect.prepareStatement(Query3);
				preparestatement.setDouble(1, amount);
				preparestatement.setInt(2, account_num);
				preparestatement.execute();

				connect.close();
				return 0;
			} else {
				System.out.println("TRANSFER FAILED");
			}

			PreparedStatement	preparestatement1=connect.prepareStatement(insertfundtransactions);
			preparestatement1.setLong(1, account_number);
			preparestatement1.setString(2, fundtrans);
			preparestatement1.execute();

			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public List printTransaction() {

		Connection connect = JdbcUtil.getConnection();
		account_num = accnum;
		try {
			Statement st = connect.createStatement();
			String Query = "select * from ewallet_transactiondetails where account_number='" + account_num + "'";
			
			ResultSet r = st.executeQuery(Query);
			
			
			while(r.next())
			{
				detail= r.getString("transaction_details");
				System.out.println("the transactions are \n" + details);
			}
			
			
		}catch (SQLException e) {
			 
			e.printStackTrace();
			
		}
			
		
		
		return null;
	}

}
