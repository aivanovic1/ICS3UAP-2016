package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkTen {

	public static void main(String[] args) {
		double area, perimeter, length, width;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter the dimensions of the rectangle (length, width): ");
		length = scan.nextDouble();
		width = scan.nextDouble();
	
		area = length * width;
		perimeter = (2*length) + (2*width);
		
		System.out.println("The area of a rectangle with a length of " + length + " feet and a width of " + width + " feet is : " + area );
		System.out.println("The perimeter of a rectangle with a length of " + length + " feet and a width of " + width + " feet is : " + perimeter );

		scan.close();
	}

}
