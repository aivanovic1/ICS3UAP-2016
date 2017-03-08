package com.bayviewglen.horseracing; 	

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * 
 * @author aivanovic - Andrei Ivanovic
 * Special Feature: Music and Odds of each Horse (multiplies your winning by that much)
 *
 */
public class HorseRacing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		introMessage();
		String[] horses = getHorses();
		String[] playerNames = getPlayerNames();
		float[] horseOdds = getHorseOdds();
		int[] playerWallets = getPlayerWallets();
		
		//printHorsesAndOdds(horses, horseOdds);
		
		boolean gameOver = false;
		while(!gameOver){
			doRace(scan, horses, playerNames, playerWallets, horseOdds);
			updatePlayerData(playerNames, playerWallets);
			gameOver = promptForGameOver(scan);
		}
		
		closingMessage();
		scan.close();
	}
	
	/**
	 * Plays music.
	 * @return AudioStream (stream to play music)
	 */
    public static AudioStream music(){
       AudioStream stream = null;
       
       try{
          stream = new AudioStream(new FileInputStream("input/music.wav"));
          AudioPlayer.player.start(stream);
          //MD = BGM.getData();
          //loop = new ContinuousAudioDataStream(MD);
       }catch(IOException error){
           System.out.print(error.getMessage());
       }
       return stream;
    }
	
	/**
	 * Prints the horses and their odds for testing purposes.	
	 * @param horses - array of horses (names)
	 * @param horseOdds - array containing the odds of every horse (2.00 is the default odd)
	 */
	private static void printHorsesAndOdds(String[] horses, float[] horseOdds) {
		for (int i = 0; i < horses.length; i++){
			System.out.printf("[%s] - %5.2f%n", horses[i], horseOdds[i]);
		}
	}
	
	/**
	 * Prints the 2D array of people who bet, how much they bet, and the amount they bet for testing purposes.
	 * @param playerBets 
	 * @param playerNames - array of player names
	 * @param horses - array of horses (names)
	 * @param horsesInRace - array of indexes of horses in the race
	 */
	private static void printBettingTable(int[][] playerBets, String[] playerNames, String[] horses, int[] horsesInRace){
		System.out.printf("%n%13s", " ");
		for (int a : horsesInRace){
			System.out.printf("%10s", horses[a]);
		}
		for (int i = 0; i < playerNames.length; i++){
			System.out.printf("%n%d|%-10s|", i+1, playerNames[i]);
			for (int j = 0; j < horsesInRace.length; j++){
				System.out.printf("%10d", playerBets[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints closing message.
	 */
	private static void closingMessage() {
		System.out.println("THANK YOU FOR RACING, YOUR PROGRESS HAS BEEN SAVED!");
		System.out.printf("%n%n%nSEE YOU NEXT TIME AT THE RACES!");
	}

	/**
	 * Prints introductory message.
	 */
	private static void introMessage() {
		System.out.println("WELCOME TO HORSE RACING, 18 OR OVER TO PLAY!");	
	}
	
	/**
	 * Saves the player data by rewriting the file.
	 * @param playerNames - array of player names
	 * @param playerWallets - array containing amount of money in each player's wallet
	 */
	private static void updatePlayerData(String[] playerNames, int[] playerWallets) {
		try{
		    PrintWriter writer = new PrintWriter("input/player.dat", "UTF-8");
		    writer.println(playerNames.length);
		    for (int i = 0; i < playerNames.length; i++){
		    	writer.println(playerNames[i] + " " + playerWallets[i]);
		    } 
		    writer.close();
		} catch (IOException e) {
		   e.printStackTrace();
		}
		System.out.println("Your progress has been saved!");
	}
	
	/**
	 * Asks the player whether or not they want to stop playing
	 * @param scan - Scanner
	 * @return boolean indicating whether or not they wish to end the game
	 */
	private static boolean promptForGameOver(Scanner scan) { //CRASHES IF YOU TYPE IN LETTERS
		int response = -1;
		while(response < 1){
			System.out.print("Please type (1) if you wish to continue playing, or (2) to stop: ");
			String line = scan.nextLine();
			try {
				response = Integer.parseInt(line);
				if (response < 1){
					System.out.print("Invalid entry! ");
					response = -1;
				}
			} catch (NumberFormatException e) {
				System.out.print("Invalid entry! Try again, ");
				response = -1;
				//e.printStackTrace();
			}
					
			if(response == 1)
				return false;
			else if (response == 2)
				return true;
			else{
				System.out.print("Please enter a valid response: ");
				response = 0;
			}
		}
		
		return false;
	}

	/**
	 * Main function for racing, goes through the race (asks for bets, starts the race, and asks them whether or not they want to continue)
	 * @param scan - Scanner
	 * @param horses - array of horse names
	 * @param playerNames - array of player names
	 * @param playerWallets - array containing amount of money in each player's wallet
	 * @param horseOdds - array of odds for each horse (2.00 is the default odd)
	 */
	private static void doRace(Scanner scan, String[] horses, String[] playerNames, int[] playerWallets, float[] horseOdds) {
		// horsesInRace contains the index of the horses from the master horse array
		int[] horsesInRace = getHorsesInRace(horses);
		
		// 2D array with col0 = betAmount and col1 = horseIndex(from horsesInRace)
		int[][] playerBets = new int[playerNames.length][horsesInRace.length];
		int winningHorse = -1;
		
		int playerOption = -1;
		while(playerOption == -1){
			playerOption = getPlayerBets(scan, playerBets, playerNames, playerWallets, horsesInRace, horses, horseOdds);
			if (playerOption == 2){
				winningHorse = startRace(horsesInRace, horses);
				System.out.println(horses[horsesInRace[winningHorse]] + " is the WINNER!");
				payOutBets(playerBets, playerWallets, playerNames, winningHorse, horseOdds, horsesInRace);
				updatePlayerData(playerNames, playerWallets);
			}
			if (playerOption == 3){
				System.out.printf("%n%n%nSEE YOU NEXT TIME AT THE RACES!");
				System.exit(1);
			}
		}
		
		listPlayers(playerNames, playerWallets);
		
	}
	
	/**
	 * Gives out money to the winners of the betting.
	 * @param playerBets - 2D array of who bet, on which horse, and how much they bet
	 * @param playerWallets - array of how much each player has in their wallet
	 * @param playerNames - array of playerNames
	 * @param winningHorse - the index of the horse that won the race
	 * @param horseOdds - array of the odds of the horse
	 * @param horsesInRace - array of the indexes of the horses in race
	 */
	private static void payOutBets(int[][] playerBets, int[] playerWallets, String[] playerNames, int winningHorse, float[] horseOdds, int[] horsesInRace) {
		for (int i = 0; i < playerNames.length; i++){
			//System.out.print(playerNames[i] + " | " + playerWallets[i] + " | " + horseOdds[horsesInRace[winningHorse]]);
			playerWallets[i] += ((float)playerBets[i][winningHorse]*horseOdds[horsesInRace[winningHorse]]); 
			//System.out.println(" | " + ((float)playerBets[i][winningHorse]*horseOdds[horsesInRace[winningHorse]]));
		}
	}

	/**
	 * Performs the race using an array of each horse's distance traveled and checks who wins.
	 * @param horsesInRace
	 * @param horses
	 * @return int of the horse that won
	 */
	private static int startRace(int[] horsesInRace, String[] horses) {
		int[] horseDistance = new int[horsesInRace.length];
		AudioStream stream = music();
		final int MAX_STEPS = 2;
		final int MIN_STEPS = 1;
		final int RACE_DISTANCE = 80; 
		boolean isRaceDone = false;
		while(!isRaceDone){
			for (int i = 0; i < horseDistance.length; i++){
				horseDistance[i] += (int)(Math.random()*(MAX_STEPS-(MIN_STEPS-1))+MIN_STEPS);;
				printRace(horsesInRace, horses, horseDistance);
				if(horseDistance[i] >= RACE_DISTANCE){
					isRaceDone = true;
					AudioPlayer.player.stop(stream);
					return i;
				}
			}
			//printRace(horsesInRace, horses, horseDistance);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		AudioPlayer.player.stop(stream);
		return -1;		
	}
	
	/**
	 * Prints the race (lanes and motion of horses)
	 * @param horsesInRace - array of indexes of horses in the race
	 * @param horses - array of horses (names)
	 * @param horseDistance - array of how far each horse has traveled 
	 */
	private static void printRace(int[] horsesInRace, String[] horses, int[] horseDistance){
		final int RACE_DISTANCE = 80; 
		final int HEADER = 21;
		String edge = new String(new char[RACE_DISTANCE+HEADER+2]).replace("\0", "-"); //the number 2 is spacing
		System.out.println(edge);
		for (int i = 0; i < horseDistance.length; i++){
			System.out.printf("%-20s|", horses[horsesInRace[i]]);
			//String s = String.format("%10s:%d,%d", horses[horsesInRace[i]], horseDistance[i], RACE_DISTANCE-horseDistance[i]);
			//System.out.printf("%-20s|", s);
			String spaces = new String(new char[horseDistance[i] >= RACE_DISTANCE? RACE_DISTANCE:horseDistance[i]]).replace("\0", " ");
			System.out.print(spaces+(i+1));
			
			int spacesLeftInt = RACE_DISTANCE-horseDistance[i];
			if (spacesLeftInt < 0) spacesLeftInt = 0;
			String spacesLeft = new String(new char[spacesLeftInt]).replace("\0", " ");
			if(spacesLeft.isEmpty())
				System.out.printf("%s*%n", spacesLeft);
			else
				System.out.printf("%s|%n", spacesLeft);
			System.out.println(edge);
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	/**
	 * Lists all players in a table (name, wallet)
	 * @param playerNames - array of player names
	 * @param playerWallets - array of how money much each player has 
	 */
	private static void listPlayers(String[] playerNames, int[] playerWallets){
		System.out.printf("%n-|--------------------|--------------------|%n");
		System.out.printf("#|%-20s|%-20s|%n", "Player Name", "Player Wallet");
		System.out.printf("-|--------------------|--------------------|%n");
		for (int i = 0; i < playerNames.length; i++){
			System.out.printf("%d|%-20s|%-20s|%n", i+1, playerNames[i], playerWallets[i]);
			System.out.printf("-|--------------------|--------------------|%n");
		}
	}
	
	/**
	 * Lists the horses in the race and their odds
	 * @param horses - array of horses (names)
	 * @param horsesInRace - array of indexes of the horses that are in the race
	 * @param horseOdds - array of the odds of the horses (2.00 is the default)
	 */
	private static void listHorsesInRace(String[] horses, int[] horsesInRace, float[] horseOdds){
		System.out.printf("%n-|--------------------|---------|%n");
		System.out.printf("#|%-20s|   Odds  |%n", "Horse Name");
		System.out.printf("-|--------------------|---------|%n");
		for (int i = 0; i < horsesInRace.length; i++){
			System.out.printf("%d|%-20s|  %5.2f  |%n", i+1, horses[horsesInRace[i]], horseOdds[horsesInRace[i]]);
			System.out.printf("-|--------------------|---------|%n");
		}
	}

	/**
	 * Prompts the player for which player they'd like to use, which horse they'd like to bet on, and how much
	 * @param scan - Scanner
	 * @param playerBets - 2D array of who bet on which horse and how much
	 * @param playerNames - array of player names
	 * @param playerWallets - array of how much money each player has
	 * @param horsesInRace - array of the indexes of the horses in the race
	 * @param horses - array of the horses (horse names)
	 * @param horseOdds - array of the odds of the horses
	 * @return the option they chose (1 - continue playing, 2 - race, 3 - save and quit)
	 */
	private static int getPlayerBets(Scanner scan, int[][] playerBets, String[] playerNames, int[] playerWallets, int[] horsesInRace, String[] horses, float[] horseOdds) {
		int option = -1;
		while(option <= 1){
			listPlayers(playerNames, playerWallets);
			int playerIndex = chooseBettingPlayer(scan, playerNames, playerWallets);
			int betHorseIndex = chooseBettingHorse(scan, horsesInRace, horses, horseOdds);
			int playerBet = chooseBettingAmount(scan, playerWallets, playerNames, playerIndex);
		
			if (playerBets[playerIndex][betHorseIndex] > 0) playerWallets[playerIndex] += playerBets[playerIndex][betHorseIndex];
			System.out.println(playerNames[playerIndex] + ", you have placed a $" + playerBet + " bet on the number " + (betHorseIndex+1) + " horse, " + horses[horsesInRace[betHorseIndex]] + ".");
			playerBets[playerIndex][betHorseIndex] = playerBet; 
			playerWallets[playerIndex] -= playerBet;
		
			//printBettingTable(playerBets, playerNames, horses, horsesInRace);
			option = chooseOption(scan);
		}
		
		return option;
	}
	
	/**
	 * Prompts the player for which option they would like to choose (options listed in the above comment)
	 * @param scan Scanner
	 * @return the int of the option they chose
	 */
	private static int chooseOption(Scanner scan){
		int option = -1;
		while(option < 1){
			System.out.print("Select an option (1. Continue Betting, 2. Start Race, 3. Save and Quit): ");
			try {
				String entry = scan.nextLine();
				option = Integer.parseInt(entry);
				if (option < 1 || option > 3){
					System.out.print("Invalid entry! ");
					option = -1;
				}
			} catch (Exception e) {
				System.out.print("Invalid entry! Try again, ");
				option = -1;
			}
		}
		
		return option;
	}
	
	/**
	 * Validates whether or not all wallets are empty.
	 * @param playerWallets - array containing amount of money in each player's wallet
	 * @return a boolean indicating whether all wallets are empty
	 */
	private static boolean isPlayersWithNoMoney(int[] playerWallets){
		for (int i : playerWallets){
			if (i > 0) return false;
		}
		return true;
	}
	
	/**
	 * Prompts the player for which player they would like to choose
	 * @param scan - Scanner
	 * @param playerNames - array of the names of the players
	 * @param playerWallets - array containing amount of money in each player's wallet
	 * @return the number of the chosen player
	 */
	private static int chooseBettingPlayer(Scanner scan, String[] playerNames, int[] playerWallets){
		int playerIndex = -1;
		
		if (isPlayersWithNoMoney(playerWallets)){
			System.out.println("There are no players with money in their wallets! Exiting the game...");
			System.exit(0);
		}
		
		while(playerIndex < 1){
			System.out.print("Choose a player (using the number beside their name): ");
			try {
				String entry = scan.nextLine();
				playerIndex = Integer.parseInt(entry);
                if (playerIndex > playerNames.length || playerIndex <= 0){
                    System.out.print("Invalid entry! Try again, ");
                    playerIndex = -1;
                } else if ((int)playerWallets[playerIndex-1] == 0) {
                	System.out.print("Invalid entry! " + playerNames[playerIndex-1] + " has $0, ");
                	playerIndex = -1;
                }

			} catch (Exception e) {
				System.out.print("Invalid entry! Try again, ");
				playerIndex = -1;
			}
		}
		
		return playerIndex-1;
	}
	
	/**
	 * Prompts the user for how much they would like the chosen player (above) to bet
	 * @param scan - Scanner
	 * @param playerWallets - array of how much each player has
	 * @param playerNames - array of player names
	 * @param playerIndex - index of the chosen player (above)
	 * @return the amount that the player bet
	 */
	private static int chooseBettingAmount(Scanner scan, int[] playerWallets, String[] playerNames, int playerIndex){
		int playerBet = -1;
		while(playerBet < 1){ 
			System.out.print(playerNames[playerIndex] + ", how much would you like to bet, your currently have $" + playerWallets[playerIndex] + " in your wallet: ");
			try {
				String entry = scan.nextLine();
				playerBet = Integer.parseInt(entry);
				if (playerBet > playerWallets[playerIndex] || playerBet < 0){
					System.out.print("Invalid entry! ");
					playerBet = -1;
				}
			} catch (Exception e) {
				System.out.print("Invalid entry! Try again: ");
				playerBet = -1;
			}		
		}
		
		return playerBet;
	}
	
	/**
	 * Prompts the player to choose which horse they would like to bet on
	 * @param scan - Scanner
	 * @param horsesInRace - array of the indexes of the horses in the race
	 * @param horses - array of the horses (names)
	 * @param horseOdds - array of the horses' odds (default: 2.00)
	 * @return the number of the horse they want to bet on
	 */
	private static int chooseBettingHorse(Scanner scan, int[] horsesInRace, String[] horses, float[] horseOdds){
		listHorsesInRace(horses, horsesInRace, horseOdds);
		int betHorseIndex = -1;
		while(betHorseIndex < 1){ 
			System.out.printf("Which horse would you like to place your bet on (Valid options: 1 - %d): ", horsesInRace.length);
			try {
				String entry = scan.nextLine();
				betHorseIndex = Integer.parseInt(entry);
				if (betHorseIndex > horsesInRace.length || betHorseIndex < 1){
					System.out.print("Invalid entry! ");
					betHorseIndex = -1;
				}
			} catch (Exception e) {
				System.out.print("Invalid entry! Try again: ");
				betHorseIndex = -1;
			}		
		}
		
		return betHorseIndex-1;
	}	

	/**
	 * Randomly selects (between 5 and 8) how many horses are going to be in the race and selects that many horses from the horses array
	 * @param horses - array of horses (names)
	 * @return an array of the indexes of the horses in the race
	 */
	private static int[] getHorsesInRace(String[] horses) {
		int maxNumHorses = 8;
		int minNumHorses = 5;
		int numHorsesInRace = (int)(Math.random()*(maxNumHorses-(minNumHorses-1))+minNumHorses);
		int[] horsesInRace = new int[numHorsesInRace];
		int maxHorseIndex = 85;
		int minHorseIndex = 0;
		int count = 0;
		
		while (count < horsesInRace.length){
			int indexOfHorse = (int)(Math.random()*(maxHorseIndex-(minHorseIndex-1))+minHorseIndex);
			if (!alreadyInRace(indexOfHorse, horsesInRace))
				horsesInRace[count++] = indexOfHorse;
		}
		
		return horsesInRace;
	}

	/**
	 * Reads the file and splits the player name and their wallet, then stores the wallet amount in an array
	 * @return an array of each players' wallet
	 */
	private static int[] getPlayerWallets() {
		int[] wallets = null;
		try {
			Scanner fileScan = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(fileScan.nextLine());
			wallets = new int[numPlayers];
			
			for (int i = 0; i<numPlayers; i++){
				String line = fileScan.nextLine();
				String[] tokens = line.split(" ");
				wallets[i] = Integer.parseInt(tokens[tokens.length-1]);
			}			
			fileScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return wallets;
	}
	
	/**
	 * Reads the names and wallets from a file assume the file exists and is in the format specified in the
	 * assignment, then it splits the name from the wallet and returns an array.
	 * @return an array of the players' names
	 */
	private static String[] getPlayerNames() {
		String[] names = null;
		try {
			Scanner fileScan = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(fileScan.nextLine());
			names = new String[numPlayers];
			
			for (int i = 0; i<numPlayers; i++){
				String line = fileScan.nextLine();
				String[] tokens = line.split(" ");
				names[i] = "";
				for (int j = 0; j<tokens.length-1; j++){
					names[i] = names[i]+ " " + tokens[j];
				}
				names[i] = names[i].trim();
			}			
			fileScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return names;
	}
	
	/**
	 * Reads the horse odds from a file. Assume the file exists and is in the format specified in the
	 * assignment. 2.00 is the default odd for each horse. 
	 * @return an array of each horses' odds
	 */
	private static float[] getHorseOdds() {
		float[] odds = null;
		try {
			Scanner fileScan = new Scanner(new File("input/horse.dat"));
			int numHorses = Integer.parseInt(fileScan.nextLine());
			odds = new float[numHorses];
			
			for (int i = 0; i<numHorses; i++){
				String line = fileScan.nextLine();
				
				String[] tokens = line.split(",");
				if (tokens.length == 2)
					odds[i] = Float.parseFloat(tokens[1]);
				else
					odds[i] = 2; //every horses odds are 2 by default
			}
			fileScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return odds;
		
	}

	/**
	 * Reads the horses from a file. Assume the file exists and is in the format specified in the
	 * assignment.
	 * @return an array of the horses (their names)
	 */
	public static String[] getHorses(){
		String[] horses = null;
		try {
			Scanner fileScan = new Scanner(new File("input/horse.dat"));
			int numHorses = Integer.parseInt(fileScan.nextLine());
			horses = new String[numHorses];
			
			for (int i = 0; i<numHorses; i++){
				String line = fileScan.nextLine();
				
				String[] tokens = line.split(",");
				horses[i] = tokens[0].trim();
			}
			fileScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 return horses;
	}
	
	/**
	 * Check if a horse is already in the race - uses a modified search method
	 * @param horse - array of horses (names)
	 * @param horsesInRace - array of the indexes of the horses in the race
	 * @return a boolean which states whether or not they are already in the race
	 */
	public static boolean alreadyInRace(int horse, int[] horsesInRace){
		
		for (int i = 0; i < horsesInRace.length; i++){
			if (horsesInRace[i] == horse){
				return true;
			}
		}
			
		return false;
	}
}



