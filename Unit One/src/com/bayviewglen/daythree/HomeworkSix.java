package com.bayviewglen.daythree;

public class HomeworkSix {

	public static void main(String[] args) {
		double a,b,c,x1,x2,s;
		
		a = 3;
		b = 12;
		c = 7;
		
		s = Math.sqrt((b*b) - 4.0 * a * c);
		
		x1 = (-b + s)/2.0 * a;
		
		x2 = (-b - s)/2.0 * a;
		
		System.out.println("The roots are: " + x1 + " and " + x2 + ", given the values of a = " + a + " and b = " + b + " and c = " + c);

	}

}
