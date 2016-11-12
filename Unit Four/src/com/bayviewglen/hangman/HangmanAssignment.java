package com.bayviewglen.hangman;

import java.util.Scanner;

public class HangmanAssignment {
	
	private static final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
	private static final String VALID_CHARACTERS_NOSPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int MAX_GUESSES = 3; //7 
	private static final int BLANKS = 50;
	private static final int MAX_ROUNDS = 2; //5
	
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
	
	public static void playGame(){
		boolean isGameOver = false;
		
		playerOne = enterPlayerName("One");
		playerTwo = enterPlayerName("Two");
		
		System.out.println(playerOne + " and " + playerTwo + " prepare for a fierce game of Hangman!");
		
		int playerPlaying = 1; 
		String currentPlayerName = null;
			
		while (roundsPlayed < MAX_ROUNDS || suddenDeath){
			setupNewGame();
			
			if (roundsPlayed == 4) System.out.printf("-----> PREPARE FOR THE FINAL ROUND! <-----%n", roundsPlayed);
			else System.out.printf("-----> PREPARE FOR ROUND %d! <-----%n", roundsPlayed);
			
			if (playerPlaying == 1) phrase = playerPhrase(playerOne, playerTwo);
			else phrase = playerPhrase(playerTwo, playerOne);
			
			hideEntry();
			blankedPhrase = phraseToBlank();
			printBlankedPhrase();
			
			while (!isGuessed){
				if (playerPlaying == 1) currentPlayerName = playerOne;
				else currentPlayerName = playerTwo;
			
				int playerOption = playerOption(currentPlayerName, playerPlaying);
				if (playerOption == 1) solve(currentPlayerName, playerPlaying, false);
				else guessCharacter(currentPlayerName, playerPlaying);
			
				if (playerPlaying == 1){
					playerOneCountGuesses++;
					if (playerOneCountGuesses == MAX_GUESSES){
						solve(currentPlayerName, playerPlaying, true);
					}
				}
				else{
					playerTwoCountGuesses++;
					if (playerTwoCountGuesses == MAX_GUESSES){
						solve(currentPlayerName, playerPlaying, true);
					}
				}
			}
			
			if (playerPlaying == 1) playerPlaying = 2;
			else{
				roundsPlayed++;
				playerPlaying = 1;
			}
		}
		
		if (playerOneScore == playerTwoScore){
			suddenDeath = true;
		}
		else{
			suddenDeath = !suddenDeath;
			printFinalScore();
		}
	}
	
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
	
	private static String playerPhrase(String playerOne, String playerTwo){
		Scanner scan = new Scanner(System.in);
		boolean invalidCharFound = true;
		String phrase = null;
		System.out.println(playerOne + ", please enter a phrase for " + playerTwo + " to solve: ");
				
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
	
	private static void hideEntry(){
		for (int i = 0; i < BLANKS; i++) System.out.println();
	}
	
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
	
	private static void printBlankedPhrase(){
		for (int i = 0; i < blankedPhrase.length(); i++){
			System.out.printf("%c ", blankedPhrase.charAt(i));
		}
		System.out.println();
	}
	
	private static void removeUsedCharacter(char charGuess){
		int index = choiceOfCharacters.indexOf(String.valueOf(charGuess));
		if (index > -1){
			choiceOfCharacters = choiceOfCharacters.substring(0,index) + "_" + choiceOfCharacters.substring(index+1);
		}
	}
	
	private static int playerOption(String player, int playerNumber){
		Scanner scan = new Scanner(System.in);
		if (playerNumber == 1) System.out.println(player + ", you have used " + playerOneCountGuesses + " guesses. Would you like to (1) solve or (2) guess a character: ");
		else System.out.println(player + ", you have used " + playerTwoCountGuesses + " guesses. Would you like to (1) solve or (2) guess a character: ");
		
		while (true){
			int playerOption = scan.nextInt(); 
			if (playerOption < 1 || playerOption > 2){
				System.out.println(player + ", you must either (1) solve or (2) guess a character:");
				continue;
			}
			//scan.close();
			return playerOption;
		}	
	}
	
	private static boolean solve(String player, int playerNumber, boolean finalSolution){
		Scanner scan = new Scanner(System.in);
		boolean invalidCharFound = true;
		String solution = null;
		
		while (invalidCharFound){
			if (finalSolution) System.out.print(player + ", you have used up all your guesses! Please enter your solution: ");
			else System.out.print(player + ", please enter your solution: ");
			solution = scan.nextLine(); 
			
			
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
			
		if (phrase.equals(solution)){
			System.out.println("Congratulations, " + player + ", you are correct!");
			printAndAdjustScore(playerNumber);
			isGuessed = true;
		}
		else System.out.println("Sorry, " + player + ", that guess was incorrect.");
		return phrase.equals(solution);
	}
	
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
			
			else if (choiceOfCharacters.indexOf(charGuess) < -1){ 
				System.out.print("You have already guessed that character!");
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
			printAndAdjustScore(playerNumber);
			isGuessed = true;
		}
		
		return charGuess;
	}
	
	private static void printAndAdjustScore(int playerNumber){
		int score = 0;
		
		if (playerNumber == 1){
			score = MAX_GUESSES - playerOneCountGuesses + 1;
			playerOneScore += score;
		}	
		else {
			score = MAX_GUESSES - playerTwoCountGuesses + 1;
			playerTwoScore += score;
		}
		
		System.out.println(playerOne + ": " + playerOneScore);
		System.out.println(playerTwo + ": " + playerTwoScore);
	}
	
	private static void printFinalScore(){
		System.out.printf("%s: %d%n",playerOne, playerOneScore);
		System.out.printf("%s: %d%n",playerTwo, playerTwoScore);
		
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
	
	private static void setupNewGame(){
		playerOneCountGuesses = 0;
		playerTwoCountGuesses = 0;		
		phrase = null;
		blankedPhrase = null;
		isGuessed = false;
		choiceOfCharacters = VALID_CHARACTERS_NOSPACE;
	}
	
	public static void main(String[] args) {
		HangmanAssignment.playGame();
	}

}