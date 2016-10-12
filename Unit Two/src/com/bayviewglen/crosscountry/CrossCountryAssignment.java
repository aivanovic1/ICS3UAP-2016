package com.bayviewglen.crosscountry;

import java.util.Scanner;
import java.text.DecimalFormat;

public class CrossCountryAssignment {

	static final int SECONDS_IN_MINUTES = 60;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RUNNER~ONE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		System.out.print("Enter your first name and last name: ");
		String runnerOneNames = scan.nextLine();
		String runnerOneFirstName = runnerOneNames.split(" ")[0];
		String runnerOneLastName = runnerOneNames.split(" ")[1];

		System.out.print(runnerOneFirstName + ", enter a time for the first mile (m:ss.sss): ");
		String runnerOneTimeMile1 = scan.nextLine();
		int runnerOneMinutesMile1 = Integer.parseInt(runnerOneTimeMile1.split(":")[0]);
		double runnerOneSecondsMile1 = Double.parseDouble(runnerOneTimeMile1.split(":")[1]);

		System.out.print(runnerOneFirstName + ", enter a time for the second mile (m:ss.sss): ");
		String runnerOneTimeMile2 = scan.nextLine();
		int runnerOneMinutesMile2 = Integer.parseInt(runnerOneTimeMile2.split(":")[0]);
		double runnerOneSecondsMile2 = Double.parseDouble(runnerOneTimeMile2.split(":")[1]);

		System.out.print(runnerOneFirstName + ", enter your final mile time (m:ss.sss): ");
		String runnerOneTimeMile3 = scan.nextLine();
		int runnerOneMinutesMile3 = Integer.parseInt(runnerOneTimeMile3.split(":")[0]);
		double runnerOneSecondsMile3 = Double.parseDouble(runnerOneTimeMile3.split(":")[1]);

		DecimalFormat formatter = new DecimalFormat("00.000");

		// Split 1 Math//

		double runnerOneTotalSecondsMile1 = runnerOneMinutesMile1 * SECONDS_IN_MINUTES + runnerOneSecondsMile1;

		// Split 2 Math//

		double runnerOneTotalSecondsMile2 = runnerOneMinutesMile2 * SECONDS_IN_MINUTES + runnerOneSecondsMile2;
		double runnerOneTotalSecondsSplit2 = runnerOneTotalSecondsMile2 - runnerOneTotalSecondsMile1;
		int runnerOneMinutesSplit2 = (int) (runnerOneTotalSecondsSplit2 / SECONDS_IN_MINUTES);
		double runnerOneSecondsSplit2 = runnerOneTotalSecondsSplit2 % SECONDS_IN_MINUTES;

		String runnerOneSplit2 = runnerOneMinutesSplit2 + ":" + formatter.format(runnerOneSecondsSplit2);

		// Split 3 Math//

		double runnerOneTotalSecondsMileFinal = runnerOneMinutesMile3 * SECONDS_IN_MINUTES + runnerOneSecondsMile3;
		double runnerOneTotalSecondsSplitFinal = runnerOneTotalSecondsMileFinal - runnerOneTotalSecondsMile2;
		int runnerOneMinutesSplitFinal = (int) (runnerOneTotalSecondsSplitFinal / SECONDS_IN_MINUTES);
		double runnerOneSecondsSplitFinal = runnerOneTotalSecondsSplitFinal % SECONDS_IN_MINUTES;

		String runnerOneSplit3 = runnerOneMinutesSplitFinal + ":" + formatter.format(runnerOneSecondsSplitFinal);

		// Runner One Summary//

		System.out.println("\nRunner One Summary:");
		System.out.println("***************************");
		System.out.println("Runner Name: " + runnerOneLastName + ", " + runnerOneFirstName);
		System.out.println("Split One: " + runnerOneTimeMile1);
		System.out.println("Split Two: " + runnerOneSplit2);
		System.out.println("Split Three: " + runnerOneSplit3);
		System.out.println("Total: " + runnerOneTimeMile3 + "\n");

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RUNNER~TWO~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		System.out.print("Enter your first name and last name: ");
		String runnerTwoNames = scan.nextLine();
		String runnerTwoFirstName = runnerTwoNames.split(" ")[0];
		String runnerTwoLastName = runnerTwoNames.split(" ")[1];

