package com.revature.core.java;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author johne
 * Q8. Write a program that stores the following strings 
 * in an ArrayList and saves all the palindromes in another ArrayList.
 * 
 * �karan�, �madam�, �tom�, �civic�, �radar�, �jimmy�, �kayak�, �john�,  �refer�, �billy�, �did�

 */
public class Q8_Palindromes {

	public static void main(String[] args) {
		
		ArrayList<String> namesList = new ArrayList<String>();
		namesList.add("karan");
		namesList.add("madam");	//palindrome
		namesList.add("tom");
		namesList.add("civic");	//palindrome
		namesList.add("radar"); //palindrome
		namesList.add("jimmy");
		namesList.add("kayak"); //palindrome
		namesList.add("john");
		namesList.add("refer"); //palindrome
		namesList.add("billy");
		namesList.add("did");	//palindrome
		
		ArrayList<String> palindromeList = new ArrayList<String>();
		
		/*
		 * iterate through each element and check each if string 
		 * of first letter is the same as last letter and add the
		 * palindrome strings to the palindromeList. (not the best solution at the moment)
		 */
		for(String s : namesList) {
			if(s.charAt(0) == s.charAt(s.length()-1)) {
				palindromeList.add(s);
			}
		}
		
		for(String s : palindromeList) {
			System.out.println(s);
		}
		
	}	//end of main
}	//end of class
