package com.revature.core.java;

import java.util.Scanner;

/**
 * 
 * @author johne
 * Q3. Reverse a string without using a temporary variable.  
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */
public class Q3_ReverseString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		//use nextLine to read entire line of string that includes spaces or line separator
		String str = input.nextLine();	
		
		/*
		 * do not know how long string is, so
		 * use a while loop and print reverse 
		 * string by using charAt().
		 * 
		 * counter is set to length of string - 1 to avoid StringIndexOutOfBoundsException
		 * as long as the counter greater than zer0,
		 * display the string backwards
		 */
		int counter = str.length() - 1;
		while(counter >= 0) {
			System.out.print(str.charAt(counter));
			counter--;
		}
	}	//end of main
}	//end of class
