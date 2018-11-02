// -------------------------------------------------------
// Assignment #4 - Qwixx Class
// Written by: Konstantin Hristev - 40008099
// For COMP 248 Section S – Winter 2018
//
// The purpose of this program is to run a boardgame which
// can be played by 2-5 players.
//
// This class is where the game's main instructions are stored.
// It makes use of the Dice, Move and Player classes in order
// to create the game.
// --------------------------------------------------------

import java.util.Scanner;	// the scanner is imported

public class Qwixx {

	Scanner KeyInput = new Scanner (System.in);		// scanner is initialized
	private Dice [] dice = new Dice [6];	// and array "dice" is declared and initialized to hold 6 different Dice objects
	private Player [] player;				// and array "player" is declared of type Player
	private boolean lock_R = false;			// boolean variable which will track wether the colour Red is locked is declared and initialized to false
	private boolean lock_Y = false;			// boolean variable which will track wether the colour Yellow is locked is declared and initialized to false
	private boolean lock_G = false;			// boolean variable which will track wether the colour Green is locked is declared and initialized to false
	private boolean lock_B = false;			// boolean variable which will track wether the colour Blue is locked is declared and initialized to false
	private static int NEGPTS = -5;			// static variable which is initialized to -5 will represent the negative points added when players pass
	
	// constructor for the Qwixx object
	public Qwixx (Player [] array) {
		player = array;
			
		for (int i = 0; i<dice.length; i++) {	// loop which stores all 6 dices in the dice array
			dice[i] = new Dice();
		}
	}
	
	// method which rolls all 6 dice when called
	public void rollDice() {
		for (int i = 0; i<dice.length; i++) {
			dice[i].rollDice();
		}
	}
	
	// method which prints out all 6 dice with their respective colour and side
	public void printRolledDice() {
		for (int i = 0; i<dice.length; i++) {
			if (i == 0)
				dice[i].setColour("Red");
			if (i == 1)
				dice[i].setColour("Yellow");
			if (i == 2)
				dice[i].setColour("Green");
			if (i == 3)
				dice[i].setColour("Blue");
			if (i == 4)
				dice[i].setColour("White1");
			if (i == 5)
				dice[i].setColour("White2");
			
			System.out.print(dice[i]);
		}
		System.out.println();
	}
	
