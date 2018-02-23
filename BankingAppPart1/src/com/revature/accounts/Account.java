package com.revature.accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.revature.users.Customer;

public class Account {
	private double balance = 25.00;
	private boolean active = true;
	private boolean jointAccount = false;
	private boolean goodStanding = true;
	private int accountNumber = new Random().nextInt(1000) + 10000;
	private String accountType;
	private String primaryAccountHolder = null;
	private String secondaryAccountHolder = null;
	
	public Account() {
		super();
	}
	
	public Account(String primaryAccountHolder, String accountType) {
		super();
		this.primaryAccountHolder = primaryAccountHolder;
		this.accountType = accountType;

	}
	
	public Account(String primaryAccountHolder, String accountType, String secondaryAccountHolder) {
		this(primaryAccountHolder, accountType);
		this.secondaryAccountHolder = secondaryAccountHolder;
		this.jointAccount = true;
	}

	public static void listAccounts(ArrayList<Account> accountList, String userName) {
		for(Account current : accountList) {
			System.out.println("Account: " + current.getAccountNumber() + "  " + current.getAccountType() +
					"  " + "Balance: " + current.getBalance());
		}
	}
	
	public static HashMap<String, ArrayList<Account>> createAccount(Customer customer, 
			HashMap<String, ArrayList<Account>> accountsMap) {
		Account newAccount = null;
		
		//get the customer's account list
		ArrayList<Account>accountsList = accountsMap.get(customer.getUserName());
		if(accountsList == null) {
			accountsList = new ArrayList<>();
		}
		//CHECKING
		//Regular checking
		if(!customer.isApplyingForSavings() &&
				!customer.isApplyingForJoint()) {
			newAccount = new Account(customer.getUserName(), "Checking");
			
			//add the new account to the accounts list
			System.out.println("Adding account to list");
			accountsList.add(newAccount);
			System.out.println("Added");
		}
		//Joint checking
		else if(!customer.isApplyingForSavings()){
			newAccount = new Account(customer.getUserName(), "Checking",
					customer.getHoldsJointAccountWith());
			
			//add the new account to the accounts list
			accountsList.add(newAccount);
			
			//add the list to the account map
			accountsMap.put(customer.getUserName(), accountsList);
		}
		
		//SAVINGS
		//Regular savings
		else if(!customer.isApplyingForJoint()) {
			newAccount = new Account(customer.getUserName(), "Savings");
			
			//add the new account to the accounts list
			accountsList.add(newAccount);
			
			//add the list to the account map
			accountsMap.put(customer.getUserName(), accountsList);
		}
		//Joint savings
		else {
			newAccount = new Account(customer.getUserName(), "Savings",
					customer.getHoldsJointAccountWith());
			
			//add the new account to the accounts list
			accountsList.add(newAccount);
			
			//add the list to the account map
			accountsMap.put(customer.getUserName(), accountsList);
		}

		customer.setAccountHolder(true);
		return accountsMap;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void transfer(double amount, Account destination) {
		balance -= amount;
		destination.setBalance(destination.getBalance() + amount);		
	}

	public void listAccounts(ArrayList<Account> accounts) {
		for (Account current : accounts) {
			current.toString();
		}
	}
		
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isJointAccount() {
		return jointAccount;
	}

	public void setJointAccount(boolean jointAccount) {
		this.jointAccount = jointAccount;
	}

	public boolean isGoodStanding() {
		return goodStanding;
	}

	public void setGoodStanding(boolean goodStanding) {
		this.goodStanding = goodStanding;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPrimaryAccountHolder() {
		return primaryAccountHolder;
	}

	public void setPrimaryAccountHolder(String primaryAccountHolder) {
		this.primaryAccountHolder = primaryAccountHolder;
	}

	public String getSecondaryAccountHolder() {
		return secondaryAccountHolder;
	}

	public void setSecondaryAccountHolder(String secondaryAccountHolder) {
		this.secondaryAccountHolder = secondaryAccountHolder;
	}

	@Override
	public String toString() {
		return "Account balance: " + balance + "\nAccount active: " + active + "\nJoint account: " + jointAccount
				+ "\nAccount in good standing: " + goodStanding + "\nAccount type: " + accountType + 
				"Primary account holder: " + primaryAccountHolder + "\nSecondary Account Holder: " 
				+ secondaryAccountHolder;
	}

	
}
