
//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.util.Scanner;

//--------------------------------------------------
//
//	CLASS MyMain
//
//--------------------------------------------------
/**
 * This is the main class for the A03 Final Project,
 * representing the management of a Card Store<br>.
 */
public class MyMain {


	//--------------------------------------------------
	//	printMenu
	//--------------------------------------------------
	/**
	 * This function prints the menu by the screen to the customer.<br>
	 */
	public static void printMenu(){
		System.out.print("------------------------------------\n");
		System.out.print("			    MENU			  	  \n");
		System.out.print("------------------------------------\n");
		System.out.print("0.  Exit\n");
		System.out.print("1.  Add Customer\n");
		System.out.print("2.  Remove Customer\n");
		System.out.print("3.  Display Customer Info\n");
		System.out.print("4.  Display All Customer IDs\n");
		System.out.print("5.  Add Player Card\n");
		System.out.print("6.  Add Manager Card\n");
		System.out.print("7.  Remove Card\n");
		System.out.print("8.  Display Card Info\n");
		System.out.print("9.  Display All Card IDs\n");
		System.out.print("10. Top Up Customer Balance\n");
		System.out.print("11. Withdraw Customer Balance\n");
		System.out.print("12. Show Customer Balance\n");
		System.out.print("13. Purchase Card\n");
		System.out.print("14. Sell Card\n");
		System.out.print("15. Load Database from Disk\n");
		System.out.print("16. Save Database to Disk\n");
		System.out.println("\n\n");
	}

	//--------------------------------------------------
	//	selectIntOption
	//--------------------------------------------------
	/**
	 * This function asks the customer to enter a valid integer value (within a range) by keyboard.<br>
	 * @param sc - The scanner getting the input value by keyboard
	 * @param lb - The lower bound value accepted.
	 * @param ub - The upper bound value accepted.
	 * @return - The value entered by keyboard.
	 */
	public static int selectIntOption(Scanner sc,
									  int lb,
									  int ub
	){

		// 1. We create the output variable
		int res = -1;

		// 2. We create an auxiliary variable for the loop
		boolean validOption = false;

		// 3. We keep asking for a valid option until one is given
		while (!validOption) {
			System.out.println("Please enter an integer value within the range " + lb + " and " + ub + ":");
			try {
				res = sc.nextInt();
				sc.nextLine();
				if ((res >= lb) && (res <= ub))
					validOption = true;
				else
					System.out.println("Sorry but the option must be within the range " + lb + " and " + ub);
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter an integer and then press the return key");
				sc.next();
			}
		}

		// 4. We return res
		return res;
	}


	//--------------------------------------------------
	//	selectIntOption
	//--------------------------------------------------
	/**
	 * This function asks the customer to enter a valid integer value by keyboard.<br>
	 * @param sc - The scanner getting the input value by keyboard
	 * @return - The value entered by keyboard.
	 */
	public static int selectIntOption(Scanner sc){
		// 1. We create the output variable
		int res = -1;

		// 2. We create an auxiliary variable for the loop
		boolean validOption = false;

		// 3. We keep asking for a valid option until one is given
		while (!validOption) {
			System.out.println("Please enter an integer value: ");
			try {
				res = sc.nextInt();
				sc.nextLine();
				validOption = true;
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter an integer and then press the return key");
				sc.next();
			}
		}

		// 4. We return res
		return res;
	}


	//--------------------------------------------------
	//	selectStringOption
	//--------------------------------------------------
	/**
	 * This function asks the customer to enter a valid String value by keyboard.<br>
	 * @param sc - The scanner getting the input value by keyboard
	 * @return - The value entered by keyboard.
	 */
	public static String selectStringOption(Scanner sc){

		// 1. We create the output variable
		String res = "";

		// 2. We create an auxiliary variable for the loop
		boolean validOption = false;

		// 3. We keep asking for a valid option until one is given
		while (!validOption) {
			System.out.println("Please enter a String: ");
			try {
				res = sc.nextLine();
				if ((res.length() > 0) && (res.charAt(0) >= 'A') && (res.charAt(0) <= 'Z'))
					validOption = true;
				else
					System.out.println("Sorry but the option must be a non-empty string starting by a capital letter");
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a String and then press the return key");
				sc.next();
			}
		}

		// 4. We return res
		return res;
	}

