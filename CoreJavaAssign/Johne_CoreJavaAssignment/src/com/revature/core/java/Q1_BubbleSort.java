package com.revature.core.java;

import java.util.Arrays;

/**
 * 
 * @author johne
 * Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */
public class Q1_BubbleSort {

	public static void main(String[] args) {
		int[] intArray = {1,0,5,6,3,2,3,7,9,8,4};
		
		bubbleSort(intArray);
	}//end of main
	
	/**
	 * Traverse through array from first element to size - 1 position 
	 * and compare current element with the next one.
	 * Swap the element if next element is greater.
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		int temp;
		for(int i = 0; i < a.length - 1; i++) {
			for(int j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}//end of class
