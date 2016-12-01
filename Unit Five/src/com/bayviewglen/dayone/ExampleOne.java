package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleOne {

	public static void main(String[] args) {
		int x = 25;
		
		int y = sum(x);
		System.out.println(y);
		
		int z = 4;
		System.out.println(cube(z));
		
		//goodString = getAlphaNumericString();
		//System.out.println("The good string is: " + goodString);
		
		//int n = 2;
		//System.out.println("You rolled a: " + roll(n));
		
		String s = "bye";
		mystery(s);
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		mystery(arr);
	}
	
	private static void mystery(int[] a) {
		a[3] = 10;
	}

	private static void mystery(String str) {
		str = str + "hi";		
	}

	public static int roll(int numSides){
		if (numSides<3)
			throw new IllegalArgumentException("Number of sides must be at least 3...");
		int top = (int)(Math.random() * numSides) + 1;
		return top;
	}
	
	public static String getAlphaNumericString() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a sentence: ");
		String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
		String sentence = "";
		boolean isValid = false;
		while(!isValid){
			isValid = true;
			sentence = scan.nextLine().toUpperCase();
			for (int i = 0; i < sentence.length() && isValid; i++){
				if(validChars.indexOf(sentence.charAt(i)) == -1) 
					isValid = false;
			}
			if (!isValid) 
				System.out.print("Come on ... enter a sentence: ");				
		}
		return sentence;
	}

	public static int sum(int n){
		int sum = 0;
		
		for (int i = 1; i <= n; i++){
			sum += i;
		}
		
		return sum;
	}
	
	public static double cube(double x){
		return x * x * x;
	}

	
	
}
