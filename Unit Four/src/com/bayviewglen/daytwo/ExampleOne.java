package com.bayviewglen.daytwo;

public class ExampleOne {

	public static void main(String[] args) {
		String str = "CANADA";
		
		System.out.println("*" + str + "*");
		
		for (int i = 0; i < str.length(); i++){
			System.out.print(str.charAt(str.length()-i-1));
			for (int j = 0; j < str.length(); j++){
				System.out.print("*");
			}
			System.out.print(str.charAt(i));
			System.out.println();
		}
		
		System.out.print("*");
		for (int i = str.length()-1; i >= 0; i--){
			System.out.print(str.charAt(i));
		}
		System.out.println("*");
		
		int count = 0;
		String str1 = "ABChello";
		for (int i = 0; i < str1.length()-4; i++){
			if (str1.substring(i,i+5).equals("hello")) count++;
		}
		System.out.println(count);
	}

}
