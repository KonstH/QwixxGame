// -------------------------------------------------------
// Assignment #4 - Move Class
// Written by: Konstantin Hristev - 40008099
// For COMP 248 Section S – Winter 2018
//
// The purpose of this program is to run a boardgame which
// can be played by 2-5 players.
//
// This class is made to create a Move object. 
// --------------------------------------------------------

public class Move {
		
	private char colour;	// variable where colour of the Move object is stored
	private int number;		// variable where number of the Move object is stored
	
	// constructor taking a colour and number input to define a Move object
	public Move(char colour, int number) {
		this.colour = colour;
		this.number = number;		
	}
	// method which returns the Move object's colour when called
	public char getColour() {
		return colour;
	}
	
	// method which sets the Move object's colour when called
	public void setColour(char colour) {
		this.colour = colour;	
	}
	
	// method which returns the Move object's number when called
	public int getNumber() {
		return number;
	}
	
	// method which sets the Move object's number when called
	public void setNumber(int number) {
		this.number = number;		
	}
	
	// method which converts the char used to describe the colour of the Move object into an int to 
	// represent the proper row in the gamboard array
	public static int convertColourtoNum(char colour) {
		int row = 0;
		if (colour == 'R')
			row = 0;
		if (colour == 'Y')
			row = 1;
		if (colour == 'G')
			row = 2;
		if (colour == 'B')
			row = 3;
		return row;	
	}
	
}
