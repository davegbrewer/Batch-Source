package com.revature;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Q1");	//pretty much does these same 3 things for each class
		Q1 q1 = new Q1();			//except 15, because that specified to do something in the main function
		q1.run();

		System.out.println("\nQ2");
		Q2 q2 = new Q2();
		q2.run();

		System.out.println("\nQ3");
		Q3 q3 = new Q3();
		q3.run();

		System.out.println("\nQ4");
		Q4 q4 = new Q4();
		q4.run();

		System.out.println("\nQ5");
		Q5 q5 = new Q5();
		q5.run();

		System.out.println("\nQ6");
		Q6 q6 = new Q6();
		q6.run();

		System.out.println("\nQ7");
		Q7 q7 = new Q7();
		q7.run();

		System.out.println("\nQ8");
		Q8 q8 = new Q8();
		q8.run();

		System.out.println("\nQ9");
		Q9 q9 = new Q9();
		q9.run();

		System.out.println("\nQ10");
		Q10 q10 = new Q10();
		q10.run();

		System.out.println("\nQ11");
		Q11 q11 = new Q11();
		q11.run();

		System.out.println("\nQ12");
		Q12 q12 = new Q12();
		q12.run();

		System.out.println("\nQ13");
		Q13 q13 = new Q13();
		q13.run();

		System.out.println("\nQ14");
		Q14 q14 = new Q14();
		q14.run();

		System.out.println("\nQ15");
		Q15 q15 = new Q15();
		double a = 1.5;		//this question apparently wants us to hard code values in the main class, so here you go
		double b = 4.2;
		System.out.println(a+" + "+b+" = " + q15.add(a, b));
		System.out.println(a+" - "+b+" = " + q15.sub(a, b));
		System.out.println(a+" * "+b+" = " + q15.mult(a, b));
		System.out.println(a+" / "+b+" = " + q15.div(a, b));

		System.out.println("\nQ16");
		Q16 q16 = new Q16();
		q16.run(args);	//it wants command-line input, so I'm passing args to q16.run() so it can work with them

		System.out.println("\nQ17");
		Q17 q17 = new Q17();
		q17.run();

		System.out.println("\nQ18");
		Q18 q18 = new Q18();
		q18.run();

		System.out.println("\nQ19");
		Q19 q19 = new Q19();
		q19.run();

		System.out.println("\nQ20");
		Q20 q20 = new Q20();
		q20.run();
	}

}