		System.out.print(runnerTwoFirstName + ", enter a time for the first mile (m:ss.sss): ");
		String runnerTwoTimeMile1 = scan.nextLine();
		int runnerTwoMinutesMile1 = Integer.parseInt(runnerTwoTimeMile1.split(":")[0]);
		double runnerTwoSecondsMile1 = Double.parseDouble(runnerTwoTimeMile1.split(":")[1]);

		System.out.print(runnerTwoFirstName + ", enter a time for the second mile (m:ss.sss): ");
		String runnerTwoTimeMile2 = scan.nextLine();
		int runnerTwoMinutesMile2 = Integer.parseInt(runnerTwoTimeMile2.split(":")[0]);
		double runnerTwoSecondsMile2 = Double.parseDouble(runnerTwoTimeMile2.split(":")[1]);

		System.out.print(runnerTwoFirstName + ", enter your final mile time (m:ss.sss): ");
		String runnerTwoTimeMile3 = scan.nextLine();
		int runnerTwoMinutesMile3 = Integer.parseInt(runnerTwoTimeMile3.split(":")[0]);
		double runnerTwoSecondsMile3 = Double.parseDouble(runnerTwoTimeMile3.split(":")[1]);

		// Split 1 Math//

		double runnerTwoTotalSecondsMile1 = runnerTwoMinutesMile1 * SECONDS_IN_MINUTES + runnerTwoSecondsMile1;

		// Split 2 Math//

		double runnerTwoTotalSecondsMile2 = runnerTwoMinutesMile2 * SECONDS_IN_MINUTES + runnerTwoSecondsMile2;
		double runnerTwoTotalSecondsSplit2 = runnerTwoTotalSecondsMile2 - runnerTwoTotalSecondsMile1;
		int runnerTwoMinutesSplit2 = (int) (runnerTwoTotalSecondsSplit2 / SECONDS_IN_MINUTES);
		double runnerTwoSecondsSplit2 = runnerTwoTotalSecondsSplit2 % SECONDS_IN_MINUTES;

		String runnerTwoSplit2 = runnerTwoMinutesSplit2 + ":" + formatter.format(runnerTwoSecondsSplit2);

		// Split 3 Math//

		double runnerTwoTotalSecondsMileFinal = runnerTwoMinutesMile3 * SECONDS_IN_MINUTES + runnerTwoSecondsMile3;
		double runnerTwoTotalSecondsSplitFinal = runnerTwoTotalSecondsMileFinal - runnerTwoTotalSecondsMile2;
		int runnerTwoMinutesSplitFinal = (int) (runnerTwoTotalSecondsSplitFinal / SECONDS_IN_MINUTES);
		double runnerTwoSecondsSplitFinal = runnerTwoTotalSecondsSplitFinal % SECONDS_IN_MINUTES;

		String runnerTwoSplit3 = runnerTwoMinutesSplitFinal + ":" + formatter.format(runnerTwoSecondsSplitFinal);

		// Runner Two Summary//

		System.out.println("\nRunner Two Summary:");
		System.out.println("***************************");
		System.out.println("Runner Name: " + runnerTwoLastName + ", " + runnerTwoFirstName);
		System.out.println("Split One: " + runnerTwoTimeMile1);
		System.out.println("Split Two: " + runnerTwoSplit2);
		System.out.println("Split Three: " + runnerTwoSplit3);
		System.out.println("Total: " + runnerTwoTimeMile3 + "\n");

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RUNNER~THREE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		System.out.print("Enter your first name and last name: ");
		String runnerThreeNames = scan.nextLine();
		String runnerThreeFirstName = runnerThreeNames.split(" ")[0];
		String runnerThreeLastName = runnerThreeNames.split(" ")[1];

		System.out.print(runnerThreeFirstName + ", enter a time for the first mile (m:ss.sss): ");
		String runnerThreeTimeMile1 = scan.nextLine();
		int runnerThreeMinutesMile1 = Integer.parseInt(runnerThreeTimeMile1.split(":")[0]);
		double runnerThreeSecondsMile1 = Double.parseDouble(runnerThreeTimeMile1.split(":")[1]);

