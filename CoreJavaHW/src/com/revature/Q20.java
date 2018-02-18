package com.revature;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Q20 {
	public static void run() {
		File file = new File("Data.txt");	//make the File object to give to the inputstream to tell it to read Data.txt
		int charAsInt = 0;		//for later
		StringBuilder sb = new StringBuilder();		//will store the entire file contents basically
		try {
			FileInputStream is = new FileInputStream(file);	//create the inputstream to read the file named Data.txt
			while((charAsInt = is.read()) != -1) {	
				//while the inputstream's read function doesn't return -1 (when it hits end of file), set charAsInt to what it read
				char c = (char) charAsInt;	//then cast the ASCII value of the char it read into a char, and save it
				sb.append(c);	//add the character to the StringBuilder
			}
			if(is!=null) {	//close the inputstream when we're done reading
				is.close();
			}
		} catch (IOException e) {	//catches both FileNotFoundException and issues with inputstream
			e.printStackTrace();
		}
		
		ArrayList<String> lineList = new ArrayList<String>();	//will use this to access each line individually
		int startOfLine = 0;	//keep track of index of each new line
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == '\n') {	//look for end-of-line characters
				lineList.add(sb.substring(startOfLine, i-1));	//add from the start of the line to the current spot-1 to avoid the \n
				startOfLine = i+1;	//update the index of the start of the next line
			}
		}	//can't just use .split("\n") because that's only a String function apparently, I assume this is roughly what it does anyway
		lineList.add(sb.substring(startOfLine));	//add from the start of last line to the end
		
		String[] eachLinesContents = new String[4];	//going to split up each line again, into 4 
		for(String s : lineList) {	//for each line
			eachLinesContents = s.split(":");	//split it up into its 4 parts whenever it sees a colon
			//the four parts, in order, will be: [FirstName, LastName, Age, State]
			//use that to access them and print them as necessary
			System.out.println("Name: " + eachLinesContents[0] + " " + eachLinesContents[1]);
			System.out.println("Age: " + eachLinesContents[2] + " years");
			System.out.println("State: " + eachLinesContents[3] + " State\n");
		}
	}
}
