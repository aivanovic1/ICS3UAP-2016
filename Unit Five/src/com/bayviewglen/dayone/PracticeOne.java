package com.bayviewglen.dayone;

import java.util.Arrays;

public class PracticeOne {

	public static void main(String[] args) {
		if (isPhone("(416) 222 2212")) System.out.println("true");
		else System.out.println("false");
		int [] a = {4, 3, 2, 1, 7, 8, 9};
		Arrays.sort(a);
		for (int b: a) System.out.print(b + " ");
		String[] list = {"andrei", "miles", "penelope", "rodin", "zachary"};
		String name = "chad";
		System.out.println();
		for (String s: alphaOrder(name, list)) System.out.print(s + ", ");
	}	
	
	public static boolean isPhone(String str){
		String num = "";
		if (str.length() == 14){
			for (int i = 0; i < str.length(); i++){
				char c = str.charAt(i); 
				if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == ' ') continue;
				else num += c;
			}
		}
		try {
			long numTry = Long.parseLong(num);
		} catch (Exception e) {
			System.out.println("Error!");
			return false;
		}
		return true;
	}
	
	public static void sort(int[] nonSort){
	    int[] sorted = new int[nonSort.length];
	    int temp;
	    for (int i = 0; i < nonSort.length - 1; i++) {
	    	for (int j = i+1; j < nonSort.length; j++){
	    		if (nonSort[i] > nonSort[j]) {
	    			temp = nonSort[i];
	    			nonSort[i] = nonSort[j];
	    			nonSort[j] = temp;
	    			sorted = nonSort;
	    		}
	    	}
	    }
	    for (int a : sorted) System.out.print(a + " ");  
	}	
	
	public static String[] alphaOrder(String name, String[] list){
		boolean spot = false;
		int temp = 0;
		String[] listNew = new String[list.length+1];
		while (!spot){
			for (int i = 0; i < list.length; i++){
				if (name.compareTo(list[i]) < 0){
					temp = i;
					break;
				}
			}
			listNew[temp] = name;
			for (int i = 0; i < temp; i++){
				listNew[i] = list[i];
			}
			for (int i = temp+1; i < listNew.length; i++){
				listNew[i] = list[i-1];
			}
			spot = true;
		}
	
		return listNew;
	}
}