		System.out.print(runnerThreeFirstName + ", enter a time for the second mile (m:ss.sss): ");
		String runnerThreeTimeMile2 = scan.nextLine();
		int runnerThreeMinutesMile2 = Integer.parseInt(runnerThreeTimeMile2.split(":")[0]);
		double runnerThreeSecondsMile2 = Double.parseDouble(runnerThreeTimeMile2.split(":")[1]);

		System.out.print(runnerThreeFirstName + ", enter your final mile time (m:ss.sss): ");
		String runnerThreeTimeMile3 = scan.nextLine();
		int runnerThreeMinutesMile3 = Integer.parseInt(runnerThreeTimeMile3.split(":")[0]);
		double runnerThreeSecondsMile3 = Double.parseDouble(runnerThreeTimeMile3.split(":")[1]);

		// Split 1 Math//

		double runnerThreeTotalSecondsMile1 = runnerThreeMinutesMile1 * SECONDS_IN_MINUTES + runnerThreeSecondsMile1;

		// Split 2 Math//

		double runnerThreeTotalSecondsMile2 = runnerThreeMinutesMile2 * SECONDS_IN_MINUTES + runnerThreeSecondsMile2;
		double runnerThreeTotalSecondsSplit2 = runnerThreeTotalSecondsMile2 - runnerThreeTotalSecondsMile1;
		int runnerThreeMinutesSplit2 = (int) (runnerThreeTotalSecondsSplit2 / SECONDS_IN_MINUTES);
		double runnerThreeSecondsSplit2 = runnerThreeTotalSecondsSplit2 % SECONDS_IN_MINUTES;

		String runnerThreeSplit2 = runnerThreeMinutesSplit2 + ":" + formatter.format(runnerThreeSecondsSplit2);

		// Split 3 Math//

		double runnerThreeTotalSecondsMileFinal = runnerThreeMinutesMile3 * SECONDS_IN_MINUTES
				+ runnerThreeSecondsMile3;
		double runnerThreeTotalSecondsSplitFinal = runnerThreeTotalSecondsMileFinal - runnerThreeTotalSecondsMile2;
		int runnerThreeMinutesSplitFinal = (int) (runnerThreeTotalSecondsSplitFinal / SECONDS_IN_MINUTES);
		double runnerThreeSecondsSplitFinal = runnerThreeTotalSecondsSplitFinal % SECONDS_IN_MINUTES;

		String runnerThreeSplit3 = runnerThreeMinutesSplitFinal + ":" + formatter.format(runnerThreeSecondsSplitFinal);

		// Runner Three Summary//

		System.out.println("\nRunner Three Summary:");
		System.out.println("***************************");
		System.out.println("Runner Name: " + runnerThreeLastName + ", " + runnerThreeFirstName);
		System.out.println("Split One: " + runnerThreeTimeMile1);
		System.out.println("Split Two: " + runnerThreeSplit2);
		System.out.println("Split Three: " + runnerThreeSplit3);
		System.out.println("Total: " + runnerThreeTimeMile3 + "\n");

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RUNNER~FOUR~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		System.out.print("Enter your first name and last name: ");
		String runnerFourNames = scan.nextLine();
		String runnerFourFirstName = runnerFourNames.split(" ")[0];
		String runnerFourLastName = runnerFourNames.split(" ")[1];

		System.out.print(runnerFourFirstName + ", enter a time for the first mile (m:ss.sss): ");
		String runnerFourTimeMile1 = scan.nextLine();
		int runnerFourMinutesMile1 = Integer.parseInt(runnerFourTimeMile1.split(":")[0]);
		double runnerFourSecondsMile1 = Double.parseDouble(runnerFourTimeMile1.split(":")[1]);

		System.out.print(runnerFourFirstName + ", enter a time for the second mile (m:ss.sss): ");
		String runnerFourTimeMile2 = scan.nextLine();
		int runnerFourMinutesMile2 = Integer.parseInt(runnerFourTimeMile2.split(":")[0]);
		double runnerFourSecondsMile2 = Double.parseDouble(runnerFourTimeMile2.split(":")[1]);

