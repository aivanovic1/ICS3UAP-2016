package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkNine {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int itemsSold;
		double payDue;

		System.out.print("Please enter the number of items you sold: ");
		itemsSold = scan.nextInt();
		
		payDue = 0.27 * itemsSold;
		
		System.out.println("The amount of pay due is: $" + payDue);
		
		scan.close();
	}

}