	// method which controls all the moves on the white dice
	public void playWhiteDiceMove() {
		String useWhite_choice;		// variable which stores the user's decision of using the white dice total or not
		String which_Colour = ""; 	// variable which stores the user's decision of which colour to use the white dice total on
		boolean loop = true;		// variable which turns false when user makes valid decision to exit do-while loop
		
		for (int i = 0; i<player.length; i++) {
			System.out.println("\n****Move on White Dice****\n\n"
					+ "Total for the white dice is " + getWhiteDiceTotal() + "\n");
			System.out.println(player[i].getName() + " it's your turn...\n");
			
			player[i].printGameBoard(player[i].getName());
			
			do {
			System.out.print("\nWould you like to cross off a number on the game board using"
					+ " the white dice total? (anything other than 'yes' is taken to mean no): ");
			
			useWhite_choice = KeyInput.next();
			
			if (useWhite_choice.equalsIgnoreCase("yes")) {	
				
					System.out.print("What colour would you like to cross out? (R = red, Y = yellow, G = green, B = Blue): ");
					which_Colour = KeyInput.next();
						if (which_Colour.equalsIgnoreCase("R")) {
							if (checkValidMove(player[i], new Move('R', getWhiteDiceTotal())) && !lock_R) {
								player[i].makeMove(new Move('R', getWhiteDiceTotal()));
									if (checkColourFinished(player[i], 'R'))
										lock_R = true;
								System.out.println();
								player[i].printGameBoard(player[i].getName());		
								loop = false;
							}
							else if (!checkValidMove(player[i], new Move('R', getWhiteDiceTotal())) && !lock_R)
								System.out.println("\nInvalid Move, " + player[i].getcross_R() + " is already crossed off in R.\n");
							
							else if (checkValidMove(player[i], new Move('R', getWhiteDiceTotal())) && lock_R)
								System.out.println("\nCan't move on Red, it's locked.\n");
						}	
						
						if (which_Colour.equalsIgnoreCase("Y")) {
							if (checkValidMove(player[i], new Move('Y', getWhiteDiceTotal())) && !lock_Y) {
								player[i].makeMove(new Move('Y', getWhiteDiceTotal()));
									if (checkColourFinished(player[i], 'Y'))
										lock_Y = true;
								System.out.println();
								player[i].printGameBoard(player[i].getName());
								loop = false;
							}
							else if (!checkValidMove(player[i], new Move('Y', getWhiteDiceTotal())) && !lock_Y)
								System.out.println("\nInvalid Move, " + player[i].getcross_Y() + " is already crossed off in Y.\n");
							
							else if (checkValidMove(player[i], new Move('Y', getWhiteDiceTotal())) && lock_Y)
								System.out.println("\nCan't move on Yellow, it's locked.\n");
							}
						
						if (which_Colour.equalsIgnoreCase("G")) {
							if (checkValidMove(player[i], new Move('G', getWhiteDiceTotal())) && !lock_G) {
								player[i].makeMove(new Move('G', getWhiteDiceTotal()));
								if (checkColourFinished(player[i], 'G'))
								lock_G = true;
								System.out.println();
								player[i].printGameBoard(player[i].getName());;
								loop = false;
							}
							else if (!checkValidMove(player[i], new Move('G', getWhiteDiceTotal())) && !lock_G)
								System.out.println("\nInvalid Move, " + player[i].getcross_G() + " is already crossed off in G.\n");
							
							else if (checkValidMove(player[i], new Move('G', getWhiteDiceTotal())) && lock_G)
								System.out.println("\nCan't move on Green, it's locked.\n");
							}
						if (which_Colour.equalsIgnoreCase("B")) {
							if (checkValidMove(player[i], new Move('B', getWhiteDiceTotal())) && !lock_B) {
								player[i].makeMove(new Move('B', getWhiteDiceTotal()));
								if (checkColourFinished(player[i], 'B'))
									lock_B = true;
								System.out.println();
								player[i].printGameBoard(player[i].getName());
								loop = false;
							}
							else if (!checkValidMove(player[i], new Move('B', getWhiteDiceTotal())) && !lock_B)
								System.out.println("\nInvalid Move, " + player[i].getcross_B() + " is already crossed off in B.\n");
							
							else if (checkValidMove(player[i], new Move('B', getWhiteDiceTotal())) && lock_B)
								System.out.println("\nCan't move on Blue, it's locked.\n");
							}
					}
			else
				loop = false;
			
				}
				while (loop);	// do while exits when a valid choice is made by the user
			}	
		}

	
	// method which controls all the moves on the coloured dice
	public void playColourDiceMoves(Player p) {
		String useWhite_choice;		// variable which stores the user's decision of using a white/colour die or not
		String which_Colour; 		// variable which stores the user's decision of which colour to use the white/colour die on
		int which_White;			// variable which stores the user's decision of which white die they want to use
		boolean loop = true;		// variable which turns false when user makes valid decision to exit do-while loop
		
		
			System.out.println("\n****Move on any coloured Dice****\n");
			printRolledDice();
			System.out.println();
			System.out.println(p.getName() + " it's your turn...\n");
			
			p.printGameBoard(p.getName());
			do {
			System.out.print("Would you like to cross off a number on the game board using one of the coloured dice and a white dice?"
					+ " (anything other than 'yes' is taken to mean no): ");
			
			useWhite_choice = KeyInput.next();
			if (useWhite_choice.equalsIgnoreCase("yes")) {
				
				
					System.out.print("Which white die would you like to use? (White = 1, White2 = 2): ");
					which_White = KeyInput.nextInt();
					
						if (which_White == 1)	{
						System.out.print("What colour would you like to cross out? (R = red, Y = yellow, G = green, B = Blue): ");
						which_Colour = KeyInput.next();
						
							if (which_Colour.equalsIgnoreCase("R")) {
								if (checkValidMove(p, new Move('R', (dice[4].getSide() + dice[0].getSide()))) && !lock_R) {
									p.makeMove(new Move('R', (dice[4].getSide()+dice[0].getSide())));
									if (checkColourFinished(p, 'R'))
										lock_R = true;
									System.out.println();
									p.printGameBoard(p.getName());
									loop = false;
								}
								else if (!checkValidMove(p, new Move('R', getWhiteDiceTotal())) && !lock_R)
									System.out.println("\nInvalid Move, " + p.getcross_R() + " is already crossed off in R.\n");
								
								else if (checkValidMove(p, new Move('R', getWhiteDiceTotal())) && lock_R)
									System.out.println("\nCan't move on Red, it's locked.\n");
								}	
							if (which_Colour.equalsIgnoreCase("Y")) {
								if (checkValidMove(p, new Move('Y', (dice[4].getSide() + dice[1].getSide()))) && !lock_Y) {
									p.makeMove(new Move('Y', (dice[4].getSide()+dice[1].getSide())));
									if (checkColourFinished(p, 'Y'))
										lock_Y = true;
									System.out.println();
									p.printGameBoard(p.getName());
									loop = false;
								}
								else if (!checkValidMove(p, new Move('Y', getWhiteDiceTotal())) && !lock_Y)
									System.out.println("\nInvalid Move, " + p.getcross_Y() + " is already crossed off in Y.\n");
								
								else if (checkValidMove(p, new Move('Y', getWhiteDiceTotal())) && lock_Y)
									System.out.println("\nCan't move on Yellow, it's locked.\n");
								}	
							if (which_Colour.equalsIgnoreCase("G")) {
								if (checkValidMove(p, new Move('G', (dice[4].getSide() + dice[2].getSide()))) && !lock_G) {
									p.makeMove(new Move('G', (dice[4].getSide()+dice[2].getSide())));
									if (checkColourFinished(p, 'G'))
										lock_G = true;
									System.out.println();
									p.printGameBoard(p.getName());
									loop = false;
								}
								else if (!checkValidMove(p, new Move('G', getWhiteDiceTotal())) && !lock_G)
									System.out.println("\nInvalid Move, " + p.getcross_G() + " is already crossed off in G.\n");
								
								else if (checkValidMove(p, new Move('G', getWhiteDiceTotal())) && lock_G)
									System.out.println("\nCan't move on Green, it's locked.\n");
								}
							if (which_Colour.equalsIgnoreCase("B")) {
								if (checkValidMove(p, new Move('B', (dice[4].getSide() + dice[3].getSide()))) && !lock_B) {
									p.makeMove(new Move('B', (dice[4].getSide()+dice[3].getSide())));
									if (checkColourFinished(p, 'B'))
										lock_B = true;
									System.out.println();
									p.printGameBoard(p.getName());
									loop = false;
								}
								else if (!checkValidMove(p, new Move('B', getWhiteDiceTotal())) && !lock_B)
									System.out.println("\nInvalid Move, " + p.getcross_B() + " is already crossed off in B.\n");
								
								else if (checkValidMove(p, new Move('B', getWhiteDiceTotal())) && lock_B)
									System.out.println("\nCan't move on Blue, it's locked.\n");
								}		
						}
						
						if (which_White == 2)	{
							System.out.print("What colour would you like to cross out? (R = red, Y = yellow, G = green, B = Blue): ");
							which_Colour = KeyInput.next();
							
								if (which_Colour.equalsIgnoreCase("R")) {
									if (checkValidMove(p, new Move('R', (dice[5].getSide() + dice[0].getSide()))) && !lock_R) {
										p.makeMove(new Move('R', (dice[5].getSide()+dice[0].getSide())));
										if (checkColourFinished(p, 'R'))
											lock_R = true;
										System.out.println();
										p.printGameBoard(p.getName());
										loop = false;
									}
									else if (!checkValidMove(p, new Move('R', getWhiteDiceTotal())) && !lock_R)
										System.out.println("\nInvalid Move, " + p.getcross_R() + " is already crossed off in R.\n");
									
									else if (checkValidMove(p, new Move('R', getWhiteDiceTotal())) && lock_R)
										System.out.println("\nCan't move on Red, it's locked.\n");
									}	
								if (which_Colour.equalsIgnoreCase("Y")) {
									if (checkValidMove(p, new Move('Y', (dice[5].getSide() + dice[1].getSide()))) && !lock_Y) {
										p.makeMove(new Move('Y', (dice[5].getSide()+dice[1].getSide())));
										if (checkColourFinished(p, 'Y'))
											lock_Y = true;
										System.out.println();
										p.printGameBoard(p.getName());
										loop = false;
									}
									else if (!checkValidMove(p, new Move('Y', getWhiteDiceTotal())) && !lock_Y)
										System.out.println("\nInvalid Move, " + p.getcross_Y() + " is already crossed off in Y.\n");
									
									else if (checkValidMove(p, new Move('Y', getWhiteDiceTotal())) && lock_Y)
										System.out.println("\nCan't move on Yellow, it's locked.\n");
									}	
								if (which_Colour.equalsIgnoreCase("G")) {
									if (checkValidMove(p, new Move('G', (dice[5].getSide() + dice[2].getSide()))) && !lock_G) {
										p.makeMove(new Move('G', (dice[5].getSide()+dice[2].getSide())));
										if (checkColourFinished(p, 'G'))
											lock_G = true;
										System.out.println();
										p.printGameBoard(p.getName());
										loop = false;
									}
									else if (!checkValidMove(p, new Move('G', getWhiteDiceTotal())) && !lock_G)
										System.out.println("\nInvalid Move, " + p.getcross_G() + " is already crossed off in G.\n");
									
									else if (checkValidMove(p, new Move('G', getWhiteDiceTotal())) && lock_G)
										System.out.println("\nCan't move on Green, it's locked.\n");
									}
								if (which_Colour.equalsIgnoreCase("B")) {
									if (checkValidMove(p, new Move('B', (dice[5].getSide() + dice[3].getSide()))) && !lock_B) {
										p.makeMove(new Move('B', (dice[5].getSide()+dice[3].getSide())));
										if (checkColourFinished(p, 'B'))
											lock_B = true;
										System.out.println();
										p.printGameBoard(p.getName());
										loop = false;
									}
									else if (!checkValidMove(p, new Move('B', getWhiteDiceTotal())) && !lock_B)
										System.out.println("\nInvalid Move, " + p.getcross_B() + " is already crossed off in B.\n");
									
									else if (checkValidMove(p, new Move('B', getWhiteDiceTotal())) && lock_B)
										System.out.println("\nCan't move on Blue, it's locked.\n");
									}		
							}
				}
			else {
				p.addNegativePoints(NEGPTS);
				System.out.println("For passing you get -5 points. You now have " + p.getNegativePoints() + " points.\n");
				loop = false;
			}
			
		}
		while (loop); 	// do while exits when a valid choice is made by the user
	}
	
