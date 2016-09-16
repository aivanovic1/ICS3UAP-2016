package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkOne {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double x;
		
		System.out.print("Please enter a number that you want squared: ");
		
		x = scan.nextInt();
						
		System.out.println("This is the value of x: " + x + "\nThis is the value of x^2: " + x*x);
				
		scan.close();
			
	}

}
