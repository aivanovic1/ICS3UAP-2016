package com.bayviewglen.hangman;

import java.util.Scanner;

public class HangmanAssignment {
	
	private static final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
	private static final String VALID_CHARACTERS_NOSPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int MAX_GUESSES = 3; //7 
	private static final int BLANKS = 50;
	private static final int MAX_ROUNDS = 1; //5
	
	private static int playerOneCountGuesses = 0;
	private static int playerTwoCountGuesses = 0;
	private static int playerOneScore = 0;
	private static int playerTwoScore = 0;
	private static String playerOne = null;
	private static String playerTwo = null;
	private static String phrase = null;
	private static String choiceOfCharacters = null;
	private static String blankedPhrase = null;
	private static boolean isGuessed = false;
	private static int roundsPlayed = 1;
	private static boolean suddenDeath = false;
	
	/**
	 * Main Driver (incorporates all other functions and pieces them together to run the game).	
	 */
	public static void playGame(){
		
		playerOne = enterPlayerName("One");
		playerTwo = enterPlayerName("Two");
		
		System.out.println(playerOne + " and " + playerTwo + " prepare for a fierce game of Hangman!");
		
		int playerPlaying = 1; 
		String currentPlayerName = null;
			
		while (roundsPlayed <= MAX_ROUNDS || suddenDeath){
			setupNewGame();
			if (playerPlaying == 1) currentPlayerName = playerOne;
			else currentPlayerName = playerTwo;
			
			if (roundsPlayed == 4) System.out.printf("-----> PREPARE FOR THE FINAL ROUND, %s! <-----%n", roundsPlayed, currentPlayerName.toUpperCase());
			else System.out.printf("-----> PREPARE FOR ROUND %d, %s! <-----%n", roundsPlayed, currentPlayerName.toUpperCase());
			
			phrase = playerPhrase(playerPlaying);
			
			hideEntry();
			blankedPhrase = phraseToBlank();
			printBlankedPhrase();
			
			while (!isGuessed){
				int playerOption = playerOption(currentPlayerName, playerPlaying);
				
				if (playerOption == 1) solve(currentPlayerName, playerPlaying, false);
				else guessCharacter(currentPlayerName, playerPlaying);
				
				if (isGuessed) break;
				
				if (playerPlaying == 1){
					playerOneCountGuesses++;
					if (playerOneCountGuesses == MAX_GUESSES){
						solve(currentPlayerName, playerPlaying, true);
						printScore();
						break;
					}
				}
				else{
					playerTwoCountGuesses++;
					if (playerTwoCountGuesses == MAX_GUESSES){
						solve(currentPlayerName, playerPlaying, true);
						printScore();
						break;
					}
				}
			}
			
			if (playerPlaying == 1) playerPlaying = 2;
			else {
				roundsPlayed++;
				playerPlaying = 1;
			}
			
			if (playerPlaying == 1){
				if (playerOneScore == playerTwoScore){
					suddenDeath = true;
				}
				else {
					suddenDeath = false;
					printFinalScore();
				}
			}
		}
	}
	
	/**
	 * Prompts, validates, and returns name of player.
	 * 
	 * @param playerNumber
	 * @return
	 */
	private static String enterPlayerName(String playerNumber){
		Scanner scan = new Scanner(System.in);
		while (true){
			System.out.print("Please enter Player " + playerNumber + "'s Name: ");
			String playerName = scan.nextLine(); 
			if (playerName == null || playerName.trim().isEmpty()){
				System.out.println("Name cannot be empty!");
				continue;
			}
			//scan.close();
			return playerName;
		}	
	}
	
	/**
	 * Prompts, validates, and returns the phrase entered by the player which is not guessing.
	 * 
	 * @param playerNumber
	 * @return
	 */
	private static String playerPhrase(int playerNumber){
		Scanner scan = new Scanner(System.in);
		boolean invalidCharFound = true;
		String phrase = null;
		if (playerNumber == 1) System.out.println(playerTwo + ", please enter a phrase for " + playerOne + " to solve: ");
		else System.out.println(playerOne + ", please enter a phrase for " + playerTwo + " to solve: ");
				
		while (invalidCharFound){
			 phrase = scan.nextLine().trim().toUpperCase();
			
			if (phrase == null || phrase.trim().isEmpty()){
				System.out.println("Phrase cannot be empty! Please try again: ");
				continue;
			}
			
			invalidCharFound = false;
			for (int i = 0; i < phrase.length(); i++){
				String s = "" + phrase.charAt(i);
				if (VALID_CHARACTERS.indexOf(s) == -1){
					System.out.print("Please enter a phrase using only alphanumeric characters (spaces are allowed): ");
					invalidCharFound = true;
					break;
				}
			}			
		}
		//scan.close();
		return phrase;
	}
	
