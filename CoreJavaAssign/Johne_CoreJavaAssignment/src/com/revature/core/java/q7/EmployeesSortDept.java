package com.revature.core.java.q7;

import java.util.Comparator;

/**
 * 
 * @author johne
 * this class compares the dept of employees
 */
public class EmployeesSortDept implements Comparator<Employees>{

	/**
	 * Used compareTo to compare department names
	 */
	@Override
	public int compare(Employees e1, Employees e2) {
		return e1.getDept().compareTo(e2.getDept());
	}
	
}
