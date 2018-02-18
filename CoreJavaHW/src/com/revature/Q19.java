package com.revature;

import java.util.ArrayList;

public class Q19 {
	public static void run() {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i=1; i<=10; i++) {
			arrList.add(i);
		}
		System.out.println("Original ArrayList: " + arrList.toString());
		int evenSum = 0;
		int oddSum = 0;
		ArrayList<Integer> numsToKeep = new ArrayList<Integer>();
		for(int i : arrList) {
			if(i%2 == 0) {	//if even
				evenSum += i;	//add it to the evenSum
			}
			else {	//if odd
				oddSum += i;	//add it to the oddSum
			}
			for(int j=2; j<i/2; j++) {	//checking for non-primes, start at 2 and try to divide from there
				if(i%j == 0) {				//if non-prime number found
					numsToKeep.add(i);	//add it to list of numbers to keep later
					break;	//break to not keep adding ones with multiple divisors
				}
			}
		}
		System.out.println("Sum of even numbers: " + evenSum);
		System.out.println("Sum of odd numbers: " + oddSum);
		
		arrList.clear();	//clear the list
		for(int i : numsToKeep) {		//go through list of numbers to keep
			//had to do seperate loop so arrList wasn't being modified while going through it
			arrList.add(i);				//then re-add the non-primes
		}
		
		System.out.println("ArrayList with primes removed: " + arrList.toString());
	}
}