		System.out.print(runnerFourFirstName + ", enter your final mile time (m:ss.sss): ");
		String runnerFourTimeMile3 = scan.nextLine();
		int runnerFourMinutesMile3 = Integer.parseInt(runnerFourTimeMile3.split(":")[0]);
		double runnerFourSecondsMile3 = Double.parseDouble(runnerFourTimeMile3.split(":")[1]);

		// Split 1 Math//

		double runnerFourTotalSecondsMile1 = runnerFourMinutesMile1 * SECONDS_IN_MINUTES + runnerFourSecondsMile1;

		// Split 2 Math//

		double runnerFourTotalSecondsMile2 = runnerFourMinutesMile2 * SECONDS_IN_MINUTES + runnerFourSecondsMile2;
		double runnerFourTotalSecondsSplit2 = runnerFourTotalSecondsMile2 - runnerFourTotalSecondsMile1;
		int runnerFourMinutesSplit2 = (int) (runnerFourTotalSecondsSplit2 / SECONDS_IN_MINUTES);
		double runnerFourSecondsSplit2 = runnerFourTotalSecondsSplit2 % SECONDS_IN_MINUTES;

		String runnerFourSplit2 = runnerFourMinutesSplit2 + ":" + formatter.format(runnerFourSecondsSplit2);

		// Split 3 Math//

		double runnerFourTotalSecondsMileFinal = runnerFourMinutesMile3 * SECONDS_IN_MINUTES + runnerFourSecondsMile3;
		double runnerFourTotalSecondsSplitFinal = runnerFourTotalSecondsMileFinal - runnerFourTotalSecondsMile2;
		int runnerFourMinutesSplitFinal = (int) (runnerFourTotalSecondsSplitFinal / SECONDS_IN_MINUTES);
		double runnerFourSecondsSplitFinal = runnerFourTotalSecondsSplitFinal % SECONDS_IN_MINUTES;

		String runnerFourSplit3 = runnerFourMinutesSplitFinal + ":" + formatter.format(runnerFourSecondsSplitFinal);

		// Runner Four Summary//

		System.out.println("\nRunner Four Summary:");
		System.out.println("***************************");
		System.out.println("Runner Name: " + runnerFourLastName + ", " + runnerFourFirstName);
		System.out.println("Split One: " + runnerFourTimeMile1);
		System.out.println("Split Two: " + runnerFourSplit2);
		System.out.println("Split Three: " + runnerFourSplit3);
		System.out.println("Total: " + runnerFourTimeMile3 + "\n");

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RUNNER~FIVE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		System.out.print("Enter your first name and last name: ");
		String runnerFiveNames = scan.nextLine();
		String runnerFiveFirstName = runnerFiveNames.split(" ")[0];
		String runnerFiveLastName = runnerFiveNames.split(" ")[1];

		System.out.print(runnerFiveFirstName + ", enter a time for the first mile (m:ss.sss): ");
		String runnerFiveTimeMile1 = scan.nextLine();
		int runnerFiveMinutesMile1 = Integer.parseInt(runnerFiveTimeMile1.split(":")[0]);
		double runnerFiveSecondsMile1 = Double.parseDouble(runnerFiveTimeMile1.split(":")[1]);

		System.out.print(runnerFiveFirstName + ", enter a time for the second mile (m:ss.sss): ");
		String runnerFiveTimeMile2 = scan.nextLine();
		int runnerFiveMinutesMile2 = Integer.parseInt(runnerFiveTimeMile2.split(":")[0]);
		double runnerFiveSecondsMile2 = Double.parseDouble(runnerFiveTimeMile2.split(":")[1]);

		System.out.print(runnerFiveFirstName + ", enter your final mile time (m:ss.sss): ");
		String runnerFiveTimeMile3 = scan.nextLine();
		int runnerFiveMinutesMile3 = Integer.parseInt(runnerFiveTimeMile3.split(":")[0]);
		double runnerFiveSecondsMile3 = Double.parseDouble(runnerFiveTimeMile3.split(":")[1]);

		// Split 1 Math//

		double runnerFiveTotalSecondsMile1 = runnerFiveMinutesMile1 * SECONDS_IN_MINUTES + runnerFiveSecondsMile1;

