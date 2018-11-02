// -------------------------------------------------------
// Assignment #4 - Driver Class
// Written by: Konstantin Hristev - 40008099
// For COMP 248 Section S – Winter 2018
//
// The purpose of this program is to run a boardgame which
// can be played by 2-5 players.
//
// This class is where the game is ran.
// --------------------------------------------------------

import java.util.Scanner;	// scanner imported

public class a4_Qwixx {

	public static void main(String[] args) {
		
		Scanner KeyInput = new Scanner (System.in);		// scanner initialized
		
		System.out.print("Please enter the number of players: ");
		int nbPlayers = KeyInput.nextInt();			// int variable storing the number of players in the game
		
		// while loop which makes sure the amount of players is between 2 and 5 inclusively
		while (nbPlayers<2 || nbPlayers>5) {
			System.out.println("You must have between 2 and 5 players.");	
			System.out.print("Please enter the number of players: ");
			nbPlayers = KeyInput.nextInt();
			System.out.println();
		}
		
		// array of players declared and initalized to the number of players user entered using for loop
		Player [] player_array = new Player [nbPlayers];
		for (int i = 0; i<nbPlayers; i++) {
			System.out.print("Please enter the name of Player " + (i+1) +": ");
			Player p = new Player(KeyInput.next());  // new player object created
			System.out.println();
			String [][] board = new String [4][11];		// a gameboard is created here for the player
			p.initializeGameboard(board);		// the player's gameboard is initialized
			p.printGameBoard(p.getName());;		// the player's gameboard is printed
			player_array[i] = p;		// player object stored in the i index of the player_array
		}
		
		// Qwixx game created
		Qwixx game = new Qwixx (player_array);
		game.play();	// game is started here by calling the play() method from the Qwixx class

		KeyInput.close();		// scanner is closed here
	}
}
