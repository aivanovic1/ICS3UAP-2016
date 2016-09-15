package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkThree {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1, digit2, digit5;
		
		System.out.println("Please enter a six-digit number: ");
		num1 = scan.nextInt();
			
		digit2 = (num1/10000)%10;
		digit5 = (num1/10)%10;
		
		System.out.println("The product second digit ("+ digit2 + ") and fifth digit (" + digit5 + ") is: " + digit2 * digit5);
	}

}