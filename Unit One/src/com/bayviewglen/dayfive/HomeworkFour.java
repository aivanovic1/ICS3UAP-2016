package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkFour {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter the initial velocity, the acceleration, and the time (in that order): ");
		
		double vInitial, a, t;
		
		vInitial = scan.nextDouble();
		a = scan.nextDouble();
		t = scan.nextDouble();
		
		double vFinal = vInitial + a*t;
		
		System.out.println("The value of the final velocity is: " + vFinal + "m/s");

		scan.close();
	}

}