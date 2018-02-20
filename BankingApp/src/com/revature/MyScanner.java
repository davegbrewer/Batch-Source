package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

public class MyScanner {
	
	public MyScanner() {
		
		// Instantiate new Scanner object
		Scanner sc = new Scanner(System.in);
		
		// Create new InteractWithFile object
		InteractWithFile fi = new InteractWithFile();
		
		// Take in user input for principal and store as int
		System.out.println("Please choose from the following options:");
		System.out.println("1. Login");
		System.out.println("2. Register");
		
		// Get input
		int roleInput = sc.nextInt();
		
		// Set booleans
		boolean goToNextScreen = false;
		boolean createAccount = false;
		
		while(!goToNextScreen) {
			
			switch(roleInput) {
				case 1:
					goToNextScreen = true;
					break;
					
				case 2:
					goToNextScreen = true;
					createAccount = true;
					break;
					
				default:
					System.out.println("Please choose from the following options:");
					System.out.println("1. Login");
					System.out.println("2. Register");
					roleInput = sc.nextInt();
					break;
			}
		
		}
	
		if(createAccount) {
			
			// Get customer's first name
			System.out.println("Please enter your first name:");
			String firstName = sc.next();
			
			// Get customer's last name
			System.out.println("Please enter your last name:");
			String lastName = sc.next();
			
			// Get customer's username
			System.out.println("Please choose your username:");
			String username = sc.next();
			
			ArrayList<String> usernames = fi.readUsernames();
			
			boolean sameUsername = true;
			while(sameUsername) {
				
				sameUsername = false;
				
				for(String existingUsername : usernames) {
					if(username.equals(existingUsername)) {
						sameUsername = true;
					}
				}
				if(sameUsername) {
					System.out.println("Sorry, that username is taken. Please choose another:");
					username = sc.next();
				}
			}
			
			// Get customer's password
			System.out.println("Please choose your password:");
			String password = sc.next();
			
			// Populate customer id
			int id = fi.getLastUserId();
			id++;

			// Create new customer
			Customer cust = new Customer(id, firstName, lastName, username, password);
			
			// Create string to store in users.txt
			String custStr = cust.getCustomerId() + ":" + cust.getFirstName() + ":" + cust.getLastName() + ":" + cust.getUsername() + ":" + cust.getPassword();
			
			// Write to users.txt
			fi.addNewCustomer(custStr);
			
			// Re-instantiate class
			new MyScanner();
			
		} else {
			
			// Get login username
			System.out.println("Please enter your username:");
			String username = sc.next();
			
			// Check if username exists
			ArrayList<String> usernames = fi.readUsernames();
			boolean usernameExists = false;
			
			while(!usernameExists) {
				for(String uname : usernames) {
					if(username.equals(uname)) {
						usernameExists = true;
					}
				}
				if(!usernameExists) {
					System.out.println("Error! That username does not exists. Please try again.");
					username = sc.next();
				}
			}
			
			// After confirming username exists, get that user
			ArrayList<String> user = fi.getUser(username);
			int custId = Integer.parseInt(user.get(0));
			Customer cust = new Customer(custId, user.get(1), user.get(2), user.get(3), user.get(4));
			
			// Get password
			System.out.println("Please enter your password:");
			String password = sc.next();
			
			// Validate password
			if(!password.equals(cust.getPassword())) {
				boolean wrongPassword = true;
				while(wrongPassword) {
					System.out.println("Error! Wrong password. Please try again.");
					password = sc.next();
					if(password.equals(cust.getPassword())) {
						wrongPassword = false;
					}
				}
			}
			
			// Check for existing account
			boolean hasAccount = fi.checkForAccount(custId);
			
			if(hasAccount) {
				
				ArrayList<String> cal = fi.getCustAccount(custId);
				
				// id
				String cal0 = cal.get(0);
				int cal00 = Integer.parseInt(cal0);
				
				// is_approved
				String cal1 = cal.get(1);
				int cal11 = Integer.parseInt(cal1);
				
				// is_joint
				String cal2 = cal.get(2);
				int cal22 = Integer.parseInt(cal2);
				
				// custIdOne
				String cal3 = cal.get(3);
				int cal33 = Integer.parseInt(cal3);
				
				// custIdTwo
				String cal4 = cal.get(4);
				int cal44 = Integer.parseInt(cal4);
				
				// accountBalance
				String cal5 = cal.get(5);
				double cal55 = Double.parseDouble(cal5);
				
				Account custAccount = new Account(cal00, cal11, cal22, cal33, cal44, cal55);
				
				if(cal.get(1).equals("0")) {
					System.out.println("Hi " + cust.getFirstName() + " " + cust.getLastName() + "! Your account is currently pending approval! Please check back later.");
					System.out.println("1. Logout");
					int choice = sc.nextInt();
					if(choice == 1) {
						new MyScanner();
					}
				} else {
					
					System.out.println("Hi " + cust.getFirstName() + " " + cust.getLastName() + "! Welcome to your account!");
					System.out.println("Please choose from one of the following:");
					System.out.println("1. View account balance");
					System.out.println("2. Make a withdrawl");
					System.out.println("3. Make a deposit");
					System.out.println("4. Logout");
					int choice = sc.nextInt();
					
					boolean loggedIn = true;
					boolean mainMenu = false;
					
					while(loggedIn) {
						
						if(mainMenu) {
							
							mainMenu = false;
							
							System.out.println("Please choose from one of the following:");
							System.out.println("1. View account balance");
							System.out.println("2. Make a withdrawl");
							System.out.println("3. Make a deposit");
							System.out.println("4. Logout");
							choice = sc.nextInt();
						}
						
						switch(choice) {
							case 1:
								System.out.println("Your current account balance is: $" + custAccount.getAccountBalance());
								System.out.println("1. Main Menu");
								int result = sc.nextInt();
								if(result == 1) {
									mainMenu = true;
								}
								break;
								
							case 2:
								System.out.println("How much would you like to withdraw from your account?");
								double withdrawAmount = sc.nextDouble();
								
								boolean withdrawing = true;
								
								while(withdrawing) {
									if(withdrawAmount > custAccount.getAccountBalance()) {
										System.out.println("Error! Please enter an amount less than or equal to $" + custAccount.getAccountBalance());
										withdrawAmount = sc.nextDouble();
									} else {
										double newAmount = custAccount.getAccountBalance() - withdrawAmount;
										custAccount.setAccountBalance(newAmount);
										
										fi.updateAccountBalance(custAccount.getId(), custAccount.getAccountBalance());
										
										withdrawing = false;
									}
								}
								
								
								break;
								
							default:
								break;
						}
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
				
			} else {
				System.out.println("Hi! " + cust.getFirstName() + " " + cust.getLastName() + ". Please choose an action!");
				System.out.println("1. Apply for bank account");
				System.out.println("2. Logout");
				int action = sc.nextInt();
				
				boolean apply = false;
				switch(action) {
					case 1:
						apply = true;
						break;
							
					case 2:
						new MyScanner();
						break;
				}
				
				if(apply) {
					System.out.println("What kind of account would you like to open?");
					System.out.println("1. Checking");
					System.out.println("2. Savings");
					System.out.println("3. Checking and Savings");
					int accountType = sc.nextInt();
					
					System.out.println("Is this a single or joint account?");
					System.out.println("1. Single");
					System.out.println("2. Joint");
					int accountMemberType = sc.nextInt();
					
					int checking = 0;
					int savings = 0;
					switch(accountType) {
						case 1:
							checking = 1;
							break;
							
						case 2:
							savings = 1;
							break;
							
						case 3:
							checking = 1;
							savings = 1;
							break;
					}
					
					if(accountMemberType == 2) {
						System.out.println("What is the username of the person you would like a joint account with?");
						String jointUsername = sc.next();
						
						ArrayList<String> jointUser = fi.getUser(jointUsername);
						
						int accountId = fi.getLastAccountId();
						accountId++;
						
						String newAccount = accountId + ":" + "0:" + cust.getCustomerId() + ":" + jointUser.get(0) + ":" + checking + ":" + savings + ":0:0";             
						fi.createJointAccount(newAccount);
					} else {
						
						int accountId = fi.getLastAccountId();
						
						String newAccount = accountId + ":" + "0:" + cust.getCustomerId() + ":0:" + checking + ":" + savings + ":0:0";
						fi.createNewAccount(newAccount);
					}
					
				}
				
			}
			
		}
			
		// Close scanner
		sc.close();
	}

}
