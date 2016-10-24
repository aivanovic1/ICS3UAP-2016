package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleTwo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Two numbers please: ");
		int x = keyboard.nextInt();
		int y = keyboard.nextInt();
		
		int low, high;
		if (x > y){
			low = y;
			high = x;
		}else{
			low = x;
			high = y;
		}
		
		int sum = 0;
		int current = low;
		while(current<=high){
			sum += current;
			current++;
		}
		System.out.println(sum);
		
	}

}
