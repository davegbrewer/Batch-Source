package com.revature.accounts;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JointAccount extends Account{

	
	private static final long serialVersionUID = 5L;
	private static final byte PRIVILEGE_LEVEL = -1;
	private CustomerAccount customer;
	private int age;
	private int jointID;
	private int customerID;
	
	public JointAccount() {
		
	}
	
	public JointAccount(String username, String password, String firstName, String lastName, CustomerAccount customer) {
		super.setUsername(username);
		super.setPassword(password);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		this.customer = customer;
		customerID = customer.getCustomerID();
	}
	
	public void setCustomer(CustomerAccount customer) {
		this.customer = customer;
	}
	
	@Override
	public byte getPriorityLevel() {
		// TODO Auto-generated method stub
		return PRIVILEGE_LEVEL;
	}
	
	public boolean setAge(int age) {
		
		if(age < 18) {
			System.out.println("Sorry, you must be eighteen or older to register!");
			return false;
		}
		else {
			this.age = age;
			return true;
		}
	}
	
	public int getAge() {		
		return age;
	}
	
	public void depositChecking() {
		double doubleInput = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How much would you like to deposit to checking?: ");
		
		try {
			doubleInput = sc.nextDouble();
			sc.nextLine();					
		    customer.depositChecking(doubleInput);
		}
		catch(InputMismatchException e){
			System.out.println("INVALID INPUT");
		}
	}
	
	public void depositSavings() {
		double doubleInput = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How much would you like to deposit to savings?: ");
		
		try {
			doubleInput = sc.nextDouble();
			sc.nextLine();					
			customer.depositSavings(doubleInput);
		}
		catch(InputMismatchException e){
			System.out.println("INVALID INPUT");
		}
	}
	
	public void withdrawSavings() {
		double doubleInput = 0;
		Scanner sc = new Scanner(System.in);
		boolean actionComplete = false;
		
		System.out.print("How much would you like to withdraw from savings?: ");
		
		try {
			doubleInput = sc.nextDouble();
			sc.nextLine();					
			
			actionComplete = customer.withdrawSavings(doubleInput);
			
			if(!actionComplete) {
				System.out.println("You do not have enough in your savings to withdraw that much");
			}
			else {
				System.out.println("Successfully withdrew $" + doubleInput + " from savings");
			}
			
		}
		catch(InputMismatchException e){
			System.out.println("INVALID INPUT");
		}
	}
	
	public void withdrawChecking() {
		double doubleInput = 0;
		Scanner sc = new Scanner(System.in);
		boolean actionComplete = false;
		
		System.out.print("How much would you like to withdraw from checking?: ");
		
		try {
			doubleInput = sc.nextDouble();
			sc.nextLine();					
			
			actionComplete = customer.withdrawChecking(doubleInput);
			
			if(!actionComplete) {
				System.out.println("You do not have enough in your checking to withdraw that much");
			}
			else {
				System.out.println("Successfully withdrew $" + doubleInput + " from checking");
			}
		}
		catch(InputMismatchException e){
			System.out.println("INVALID INPUT");
		}
	}
	
	public String toString() {
		return customer.toString();
	}

	public boolean isActive() {
		return customer.isActive();
	}
	
	public int getLinkedAccount() {	
		return customer.getCustomerID();		
	}

	public int getJointID() {
		return jointID;
	}

	public void setJointID(int jointID) {
		this.jointID = jointID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

}
