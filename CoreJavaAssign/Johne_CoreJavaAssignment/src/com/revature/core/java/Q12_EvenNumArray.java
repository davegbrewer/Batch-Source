package com.revature.core.java;

/**
 * 
 * @author Johne Vang
 * Q12. Write a program to store numbers from 1 to 100 in an array. 
 * Print out all the even numbers from the array. Use the enhanced 
 * FOR loop for printing out the numbers.
 */

public class Q12_EvenNumArray {
	public static void main(String[] args) {
		int[] arr = new int[100];	//array of size 100
		
		//store num 1 through 100 into arr
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		/*
		 * loop through each elements and display even numbers
		 */
		System.out.println("Even numbers from Array");
		for(int i : arr) {
			if(i % 2 == 0) {
				System.out.println(i);
			} 
		}
		
	}	//end of main
}	//end of class
