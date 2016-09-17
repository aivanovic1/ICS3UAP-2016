package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkEight {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double num1;
		
		System.out.print("Please enter a positive number: ");
		num1 = scan.nextDouble();
		
		if (num1%2 == 0){
			System.out.println("Your number " + num1 + " squared is " + num1*num1 + " and your number square rooted is " + Math.sqrt(num1) + ".");
		} else{
			System.out.println("That's not a positive number!");
		}
			
		
		scan.close();

	}

}