	/**
	 * Prints a lot of blank lines to hide the phrase entered.
	 */
	private static void hideEntry(){
		for (int i = 0; i < BLANKS; i++) System.out.println();
	}
	
	/**
	 * Returns the phrase entered except it is blanked (underscores and slashes).
	 * 
	 * @return
	 */
	private static String phraseToBlank(){
		String blankedPhrase = "";
		String charIndex = "";
		for (int i = 0; i < phrase.length(); i++){
			charIndex = "" + phrase.charAt(i);
			if (charIndex.equals(" ")) blankedPhrase += "/";
			else blankedPhrase += "_";
		}
		return blankedPhrase;
	}
	
	/**
	 * Prints the blanked phrase with the correct spacing.
	 */
	private static void printBlankedPhrase(){
		for (int i = 0; i < blankedPhrase.length(); i++){
			System.out.printf("%c ", blankedPhrase.charAt(i));
		}
		System.out.println();
	}
	
	/**
	 * Assigns "_" to a used character (changes the variable).
	 * 
	 * @param charGuess
	 */
	private static void removeUsedCharacter(char charGuess){
		int index = choiceOfCharacters.indexOf(String.valueOf(charGuess));
		if (index > -1){
			choiceOfCharacters = choiceOfCharacters.substring(0,index) + "_" + choiceOfCharacters.substring(index+1);
		}
	}
	
	/**
	 * Prompts, validates, and returns the selected playing option (1 or 2).
	 * 
	 * @param player
	 * @param playerNumber
	 * @return
	 */
	private static int playerOption(String player, int playerNumber){
		Scanner scan = new Scanner(System.in);
		if (playerNumber == 1) System.out.print(player + ", you have used " + playerOneCountGuesses + " guesses. Would you like to (1) solve or (2) guess a character: ");
		else System.out.print(player + ", you have used " + playerTwoCountGuesses + " guesses. Would you like to (1) solve or (2) guess a character: ");
		
		while (true){
			String option = scan.nextLine().trim();
			
			if (!(option.equals("1") || option.equals("2"))){
				System.out.print("Invalid input! Please enter either (1) or (2): ");
				continue;
			}
			
			int playerOption = Integer.parseInt(option);
			
			//scan.close();
			return playerOption;
		}	
	}
	
	/**
	 * Prompts, validates, checks whether or not it is correct, and adjusts the score (Option 1 - Solving the phrase).
	 * 
	 * @param player
	 * @param playerNumber
	 * @param finalSolution
	 * @return
	 */
	private static boolean solve(String player, int playerNumber, boolean finalSolution){
		Scanner scan = new Scanner(System.in);
		boolean invalidCharFound = true;
		String solution = null;
		
		while (invalidCharFound){
			if (finalSolution) System.out.print(player + ", you have used up all your guesses! Please enter your solution: ");
			else System.out.print(player + ", please enter your solution: ");
			solution = scan.nextLine().toUpperCase().trim(); 
			
			
			if (solution == null || solution.trim().isEmpty()){
				System.out.println("Solution cannot be empty!");
				continue;
			}
			
			invalidCharFound = false;
			for (int i = 0; i < solution.length(); i++){
				String s = "" + solution.charAt(i);
				if (VALID_CHARACTERS.indexOf(s) == -1){
					System.out.print("Please enter a valid solution using only alphanumeric characters (spaces are allowed): ");
					invalidCharFound = true;
					break;
				}
			}	
		}
			
			//scan.close();
			
		if (phrase.equals(solution) && !finalSolution){
			System.out.println("Congratulations, " + player + ", you are correct!");
			adjustScore(playerNumber);
			printScore();
			isGuessed = true;
		}
		else System.out.println("Sorry, " + player + ", that guess was incorrect.");
		
		return phrase.equals(solution);
	}
	
