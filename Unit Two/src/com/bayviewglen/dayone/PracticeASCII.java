package com.bayviewglen.dayone;

import java.util.Scanner;

public class PracticeASCII {

	public static void main(String[] args) {
		
		final int HUNDRED = 100;
		final int MIN_FIFTY = 50;
		final int ADJUST = 1;
		final int MAX_HUNDRED_ONE = 101;
		final int NUM_SIDES = 6;
		final int UPPER_A = 65;
		final int UPPER_Z = 90;
		final int LOWER_A = 97;
		final int LOWER_Z = 122;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Random Number from 1 - 100: " + ((int)(Math.random() * HUNDRED) + ADJUST));
		System.out.println("Random Number from -50 - 50: " + (MIN_FIFTY -(int)(Math.random() * MAX_HUNDRED_ONE)));
		
		int max, min;
		
		System.out.println("Please enter two numbers (max and min): ");
		max = scan.nextInt();
		min = scan.nextInt();
		
		System.out.println("Here's a random number between the two numbers you entered: " + (min + (int)(Math.random() * ((max-min) + ADJUST))));

		System.out.println("Random side of a die: " + ((int)(Math.random() * NUM_SIDES) + ADJUST));
		
		scan.close();
		
		String s;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a sting: ");
		s = keyboard.next();
		
		System.out.println("Random letter from your string: " + (s.charAt((int)(Math.random() * s.length()))));
		
		System.out.println("Random uppercase letter: " + (char)(UPPER_A + (int)(Math.random() * ((UPPER_Z - UPPER_A) + ADJUST))));
		System.out.println("Random lowercase letter: " + (char)(LOWER_A + (int)(Math.random() * ((LOWER_Z - LOWER_A) + ADJUST))));
	
		keyboard.close();
	}

}
