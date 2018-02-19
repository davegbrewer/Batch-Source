package com.revature.core.java;

import java.util.Scanner;

/**
 * 
 * @author Johne Vang
 * Q6. Write a program to determine if an
 * integer is even without using the modulus operator (%)
 */
public class Q6_IsEven {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		
		/* 
		 * the number is even if number is divided number by 2, 
		 * and the quotient multiplied by 2 is equal to number or itself.
		 * otherwise, if quotient multiplied by 2 is less than the number then it is an odd number. 
		 */
		if((number / 2) * 2 == number) {
			System.out.println(number + " is even.");
		} else {
			System.out.println(number + " is odd");
		}

	}	//end of main
}	// end of class
