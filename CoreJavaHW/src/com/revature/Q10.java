package com.revature;

public class Q10 {
	public static void run() {
		double[] numArr = {0.457, 5.78345, 10.4516, 1.645132, 4.651, 9.1237, 3.119, 7.546, 8.789};
		
		boolean result;
		for(int i=0; i<numArr.length-1; i++) {	//go through the array in order
			result = firstIsMin(numArr[i], numArr[i+1]);	//call the ternary
			if(result) {	//if the ternary says it was less
				System.out.println(numArr[i] + " vs " + numArr[i+1] + ": " + numArr[i]);
			}
			else {	//if ternary says it was more or equal
				System.out.println(numArr[i] + " vs " + numArr[i+1] + ": " + numArr[i+1]);
			}
		}
	}
	
	public static boolean firstIsMin(double a, double b) { //return true if the first is smaller
		return a<=b ? true:false;	//here's the ternary
	}
}
