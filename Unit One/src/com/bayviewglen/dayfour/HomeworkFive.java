package com.bayviewglen.dayfour;

public class HomeworkFive {

	public static void main(String[] args) {
		double x, y, z;
		int i, j, k;
		
		x = 5.5;
		y = 3.0;
		z = -2.0;
		i = 5;
		j = 4;
		k = 3;
		
		//5a.//
		
		double a1 = i - j;
		double b1 = i - a1;
		double c1 = i - b1;
		double d1 = i - c1;
		
		System.out.println("The final result is : " + d1);
		
		//5b.//
		
		double a2 = i - j;
		double b2 = x + a2;
		double c2 = x - y;
		double d2 = b2 * c2;
		
		System.out.println("The final result is : " + d2);
		
		//5c.//
		
		double a3 = x - y;
		double b3 = y - x;
		double c3 = a3 - b3 - a3 - b3;
		
		System.out.println("The final result is : " + c3);
		
		//5d.//
		
		double a4 = a3 - b3;
		double b4 = b3 - a4;
		double c4 = a3 - b4;
		
		System.out.println("The final result is : " + c4);
		
		//5h.//
		
		int a5 = j / k;
		double b5 = (double) i + a5;
		
		System.out.println("The final result is : " + b5);
		
		//5i.//
		
		int a6 = (int)x/k;
		double b6 = x/k;
		double c6 = a6 - b6;
		
		System.out.println("The final result is : " + c6);
		
		//5j.//
		
		double a7 = (double) i/j;
		double b7 = (double) (i/j);
		double c7 = a7 - b7;
		
		System.out.println("The final result is : " + c7);
		
	}

}
