package com.revature;

public class Q13 {
	public static void run() {
		String str = "";
		for(int i=0; i<4; i++) {	//print 4 lines
			if(i<=1) {
				str = i%2 + " " + str;	//add i%2 to the start of the string
			}
			else if(i==2){
				str += (i+1)%2;	//add (i+1)%2 to the end of the string
			}
			else {
				str = (i+1)%2 + " " + str;	//add (i+1)%2 to the front of the string
			}
			System.out.println(str);	//print the string after each one
		}
	}
}
