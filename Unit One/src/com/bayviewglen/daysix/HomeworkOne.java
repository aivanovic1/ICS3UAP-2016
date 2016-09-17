package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkOne {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double purchase, tax, totalTax;
		
		System.out.print("Please type in the cost of the purchase and the tax: ");	
		purchase = scan.nextDouble();
		tax = scan.nextDouble();
		
		totalTax = purchase + (purchase * (tax/100));
		
		System.out.println("The total purchase price is : $" + totalTax);
		
		scan.close();

	}

}