		// Split 2 Math//

		double runnerFiveTotalSecondsMile2 = runnerFiveMinutesMile2 * SECONDS_IN_MINUTES + runnerFiveSecondsMile2;
		double runnerFiveTotalSecondsSplit2 = runnerFiveTotalSecondsMile2 - runnerFiveTotalSecondsMile1;
		int runnerFiveMinutesSplit2 = (int) (runnerFiveTotalSecondsSplit2 / SECONDS_IN_MINUTES);
		double runnerFiveSecondsSplit2 = runnerFiveTotalSecondsSplit2 % SECONDS_IN_MINUTES;

		String runnerFiveSplit2 = runnerFiveMinutesSplit2 + ":" + formatter.format(runnerFiveSecondsSplit2);

		// Split 3 Math//

		double runnerFiveTotalSecondsMileFinal = runnerFiveMinutesMile3 * SECONDS_IN_MINUTES + runnerFiveSecondsMile3;
		double runnerFiveTotalSecondsSplitFinal = runnerFiveTotalSecondsMileFinal - runnerFiveTotalSecondsMile2;
		int runnerFiveMinutesSplitFinal = (int) (runnerFiveTotalSecondsSplitFinal / SECONDS_IN_MINUTES);
		double runnerFiveSecondsSplitFinal = runnerFiveTotalSecondsSplitFinal % SECONDS_IN_MINUTES;

		String runnerFiveSplit3 = runnerFiveMinutesSplitFinal + ":" + formatter.format(runnerFiveSecondsSplitFinal);

		// Runner Five Summary//

		System.out.println("\nRunner Five Summary:");
		System.out.println("***************************");
		System.out.println("Runner Name: " + runnerFiveLastName + ", " + runnerFiveFirstName);
		System.out.println("Split One: " + runnerFiveTimeMile1);
		System.out.println("Split Two: " + runnerFiveSplit2);
		System.out.println("Split Three: " + runnerFiveSplit3);
		System.out.println("Total: " + runnerFiveTimeMile3 + "\n");

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~FINAL~RESULTS~TABLE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		System.out.println(
				"--------------------+---------------------+-------------------------+-----------------------+------------------+");
		System.out.println("Runner Name: \t\tSplit One Time: \tSplit Two Time: \tSplit Three Time: \tTotal Time: ");
		System.out.println(
				"--------------------+---------------------+-------------------------+-----------------------+------------------+");
		System.out.printf("%s| %-20s| %-24s| %-22s| %-17s|%n",
				(runnerOneLastName + ", " + runnerOneFirstName + "                    ").substring(0, 20),
				runnerOneTimeMile1, runnerOneSplit2, runnerOneSplit3, runnerOneTimeMile3);
		System.out.printf("%s| %-20s| %-24s| %-22s| %-17s|%n",
				(runnerTwoLastName + ", " + runnerTwoFirstName + "                    ").substring(0, 20),
				runnerTwoTimeMile1, runnerTwoSplit2, runnerTwoSplit3, runnerTwoTimeMile3);
		System.out.printf("%s| %-20s| %-24s| %-22s| %-17s|%n",
				(runnerThreeLastName + ", " + runnerThreeFirstName + "                    ").substring(0, 20),
				runnerThreeTimeMile1, runnerThreeSplit2, runnerThreeSplit3, runnerThreeTimeMile3);
		System.out.printf("%s| %-20s| %-24s| %-22s| %-17s|%n",
				(runnerFourLastName + ", " + runnerFourFirstName + "                    ").substring(0, 20),
				runnerFourTimeMile1, runnerFourSplit2, runnerFourSplit3, runnerFourTimeMile3);
		System.out.printf("%s| %-20s| %-24s| %-22s| %-17s|%n",
				(runnerFiveLastName + ", " + runnerFiveFirstName + "                    ").substring(0, 20),
				runnerFiveTimeMile1, runnerFiveSplit2, runnerFiveSplit3, runnerFiveTimeMile3);
		System.out.println(
				"--------------------+---------------------+-------------------------+-----------------------+------------------+");

		scan.close();
	}

}
