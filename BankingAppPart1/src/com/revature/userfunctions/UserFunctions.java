package com.revature.userfunctions;

import java.util.Scanner;

import com.revature.users.*;

public class UserFunctions {

	public static Customer register(Scanner getInput) {
		Customer newCustomer = new Customer();		

		System.out.print("Enter a user name: ");
		newCustomer.setUserName(getInput.next());
		//check for user name availability
		
		System.out.print("Enter a password: ");
		newCustomer.setPassword(getInput.next());
		
		//check password complexity
		
		System.out.print("Enter your first name: ");
		newCustomer.setFirstName(getInput.next());
		
		System.out.print("Enter your last name: ");
		newCustomer.setLastName(getInput.next());
		
		System.out.print("Enter your street address: ");
		newCustomer.setStreetAddress(getInput.next());
		
		System.out.print("Enter your city: ");
		newCustomer.setCity(getInput.next());
		
		System.out.print("Enter your two letter state abbreviation: ");
		newCustomer.setState(getInput.next());
		
		System.out.print("Enter your phone number (123-456-7890): ");
		newCustomer.setPassword(getInput.next());

		return newCustomer;

	}
	
	public static boolean validateCustomer(String password, Customer customer) {
		if(password == customer.getPassword()) {
			return true;
		}
		
		return false;
	}
	
	public static boolean validateEmployee(String password, Employee employee) {
		if(password == employee.getPassword()) {
			return true;
		}
		
		return false;
	}
	
	public static boolean validateAdmin(String password, Admin admin) {
		if(password == admin.getPassword()) {
			return true;
		}
		
		return false;
	}
}
