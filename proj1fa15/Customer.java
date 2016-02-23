package proj1fa15;

/**
 * <p>Title: Project#1 </p>
 * <p>Description: Consumer class - an object of type consumer contains a 
 * 					first name, a last name, age and a phone number. 
 * 					The class defines methods to get the values stored 
 * 					in the instance variables, to change values stored 
 * 					in the instance variables, and a toString method 
 * 					which allows the user to view the current state of the consumer.</p>
 * @author Saad Ahmad
 */

public class Customer 
{
	//instance variables
	private String fName;
	private String lName;
	private int age;
	private String phone;

	/**
	 * parameterized constructor -
	 * initializes the instance variables to the values received by the parameter
	 * @param f - stores the first name received as an argument
	 * @param l -  stores the last name received as an argument
	 * @param a - stores the age received as an argument
	 * @param p - stores the phone number received as an argument
	 */
	public Customer (String firstName, String lastName, int a, String phoneNum)
	{
		fName = firstName;
		lName = lastName;
		age = a;
		phone = phoneNum;
	}

	/**
	 * getFirstName method -
	 * sends back the first name to the method call
	 * @return the String stored in variable fName
	 */
	public String getFirstName()
	{
		return fName;
	}

	/**
	 * getLastName method -
	 * sends back the last name to the method call
	 * @return the String stored in variable lName
	 */
	public String getLastName()
	{
		return lName;
	}

	/**
	 * getAge method -
	 * sends back the age to the method call
	 * @return the integer stored in variable age
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * getPhoneNum method -
	 * sends back the phone number to the method call
	 * @return the String stored in variable phone
	 */
	public String getPhoneNum()
	{
		return phone;
	}

	/**
	 * setFirstName method -
	 * stores the String received by the parameter in variable fName
	 * @param firstName - stores the string passed by the method call
	 */
	public void setFirstName(String firstName)
	{
		fName = firstName;
	}

	/**
	 * setLastName method -
	 * stores the String received by the parameter in variable lName
	 * @param lastName - stores the string passed by the method call
	 */
	public void setLastName(String lastName)
	{
		lName = lastName;
	}

	/**
	 * setAge method -
	 * stores the integer received by the parameter in variable age
	 * @param a - stores the integer passed by the method call
	 */
	public void setAge (int a)
	{
		age = a;
	}

	/**
	 * setPhoneNum method -
	 * stores the String received by the parameter in variable phone
	 * @param phoneNum - stores the String passed by the method call
	 */
	public void setPhoneNum (String phoneNum)
	{
		phone = phoneNum;
	}

	/**
	 * toString method -
	 * Returns a string representing the current state of the customer.
	 * @return the first name, last name, age and phone number
	 */
	public String toString()
	{
		return "First Name: " + fName + "\nLast Name: " + lName + "\nAge: " + age + "\nPhone Number: " + phone;
	}
}
