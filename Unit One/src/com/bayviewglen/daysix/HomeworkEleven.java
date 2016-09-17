package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkEleven {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double kineticEnergy, mass, velocity;
		
		System.out.print("Please enter the mass and velocity of the moving object: ");
		mass = scan.nextDouble();
		velocity = scan.nextDouble();
		
		kineticEnergy = 0.5*mass*velocity*velocity;
		
		System.out.println("The kinetic energy of the moving object is: " + kineticEnergy);

		scan.close();
	}

}