	// method which loops all the necessary methods to run the game
	public void play() {
		do {
			for (int i = 0; i<player.length; i++) {
				System.out.println("		  		       ---New Round---");
				rollDice();
				printRolledDice();
				playWhiteDiceMove();
	
					if (!checkGameFinished())
						break;
					
				playColourDiceMoves(player[i]);
				
					if (!checkGameFinished())
						break;
			}
		}
		while (checkGameFinished());		// do-while terminates when the game is over (checkGameFinished() becomes false)
	
		System.out.print(determineWinner());	// prints winner of the game
	}
	
	// method which returns the total sum of the 2 white dice when called
	private int getWhiteDiceTotal() {
		int sum = 0;
		for (int i = 0; i<dice.length; i++) {
			if (dice[i].getColour() == "White1" || dice[i].getColour() == "White2" )
				sum += dice[i].getSide();
		}
		return sum;
	}
	
	// method which determines if a move is valid when called
	private boolean checkValidMove(Player p, Move m) {
		boolean valid = false;		// boolean value which turns true if a move is invalid
		
		if (m.getColour() == 'R')
			valid = (p.getcross_R() < m.getNumber() && m.getNumber()>=2 && m.getNumber() <=12 );
		
		if (m.getColour() == 'Y')
			valid = (p.getcross_Y() < m.getNumber() && m.getNumber()>=2 && m.getNumber() <=12 );	// if statements store true in teh variable
																									// valid when a move is invalid
		if (m.getColour() == 'G')
			valid = (p.getcross_G() > m.getNumber() && m.getNumber()>=2 && m.getNumber() <=12 );
		
		if (m.getColour() == 'B')
			valid = (p.getcross_B() > m.getNumber() && m.getNumber()>=2 && m.getNumber() <=12 );
		
		return valid;				
	}
	
