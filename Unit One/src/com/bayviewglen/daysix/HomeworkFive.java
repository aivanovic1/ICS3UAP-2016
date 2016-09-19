package com.bayviewglen.daysix;

public class HomeworkFive {

	public static void main(String[] args) {
		double winPercentage, wins, losses;
		
		wins = 110;
		losses = 44;
		
		winPercentage = (wins/(wins + losses))*100;
		
		System.out.printf("The 1927 New York Yankees' win perentage is: " + "%.3f", winPercentage);

	}

}
