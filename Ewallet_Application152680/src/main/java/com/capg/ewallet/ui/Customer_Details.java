package com.capg.ewallet.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import com.capg.ewallet.bean.Ewallet_AccountBean;
import com.capg.ewallet.bean.Ewallet_CustomerBean;
import com.capg.ewallet.exception.InvalidDataException;
import com.capg.ewallet.service.Ewallet_DataValidation;
import com.capg.ewallet.service.Ewallet_Service;
 

public class Customer_Details {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Ewallet_DataValidation validate = new Ewallet_DataValidation();
		Scanner sc = new Scanner(System.in);

		
		int choice;
		int choice1;

		
		
		
		do {
			//ClientMenu
			System.out.println("******************************");
			System.out.println("Welcome to XYZ Bank-EWALLET");
			System.out.println("1.CREATE AN ACCOUNT");
			System.out.println("2.LOG IN");
			System.out.println("3.LOG OUT");
			System.out.println("*******************************");

		
		    //Choice
			System.out.println("Enter The Choice:");
		    choice= sc.nextInt();
		    

			//switchcase
			switch (choice)
			 {
			 case 1:
				 Ewallet_Service service = new Ewallet_Service();
				 Ewallet_CustomerBean bean=new Ewallet_CustomerBean();
				 Ewallet_AccountBean adetails=new Ewallet_AccountBean();
				 
				 try {
					System.out.println("CUSTOMER NAME(should not be empty):");
					String customer_name=br.readLine();
					System.out.println("GENDER(Male/Female):");
					String gender=br.readLine();
					System.out.println("AGE(should not be empty):");
					String age=br.readLine();
					System.out.println("AADHAR NUMBER(12 Digit pin):");
					String aadhar_number=br.readLine();
					System.out.println("PHONE NUMBER");
					String contact_number=br.readLine();
					System.out.println("EMAIL ID");
					String email_id=br.readLine();
					System.out.println("USER NAME:");
					String user_name=br.readLine();
					System.out.println("PASSWORD");
					String password=br.readLine();
					
					int account_number=rand.nextInt(999999)+100000;
					
					bean.setCustomer_name(customer_name);
					bean.setAge(Integer.parseInt(age));
					bean.setGender(gender);
					bean.setEmail_id(email_id);
					bean.setAadhar_number(Long.parseLong(aadhar_number));
					bean.setContact_number(contact_number);
					bean.setUser_name(user_name); 
					bean.setPassword(password);
					 
					
					adetails.setAccount_number(account_number);
					adetails.setDetails(bean);
					
					
					boolean isValidName=validate.validateCustomerName(customer_name);
					boolean isValidGender=validate.validateGender(gender);
					boolean isValidEmail=validate.validateEmail(email_id);
					boolean isValidPhoneNumber=validate.validatePhoneNumber(contact_number);
					boolean isValidAadhar=validate.validateAadhar(aadhar_number);
					boolean isValidAge=validate.validateAge(Integer.parseInt(age));
					
					
					
					if(isValidName&&isValidGender&&isValidEmail&&isValidPhoneNumber&&isValidAadhar&&isValidAge)
					{
						if(service.createAccount(adetails)==1)
						{
							System.out.println("ACCOUNT CREATED SUCCESSFULLY");
							System.out.println("ACCOUNT NO:"+account_number);
							
						}
						else
						{
							System.out.println("Account NOT CREATED");
						}
					}
					
					else
					{
						try
						{
						throw new InvalidDataException();
					}catch(InvalidDataException e)
						{
						System.err.println("Invalid Data");
						}
						 
					}
					
					
					
					 
					 
				} catch (Exception e) {
					e.printStackTrace(); 
				}
				 break;
			 case 2:
				 Ewallet_Service service1=new Ewallet_Service();
				 try
				 {
					 System.out.println("USER NAME:");
					 String user_name=br.readLine();
					 System.out.println("PASSWORD");
					 String password=br.readLine();
					 
					 if(service1.login(user_name, password)==1) {
						 do {
							 
							 System.out.println("***************************");
							 System.out.println("3.DEPOSIT");
							 System.out.println("4.WITHDRAW");
							 System.out.println("5.FUND TRANSACTION");
							 System.out.println("6.SHOW BALANCE");
							 System.out.println("7.PRINT TRANSACTION");
							 System.out.println("8.EXIT");
							 System.out.println("****************************");
							 
							 
							 
							 System.out.println("ENTER YOUR CHOICE");
							 choice1=sc.nextInt();
							 
							 
							 switch(choice1)
							 {
							 case 3:
								 Ewallet_Service service2=new Ewallet_Service();
								 System.out.println("ENTER THE AMOUNT TO BE DEPOSIT");
								 double amount=sc.nextDouble();
								  
									 if(service2.deposit(amount)==1)
									 {
										 System.out.println("AMOUNT DEPOSITED");
									 
								 
									 }
								 
							 
							 
							 else
							 {
								 System.out.println("ERROR WHILE DEPOSITING TRY AGAIN");
							 }
							 break;
							 case 4:
								 
								 Ewallet_Service service3=new Ewallet_Service();
								 System.out.println("ENTER THE AMOUNT TO BE WITHDRAWN");
								 double wamount=sc.nextDouble();


									 if(service3.withdraw(wamount)==0)
									 {
										 System.out.println("AMOUNT WITHDRAWN");
									 
								 }
								 
								 
							 
							 
							 else
							 {
								 System.out.println("ERROR WHILE WITHDRAWING AMOUNT");
							 }
							 break;
							 case 5:
								 Ewallet_Service service4=new Ewallet_Service();
								 System.out.println("Account Number:");
								int account_number=sc.nextInt();
								System.out.println("Enter the amount to be transfered");
								double famount=sc.nextDouble();
								 
								
								if(service4.fundTransfer(account_number, famount)==0)
								{
									System.out.println("Transfered");
								}
								else
								{
									System.out.println("NOT TRANSFERED");
								}
								break;
							 
							 case 6:
								 Ewallet_Service service5=new Ewallet_Service();
								 System.out.println("ENTER ACCOUNT NUMBER");
								 account_number= sc.nextInt();
								 service5.showBalance(account_number);
								 break;
								
							 case 7:
								 Ewallet_Service service6=new Ewallet_Service();
								 System.out.println("TRANSACTION DETAILS");
								 System.out.println(service6.printTransaction());
								 break;
							 case 8:
								 break;
								 
							 }
						 }while(choice1!=8);
							 
					 }
						 
						 
						 
					 
						 
					 } catch (Exception e) {
						 e.printStackTrace();
					} 
				
					 case 3:
						 break;
				 }
				 
		    
	}while(choice!=3);

}
	}