	// method which determines if a colour is locked when called
	private boolean checkColourFinished(Player p, char colour) {
		boolean finished = false;	// boolean value which turns true when a colour is locked
		
		if (colour == 'R') {
			if (p.getcross_R() == 12) {
				finished = true;
				System.out.println("\n" + p.getName() + " has locked Red, it is no longer playable.");
				}
		}
		
		if (colour == 'Y') {
			if (p.getcross_Y() == 12) {
				finished = true;
				System.out.println("\n" + p.getName() + " has locked Yellow, it is no longer playable.");		// if statements store true in 
				}																								// the variable finished when a 
		}																										// colour is locked
		
		if (colour == 'G') {
			if (p.getcross_G() == 2) {
				finished = true;
				System.out.println("\n" + p.getName() + " has locked Green, it is no longer playable.");
				}
		}
		
		if (colour == 'B') {
			if (p.getcross_B() == 2) {
				finished = true;
				System.out.println("\n" + p.getName() + " has locked Blue, it is no longer playable.");
				}
		}
		return finished;		
	}
	
	// method which determines if the game is over when called
	private boolean checkGameFinished() {
		boolean finished = true;	// boolean value which turns false when the game is finished
			
			for (int i = 0; i<player.length; i++) {
				if (player[i].getNegativePoints() == -20) {		// this loop ends the game when a player passes 4 times
					finished = false;
					break;
				}
			}
			
			if (lock_R && lock_Y)
				finished = false;
			
			if (lock_R && lock_G)
				finished = false;
			
			if (lock_R && lock_B)			// this if statement ends the game when 2 colours are crossed off
				finished = false;
			
			if (lock_Y && lock_G)
				finished = false;
			
			if (lock_Y && lock_B)
				finished = false;
			
			if (lock_G && lock_B)
				finished = false;
				
		return finished;
	}
	
	// method which compares all the player scores and returns the name of the player with the highest score
	private String determineWinner() {
		int maxValue = -21;		// variable containing the highest score achieved 
		String winnerName = "";		// variable containing the name of the winning player (with the highest score)
		
		for (int i = 0; i<player.length; i++) {
			if (player[i].getBoardTotal() > maxValue) {
				maxValue = player[i].getBoardTotal();
				winnerName = player[i].getName();
			}
			System.out.println(player[i].getName() + " has " + player[i].getBoardTotal() + " points.");		
		}
	
		return "\nThat's a wrap, " + winnerName + " wins the game!";
	}
	
	
	
	
	
	
	
	
	
	
	
		
}
