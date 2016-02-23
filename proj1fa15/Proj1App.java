package proj1fa15;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * <p>Title: Project#1 </p>
 * <p>Description: The application class is responsible for creating a Bank object. 
 * 					The user is presented with options to display all accounts, display
 * 					selected accounts, balance inquiry, deposit, and withdrawal. 
 * 					The user is given the option to continue processing requests 
 * 					until he/she chooses to quit.</p>
 * @author Saad Ahmad
 */

public class Proj1App 
{ //class start
	
	public static void main  (String args[]) throws Exception
	{ //main method start
		
		//bank object
		Bank theBank = new Bank();
		
		//array containing choices to be displayed in the main dialog window
		String[] choices = {"Display All Accounts", "Display Selected accounts", "Balance Inquiry",
				"Deposit", "Withdrawal", "Exit"};

		int choice = JOptionPane.showOptionDialog(null,
				"What would you like to do?", 			//text displayed in the window
				"Account Management",          		   //text displayed in the window's title bar
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				choices,                			   //text to be displayed in each button
				choices[0]);            			  //default button

		while (choice != 5)
		{ //start of while loop
			
			switch (choice)
			{ //start of switch case
			
			case 0:
				//creates a scroll window to display information of all accounts
				JTextArea text = new JTextArea(20,30);
				JScrollPane scroll = new JScrollPane(text);
				text.setText(theBank.toString());
				JOptionPane.showMessageDialog(null, scroll, "List of all accounts", JOptionPane.DEFAULT_OPTION);
				break;

			case 1:
				//asks the search criteria and amount from the user
				String[] criteria = {"Balance Greater Than", "Balance Less Than"};
				int disChoice = JOptionPane.showOptionDialog(null, "Select your choice", "Account Display",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, criteria, criteria[0]);
				double amt = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount."));
				
				//displays the information of accounts that meet the criteria in a scroll list 
				//because in some cases the list can be very long.
				JTextArea text2 = new JTextArea(20,30);
				JScrollPane scroll2 = new JScrollPane(text2);
				text2.setText(theBank.selectAccInfo(disChoice, amt));
				JOptionPane.showMessageDialog(
						null,
						scroll2,
						"Seat Assignments",
						JOptionPane.DEFAULT_OPTION);
				break;

			case 2:
				//asks the account number from the user and displays that account's balance if account is found
				//if not found displays appropriate message.
				int accNo = Integer.parseInt(JOptionPane.showInputDialog("Please enter the account number"));
				double balance = theBank.balInquiry(accNo);
				if (balance != -1)
					JOptionPane.showMessageDialog(null,"Balance for account number:  " + accNo + "  is:  $" + balance);
				else
					JOptionPane.showMessageDialog(null, "Account not found. Please check the account number and try again.");
				break;

			case 3:
				//asks the account number to deposit the amount in and the amount to deposit
				//and displays appropriate messages depending on the output of the process
				int accNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter the account number"));
				double dAmt = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount to deposit"));
				boolean deposit = theBank.deposit(accNum, dAmt);
				if (deposit == true)
					JOptionPane.showMessageDialog(null, "Deposit Successful.");
				else
					JOptionPane.showMessageDialog(null, "Deposit Unsuccessful. Check the account number and try again.");
				break;

			case 4:
				//asks the account number to withdraw the amount from and the amount to withdraw
				//and displays appropriate messages depending on the output of the process
				int aNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter the account number"));
				double wAmt = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount to withdraw"));
				boolean withdraw = theBank.withdraw(aNum, wAmt);
				if (withdraw == true)
					JOptionPane.showMessageDialog(null, "Withdraw Successful.");
				else
					JOptionPane.showMessageDialog(null, "Withdraw Unsuccessful. Check the account number and make sure "
							+ "withdrawing amount is not more than the balance in the account, then try again.");
				break;
			} //end of switch case

			choice = JOptionPane.showOptionDialog(null,
					"What would you like to do?", 			//text displayed in the window
					"Account Management",          		   //text displayed in the window's title bar
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					choices,                			   //text to be displayed in each button
					choices[0]);            			  //default button
		
		} //end of while loop
	} //end of main method
} //end of class
