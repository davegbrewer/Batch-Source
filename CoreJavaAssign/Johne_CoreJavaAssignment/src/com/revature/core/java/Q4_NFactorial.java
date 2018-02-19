package com.revature.core.java;

/**
 * 
 * @author Johne Vang
 * Q4 N Factorial
 * Write a program to compute N factorial.
 */
public class Q4_NFactorial {
	public static void main(String[] args) {
		System.out.println(factorial(4));
	}
	
	/**
	 * use recursive function
	 * check if num is 1 otherwise if num > 1, 
	 * num will multiply with factorial(num - 1). 
	 * num - 1 is the end condition, where the recursive method stops
	 * calling itself.
	 * 
	 * @param num
	 * @return factorial result
	 */
	public static int factorial(int num) {
		
		if(num == 1) {return 1;} 
		else {
			return num * factorial(num - 1);
		}
		
	}
}