	/**
	 * Prompts, validates, checks whether or not it is correct, and adjusts score (Option 2 - Guessing a single character).
	 * 
	 * @param player
	 * @param playerNumber
	 * @return
	 */
	private static String guessCharacter(String player, int playerNumber){
		Scanner scan = new Scanner(System.in);
		System.out.println("Unused characters: ");
				
		for (int i = 0; i < choiceOfCharacters.length(); i++){
			System.out.printf("%c ", choiceOfCharacters.charAt(i));
		}
		
		System.out.print("\n" + player + ", please enter a single character: ");
		String charGuess = null;
		
		while (true){
			charGuess = scan.nextLine().toUpperCase().trim(); 
			
			if (charGuess == null || charGuess.trim().isEmpty()){
				System.out.println("Guess cannot be empty!");
				continue;
			}
			
			else if (VALID_CHARACTERS.indexOf(charGuess) == -1){
				System.out.print("Please enter a guess using only alphanumeric characters (spaces are not included): ");
				continue;
			}
			
			else if (choiceOfCharacters.indexOf(charGuess) == -1){ 
				System.out.print("You have already guessed that character! Try again: ");
				continue;
			}
			
			else break;
						
		}	
		
		removeUsedCharacter(charGuess.charAt(0));
		
		//scan.close();
		
		if (phrase.indexOf(charGuess) != -1){
			System.out.println("Good guess, "+ player + ", the character '" + charGuess + "' is in the phrase.");
			
			for (int i = 0; i < phrase.length(); i++){
				if (phrase.charAt(i) == charGuess.charAt(0)){
					blankedPhrase = blankedPhrase.substring(0,i) + charGuess + blankedPhrase.substring(i+1);
				}
			}
			
			printBlankedPhrase();
		}
		
		else {
			System.out.println("Sorry, "+ player + ", the character '" + charGuess + "' is not in the phrase.");
			printBlankedPhrase();
		}
		
		if (blankedPhrase.indexOf("_") == -1){
			System.out.println("Congratulations, " + player + ", you are correct!");
			adjustScore(playerNumber);
			printScore();
			isGuessed = true;
		}
		
		return charGuess;
	}
	
	/**
	 * Adjusts the player score.
	 * 
	 * @param playerNumber
	 */
	private static void adjustScore(int playerNumber){
		int score = 0;
		
		if (playerNumber == 1){
			score = MAX_GUESSES - playerOneCountGuesses + 1;
			playerOneScore += score;
		}	
		else {
			score = MAX_GUESSES - playerTwoCountGuesses + 1;
			playerTwoScore += score;
		}
	}
	
	/**
	 * Prints the current score of the players to the console.
	 */
	private static void printScore(){
		System.out.println();
		System.out.println("|---CURRENT-SCORES---|");
		System.out.println(playerOne + ": " + playerOneScore);
		System.out.println(playerTwo + ": " + playerTwoScore);
		System.out.println("|--------------------|\n");
	}
	
	/**
	 * Prints the final result (who won).
	 */
	private static void printFinalScore(){
		/*System.out.println();
		System.out.println("|---FINAL-SCORES---|");
		System.out.printf("%s: %d%n",playerOne, playerOneScore);
		System.out.printf("%s: %d%n",playerTwo, playerTwoScore);
		System.out.println("|------------------|\n"); */
		
		System.out.println("\n|---FINAL-RESULTS---|");
		
		if (playerOneScore > playerTwoScore){
			if (playerOneScore > playerTwoScore + 10) System.out.println(playerOne + ", you crushed " + playerTwo + "!");
			else if (playerOneScore < playerTwoScore + 3) System.out.println(playerOne + ", you narrowly clinched the win from " + playerTwo + "!");
			else System.out.println(playerOne + ", you won!");
		}
		
		else{
			if (playerTwoScore > playerOneScore + 10) System.out.println(playerTwo + ", you crushed " + playerOne + "!");
			else if (playerTwoScore < playerOneScore + 3) System.out.println(playerTwo + ", you narrowly clinched the win from " + playerOne + "!");
			else System.out.println(playerTwo + ", you won!");
		}
	}
	
	/**
	 * Resets all the necessary variables to play another game (i.e. score, guesses, etc.).
	 */
	private static void setupNewGame(){
		playerOneCountGuesses = 0;
		playerTwoCountGuesses = 0;		
		phrase = null;
		blankedPhrase = null;
		isGuessed = false;
		choiceOfCharacters = VALID_CHARACTERS_NOSPACE;
	}
	
	/**
	 * Plays the game (calls the driver function).
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HangmanAssignment.playGame();
	}

}