	//-------------------------------------------------------------------
	// interactiveSession
	//-------------------------------------------------------------------
	/**
	 * This function performs the interactive session to the customer.<br>
	 * @param usersFileName - The name of the database file for customers.
	 * @param itemsFileName - The name of the database file for cards.
	 */
	public static void interactiveSession(String usersFileName,
										  String itemsFileName
	) {

		// 1. We create the store database manager object
		Store s = new StoreIMP();

		// 2. We create some auxiliary variables
		boolean finish = false;
		int option;
		Scanner sc = new Scanner(System.in);

		// 3. While the customer wants to continue the session
		while (!finish){
			// 3.1. We clean the screen
			for (int i = 0; i < 2; i++)
				System.out.println("\n");

			// 3.2. We print the menu
			printMenu();

			// 3.3. We ask for an option
			option = selectIntOption(sc,
					0,
					16
			);

			// 3.4. We clean the screen again
			for (int i = 0; i < 2; i++)
				System.out.println("\n");

			// 3.5. We create a few auxiliary variables
			String myStr;
			String myStr2;
			String myStr3;

			int myInt;
			int myInt2;
			int myInt3;

			double myDouble;
			double myDouble2;

			boolean myBool;

			// 3.6. We perform the action
			switch (option) {
				case 0 -> finish = true;

				case 1 -> {
					// I. We print the message
					System.out.println("---------------\n1. Add Customer\n---------------");

					// II. We ask for the customer input to define the customer
					System.out.println("Please enter the name of the new customer: ");
					myStr = selectStringOption(sc);

					// III. We attempt to add the customer
					myInt = s.addUser(myStr);

					// IV. We inform of the success of the operation
					System.out.println("New customer, ID: " + myInt + ", has been successfully created.");
				}

				case 2 -> {
					// I. We print the message
					System.out.println("---------------\n2. Remove Customer\n---------------");

					// II. We ask for the customer input to identify the customer to be removed
					System.out.println("Please enter the ID of the customer to be removed: ");
					myInt = selectIntOption(sc);
					myInt2 = myInt;

					// III. We attempt to remove the customer
					myInt = s.removeUser(myInt);

					// IV. We inform of the success of the operation
					if (myInt == -1)
						System.out.println("Sorry, no customer is registered with ID = " + myInt + " so the remove operation cannot proceed.");
					else
						System.out.println("Customer, ID: " + myInt2 + ", has been successfully removed.");
				}

				case 3 -> {
					// I. We print the message
					System.out.println("---------------\n3. Display Customer Info\n---------------");

					// II. We ask for the customer input to identify the customer to be displayed
					System.out.println("Please enter the ID for the customer to be displayed: ");
					myInt = selectIntOption(sc);

					// III. We attempt to display the customer info
					s.displayUserInfo(myInt);
				}

				case 4 -> {
					// I. We print the message
					System.out.println("---------------\n4. Display All Customer ID's\n---------------");

					// II. We perform the action
					s.displayAllUserIDs();
				}

				case 5 -> {
					// I. We print the message
					System.out.println("---------------\n5. Add Player Card\n---------------");

					// II. We ask for the customer input to define the player
					System.out.println("Please enter the name of the new player: ");
					myStr = selectStringOption(sc);
					System.out.println("Please enter the age of the new player: ");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the club of the new player: ");
					myStr2 = selectStringOption(sc);
					System.out.println("Please enter the country of the new player: ");
					myStr3 = selectStringOption(sc);
					System.out.println("Please enter the rating of the new player: ");
					myInt2 = selectIntOption(sc);
					System.out.println("Please enter the cost of the new player: ");
					myDouble = selectIntOption(sc);

					// III. We attempt to add the player
					myInt = s.addPlayer(myStr,
							myInt,
							myStr2,
							myStr3,
							myInt2,
							myDouble
					);

					// IV. We inform of the success of the operation
					System.out.println("New player, ID: " + myInt + ", has been successfully created.");
				}

				case 6 -> {
					// I. We print the message
					System.out.println("---------------\n6. Add Manager Card\n---------------");

					// II. We ask for the customer input to define the manager
					System.out.println("Please enter the name of the new manager: ");
					myStr = selectStringOption(sc);
					System.out.println("Please enter the age of the new manager: ");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the club of the new manager: ");
					myStr2 = selectStringOption(sc);
					System.out.println("Please enter the country of the new manager: ");
					myStr3 = selectStringOption(sc);
					System.out.println("Please enter the rating of the new manager: ");
					myInt2 = selectIntOption(sc);
					System.out.println("Please enter the cost of the new manager: ");
					myDouble = selectIntOption(sc);

					// III. We attempt to add the manager
					myInt = s.addManager(myStr,
							myInt,
							myStr2,
							myStr3,
							myInt2,
							myDouble
					);

					// IV. We inform of the success of the operation
					System.out.println("New manager, ID: " + myInt + ", successfully created.");
				}

				case 7 -> {
					// I. We print the message
					System.out.println("---------------\n7. Remove Card\n---------------");

					// II. We ask for the customer input to identify the card to be removed
					System.out.println("Please enter the ID for the card to be removed: ");
					myInt = selectIntOption(sc);

					// III. We attempt to remove the card
					myBool = s.removeItem(myInt);

					// IV. We inform of the success of the operation
					if (!myBool) {
						System.out.println("Sorry, no card is registered with ID = " + myInt + " so the remove operation can not proceed.");
					} else
						System.out.println("Card, ID: " + myInt + ", has been successfully removed.");
				}

				case 8 -> {
					// I. We print the message
					System.out.println("---------------\n8. Display Card Info\n---------------");

					// II. We ask for the customer input to identify the card to be displayed
					System.out.println("Please enter the ID for the card to be displayed: ");
					myInt = selectIntOption(sc);

					// III. We attempt to display the card info
					s.displayItemInfo(myInt);
				}

				case 9 -> {
					// I. We print the message
					System.out.println("---------------\n9. Display All Card IDs\n---------------");

					// II. We perform the action
					s.displayAllItemIDs();
				}

				case 10 -> {
					// I. We print the message
					System.out.println("---------------\n10. Top Up Balance\n---------------");

					// II. We ask for the customer input to identify the customer ID and the top-up amount
					System.out.println("Please enter the ID for the customer topping up their balance: ");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the top up amount: ");
					myDouble = selectIntOption(sc);

					// III. We perform the action
					myDouble2 = s.topUpBalance(myInt, myDouble);

					// IV. We print of the result of the operation
					System.out.println();
					System.out.printf("Customer, ID: " + myInt + ", has a new balance of €" + String.format("%,.2f",myDouble2) + ".");
					System.out.println();
				}

				case 11 -> {
					// I. We print the message
					System.out.println("---------------\n11. Withdraw Balance\n---------------");

					// II. We ask for the customer input to identify the customer ID and amount to withdraw
					System.out.println("Please enter the ID for the customer withdrawing their balance: ");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the amount to withdraw: ");
					myDouble = selectIntOption(sc);

					// III. We perform the action
					myDouble2 = s.withdrawBalance(myInt, myDouble);

					// IV. We print of the result of the operation
					System.out.println();
					System.out.printf("Customer, ID: " + myInt + ", has a new balance of €" + String.format("%,.2f",myDouble2) + ".");
					System.out.println();
				}

				case 12 -> {
					// I. We print the message
					System.out.println("---------------\n12. Show Balance\n---------------");

					// II. We ask for the customer input to identify the customer ID
					System.out.println("Please enter the ID of the customer: ");
					myInt = selectIntOption(sc);

					// III. We perform the action
					double balance = s.showBalance(myInt);

					// IV. We print of the result of the operation
					System.out.println();
					System.out.printf("Customer, ID: " + myInt + ", has a balance of €" + String.format("%,.2f",balance) + ".");
					System.out.println();
				}

				case 13 -> {
					// I. We print the message
					System.out.println("---------------\n13. Purchase Card\n---------------");

					// II. We ask for the customer input to identify the customer ID and the card ID
					System.out.println("Please enter the ID for the customer purchasing the card: ");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the ID for the card to be purchased: ");
					myInt2 = selectIntOption(sc);

					// III. We attempt to purchase the card
					myInt3 = s.PurchaseItem(myInt, myInt2);

					// IV. We inform of the success of the operation
					if (myInt3 == -1) {
						System.out.println("Sorry, the card can not be purchased.");
					} else
						System.out.println();
					for (int i=0; i<55; i++){
						System.out.print("=");
					}
					System.out.println();
					System.out.printf("%-23s ", " ");
					System.out.print("Invoice");
					System.out.printf("%-23s ", " ");
					System.out.println();
					for (int i=0; i<55; i++){
						System.out.print("=");
					}
					System.out.println();
					System.out.printf("%-10s ", "Cust ID");
					System.out.printf("%-10s ", "Card ID");
					System.out.printf("%-10s ", "Sale ID");
					System.out.printf("%-10s ", "Cost");
					System.out.printf("%-10s ", "Balance");
					System.out.println();
					System.out.printf("%-10s ", myInt);
					System.out.printf("%-10s ", myInt2);
					System.out.printf("%-10s ", myInt3);
					System.out.printf("%,-10.2f ", s.showCost(myInt2));
					System.out.printf("%,-10.2f ", s.showBalance(myInt));
					System.out.println();
				}

				case 14 -> {
					// I. We print the message
					System.out.println("---------------\n14. Sell Card\n---------------");

					// II. We ask for the customer input to identify the customer ID and the card ID
					System.out.println("Please enter the ID for the customer selling the card: ");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the ID for the card to be sold: ");
					myInt2 = selectIntOption(sc);

					// III. We attempt to sell the card
					myBool = s.returnItem(myInt, myInt2);

					// IV. We inform of the success of the operation
					if (!myBool) {
						System.out.println("Sorry, the card can not be sold.");
					} else
						System.out.println();
					for (int i=0; i<55; i++){
						System.out.print("=");
					}
					System.out.println();
					System.out.printf("%-23s ", " ");
					System.out.print("Invoice");
					System.out.printf("%-23s ", " ");
					System.out.println();
					for (int i=0; i<55; i++){
						System.out.print("=");
					}
					System.out.println();
					System.out.printf("%-12s ", "Cust ID");
					System.out.printf("%-12s ", "Card ID");
					System.out.printf("%-12s ", "Cost");
					System.out.printf("%-12s ", "Balance");
					System.out.println();
					System.out.printf("%-12s ", myInt);
					System.out.printf("%-12s ", myInt2);
					System.out.printf("%,-12.2f ", s.showCost(myInt2));
					System.out.printf("%,-12.2f ", s.showBalance(myInt));
					System.out.println();

				}

				case 15 -> {
					// I. We print the message
					System.out.println("---------------\n15. Load Database from Disk\n---------------");

					// II. We attempt to load the customers, cards and purchases of the store from disk.
					myBool = s.loadContentFromDisk(usersFileName,
							itemsFileName
					);

					// III. We inform of the success of the operation
					if (!myBool) {
						System.out.println("Sorry, the saving to disk can not be completed.");
					} else
						System.out.println("The saving to disk is completed successfully.");
				}

				case 16 -> {
					// I. We print the message
					System.out.println("---------------\n16. Save Database to Disk\n---------------");

					// II. We attempt to save the customers, cards and purchases of the store to disk.
					myBool = s.saveContentToDisk(usersFileName,
							itemsFileName
					);

					// III. We inform of the success of the operation
					if (!myBool) {
						System.out.println("Sorry, the saving to disk can not be completed.");
					} else
						System.out.println("The saving to disk is completed successfully.");
				}

			}

			if (option != 0) {
				System.out.println("Please key to continue: ");
				sc.nextLine();
			}
		}
	}


	//--------------------------------------------------
	//	main
	//--------------------------------------------------
	/**
	 * This is the main entry point for the Java application.<br>
	 * @param args - Any argument passed when calling to the Java application.
	 */
	public static void main(String[] args) {
		// 1. We parse any input arguments
		String usersFileName = "./myDatabase/customers.txt";
		String itemsFileName = "./myDatabase/cards.txt";

		// 2. We call to the method we want to try
		interactiveSession(usersFileName,
				itemsFileName
		);
	}

}
