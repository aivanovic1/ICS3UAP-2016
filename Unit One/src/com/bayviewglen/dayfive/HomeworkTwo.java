package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkTwo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter your score and the total for the test: ");

		double mark = scan.nextDouble();
		double total = scan.nextDouble();
		
		int percentage = (int)((mark/total)*100); 
		
		System.out.println("The student recieved a percentage of " + percentage + "%.");
	
		scan.close();
	
	}

}
