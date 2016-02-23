package proj1fa15;

/**
 * <p>Title: Project#1 </p>
 * <p>Description: Account class - an object of type account contains a 
 * 					reference to a consumer object, balance and account number. 
 * 					The class defines methods to get the values stored 
 * 					in the instance variables, to change values stored 
 * 					in the instance variables, to process a withdrawal, 
 * 					to process a deposit, and a toString method which allows
 * 				    the user to view the current state of the account.</p>
 * @author Saad Ahmad
 */

public class Account 
{
	//instance variables
	private Customer accHolder;
	private double balance;
	private int accNum;

	/**
	 * parameterized constructor -
	 * initializes the instance variables to the values received by the parameter
	 * @param c1 - stores the Customer reference received as an argument
	 * @param bal -  stores the balance received as an argument
	 * @param aNum - stores the account number received as an argument
	 */
	public Account (Customer c1, double bal, int aNum)
	{
		accHolder = c1;
		balance = bal;
		accNum = aNum;
	}

	/**
	 * getCustomer method -
	 * sends back the Customer reference to the method call
	 * @return the Customer reference stored in variable accHolder
	 */
	public Customer getCustomer()
	{
		return accHolder;
	}

	/**
	 * getBalance method -
	 * sends back the balance to the method call
	 * @return the double stored in variable balance
	 */
	public double getBalance()
	{
		return balance;
	}

	/**
	 * getAccountNum method -
	 * sends back the account number to the method call
	 * @return the int stored in variable accNum
	 */
	public int getAccountNum()
	{
		return accNum;
	}

	/**
	 * setCustomer method -
	 * stores the Customer reference received by the parameter in variable c1
	 * @param c1 - stores the Customer reference passed by the method call
	 */
	public void setCustomer (Customer c1)
	{
		accHolder = c1;
	}

	/**
	 * setBalance method -
	 * stores the balance received by the parameter in variable 'balance'
	 * @param b - stores the double passed by the method call
	 */
	public void setBalance (double bal)
	{
		balance = bal;
	}

	/**
	 * setAccountNum method -
	 * stores the account number received by the parameter in variable accNum
	 * @param aNum - stores the integer passed by the method call
	 */
	public void setAccountNum (int aNum)
	{
		accNum = aNum;
	}

	/**
	 * withdraw method -
	 * Deducts the withdrawing amount from the balance if balance is more than 0
	 * and withdrawing amount is less than or equal to balance
	 * @param wAmount - stores the amount passed by the method call
	 */
	public void withdraw(double wAmount)
	{
		if ((balance > 0) && (wAmount <= balance))
			balance -= wAmount;
	}

	/**
	 * deposit method -
	 * Adds the deposit amount to the balance 
	 * @param dAmount - stores the amount passed by the method call
	 */
	public void deposit (double dAmount)
	{
		balance += dAmount;
	}

	/**
	 * toString method - 
	 * Returns a string representing the current state of the account.
	 * @return the customer information, balance and account number
	 */
	public String toString()
	{
		return accHolder + "\nBalance: $" + balance + "\nAccount Number: " + accNum;
	}
}
