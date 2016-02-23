package proj1fa15;
import java.util.*;
import java.io.*;
/**
 * <p>Title: Project#1 </p>
 * <p>Description: Bank Class - An object of type Bank contains a reference
 * 					to an Account array. The bank has 10 accounts. The constructor 
 * 					reads the referenced file containing the account data, 
 * 					creates account objects and stores each account as an element 
 * 					in the array. The class has methods to let the user deposit money, 
 * 					withdraw money, check balance of a particular account, display selected 
 * 					accounts based on an available criteria, 
 * 					and display all accounts (the toString method)</p>
 * @author Saad Ahmad
 */

public class Bank 
{
	//instance variables
	private Account[] acc;
	private int noOfAcc;
	
	/**
	 * default constructor -
	 * initializes the instance variables to the default values(the values
	 * defined in the constructor).
	 */
	public Bank() throws Exception
	{
		acc = new Account[10];
		noOfAcc = 0;
		Scanner fileScan = new Scanner(new File("bankdata.txt"));
		
		String fName;     //will store the first name read from file
		String lName;     //will store the last name read from file
		int age;          //will store the age read from file
		String phoneNum;  //will store the phone number read from file
		double balance;   //will store the balance read from file
		int accNum;       //will store the account number read from file
		
		//loop to read from the data file, create account objects and 
		//store their reference in the bank array
		while (fileScan.hasNext())
		{	
			fName = fileScan.next();
			lName = fileScan.next();
			age = fileScan.nextInt();
			phoneNum = fileScan.next();
			balance = fileScan.nextDouble();
			accNum = fileScan.nextInt();
			
			Customer c1 = new Customer (fName, lName, age, phoneNum);
			acc[noOfAcc] = new Account (c1, balance, accNum);
			noOfAcc++;
		}
		fileScan.close();
	}
	
	/**
	 * deposit method -
	 * Adds the deposit amount to the balance of the selected account 
	 * @param aNum - store the account number passed by the method call
	 * @param dAmount - stores the deposit amount passed by the method call
	 * @return true if deposit is successful else false
	 */
	public boolean deposit(int aNum, double dAmount)
	{
		for (int i = 0; i < noOfAcc; i++)
		{
			if (acc[i].getAccountNum() == aNum)
			{
				acc[i].deposit(dAmount);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * withdraw method -
	 * Deducts the withdrawing amount from the balance of the selected account if 
	 * balance is more than 0 and withdrawing amount is less than or equal to balance
	 * @param aNum - stores the account number passed by the method call
	 * @param wAmount - stores the amount passed by the method call
	 * @return true if withdrawal is successful else false
	 */
	public boolean withdraw(int aNum, double wAmount)
	{
		for (int i = 0; i < noOfAcc; i++)
		{
			if ((acc[i].getAccountNum() == aNum) && (wAmount <= acc[i].getBalance()))
			{
				acc[i].withdraw(wAmount);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * balInquiry method -
	 * finds the account whose account number has been sent and returns its balance
	 * @param accNum - stores the account number passed by the method call
	 * @return balance if the account is found else -1 to indicate account not found
	 */
	public double balInquiry(int accNum)
	{
		for (int i = 0; i < noOfAcc; i++)
		{
			if (acc[i].getAccountNum() == accNum)
				return acc[i].getBalance();
		}
		return -1;
	}
	
	/**
	 * selectAccInfo method - 
	 * Returns a string representing the current state of the elements of 
	 * the bank array(account objects) that meet the selected criteria.
	 * @param choice - stores the users criteria choice sent by the method call
	 * @param amount - stores the amount for displaying account information of 
	 * 					accounts whose balance is greater or less than it 
	 * @return the account informations of all the accounts in 
	 * 			the bank that meet the selected criteria
	 */
	public String selectAccInfo(int choice, double amount)
	{
		String str = "";
		if (choice == 0)
		{
			for (int i = 0; i < noOfAcc; i++)
			{
				if (amount < acc[i].getBalance())
					str += acc[i].toString() + "\n\n";
			}
		}
		
		else if (choice == 1)
		{
			for (int i = 0; i < noOfAcc; i++)
			{
				if (amount > acc[i].getBalance())
					str += acc[i].toString() + "\n\n";
			}
		}
		return str;
	}
	
	/**
	 * toString method - 
	 * Returns a string representing the current state of the bank array.
	 * @return the account of all the accounts in the bank
	 */
	public String toString()
	{
		String str = "";
		for (int i = 0; i < noOfAcc; i++)
		{
			str += acc[i].toString() + "\n\n";
		}
		return str;
	}
}
