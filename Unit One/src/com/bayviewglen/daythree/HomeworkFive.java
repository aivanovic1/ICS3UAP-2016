package com.bayviewglen.daythree;

public class HomeworkFive {

	public static void main(String[] args) {
		int pennies, nickels, dimes, quarters, loonies, toonies;
		
		pennies = 4;
		nickels = 6;
		dimes = 9;
		quarters = 2;
		loonies = 3;
		toonies = 1;
		
		double amount = (pennies*0.01) + (nickels*0.05) + (dimes*0.1) + (quarters*0.25) + loonies + (toonies*2);
		
		System.out.print("The total amount of money that you have is $" + amount);

	}

}
