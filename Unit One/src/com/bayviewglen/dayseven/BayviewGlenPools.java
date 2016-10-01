package com.bayviewglen.dayseven;

import java.util.Scanner;

public class BayviewGlenPools {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Setting all variables to 0 for Exception Handling to work//
		
		double lengthPool = 0, widthPool = 0, depthShallow = 0, depthDeep = 0, lengthTransition = 0, lengthShallow = 0, priceLiner1 = 0, priceLiner2 = 0, priceLiner3 = 0;
		
		//USER INPUT//
		
		double diffHeight = 0;
		try {
			System.out.print("Please enter the length of the pool: ");
			lengthPool = scan.nextDouble();
			
			System.out.print("Please enter the width of the pool: ");
			widthPool = scan.nextDouble();
			
			System.out.print("Please enter the depth of the shallow end of the pool: ");
			depthShallow = scan.nextDouble();
			
			System.out.print("Please enter the depth of the deep end of the pool: ");
			depthDeep = scan.nextDouble();
			
			if (depthDeep < depthShallow){
				System.err.println("Please enter a value larger than the depth of the shallow end! Try again.");
				System.exit(1);
			}
			
			System.out.print("Please enter the length of the transition between the deep end and the shallow end: ");
			lengthTransition = scan.nextDouble();
			
			System.out.print("Please enter the length of the shallow end of the pool: ");
			lengthShallow = scan.nextDouble();
			
			diffHeight = depthDeep - depthShallow;
			double delta = Math.sqrt((lengthTransition * lengthTransition) - (diffHeight * diffHeight));
			
			if ((delta + lengthShallow) > lengthPool){
				System.err.println("The values for the lengths entered are incorrect!");
				System.exit(1);
			}
			
			System.out.print("Please enter the price of the first liner: ");
			priceLiner1 = scan.nextDouble();

			System.out.print("Please enter the price of the second liner: ");
			priceLiner2 = scan.nextDouble();
			
			System.out.print("Please enter the price of the third liner: ");
			priceLiner3 = scan.nextDouble();
		} catch (Exception e) {
			System.err.println("Nice try. Invalid Entry. Restart the program.");
			System.exit(1);
			//e.printStackTrace();
		}
	
		//VOLUME//
		
		double volumePool; 
		
		final double PERCENT_POOL = 0.9;
		final double TO_LITRES = 1000;
		
		volumePool = TO_LITRES * (PERCENT_POOL *((lengthPool * depthDeep * widthPool) - ((Math.sqrt((Math.pow(lengthShallow, 2) - Math.pow(diffHeight, 2))) * diffHeight * widthPool) + (lengthTransition * diffHeight * widthPool)/2)));
		
		System.out.printf("%nThe volume of pool 90%% full is: %.3f litres.", volumePool);
		
		//SURFACE AREA//
		
		double areaSideDeep, areaSideShallow, areaBottom, areaSide, surfaceArea;
		
		areaBottom = lengthPool * widthPool;
		areaSideDeep = widthPool * depthDeep;
		areaSideShallow = widthPool * depthShallow;
		areaSide = ((lengthPool * depthDeep * widthPool) - ((lengthShallow * diffHeight * widthPool) + ((Math.sqrt((Math.pow(lengthShallow, 2) - Math.pow(diffHeight, 2))) * diffHeight * widthPool) + (lengthTransition * diffHeight * widthPool)/2)));
		surfaceArea = areaBottom + areaSideDeep + areaSideShallow + (areaSide*2);
		
		//CHECK//
		
		//System.out.println();
		//System.out.println(areaBottom + ", " + areaSideDeep + ", " + areaSideShallow + ", " + areaSide);
		
		System.out.println();
		System.out.printf("The amount of liner needed to cover the pool is: %.3f m^2", surfaceArea);
	
		//PRICE OF LINER//
	
		double costLiner1, costLiner2, costLiner3;
		
		costLiner1 = priceLiner1 * surfaceArea; 
		costLiner2 = priceLiner2 * surfaceArea;
		costLiner3 = priceLiner3 * surfaceArea;
		
		System.out.printf("%nThe cost of the first liner is: $%.3f", costLiner1);
		System.out.printf("%nThe cost of the second liner is: $%.3f", costLiner2);
		System.out.printf("%nThe cost of the third liner is: $%.3f", costLiner3);
		
		//IF STATEMENTS//
		
		System.out.println();
		
		if (costLiner1 < costLiner2 && costLiner1 < costLiner3){
			System.out.printf("The cheapest liner is: $%.3f", costLiner1);
		}
		else if (costLiner2 < costLiner1 && costLiner2 < costLiner3){
			System.out.printf("The cheapest liner is: $%.3f", costLiner2);
		}
		else if (costLiner3 < costLiner1 && costLiner3 < costLiner2){
			System.out.printf("The cheapest liner is: $%.3f", costLiner3);
		}
		
		scan.close();
	}

}
