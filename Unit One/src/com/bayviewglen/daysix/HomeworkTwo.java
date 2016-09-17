package com.bayviewglen.daysix;

public class HomeworkTwo {

	public static void main(String[] args) {
		double area, perimeter, length, width;
		
		length = 4.5;
		width = 2.3;
		
		area = length * width;
		perimeter = (2*length) + (2*width);
		
		System.out.println("The area of a rectangle with a length of " + length + " feet and a width of " + width + " feet is : " + area );
		System.out.println("The perimeter of a rectangle with a length of " + length + " feet and a width of " + width + " feet is : " + perimeter );
	}

}
