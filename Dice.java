// -------------------------------------------------------
// Assignment #4 - Dice Class
// Written by: Konstantin Hristev - 40008099
// For COMP 248 Section S – Winter 2018
//
// The purpose of this program is to run a boardgame which
// can be played by 2-5 players.
//
// This class is made to create a Dice object. 
// --------------------------------------------------------

public class Dice {
	
	private String colour;		// variable where colour of the Dice object is stored
	private int currentSide;	// variable where side of the Dice object is stored
	
	// default constructor for the Dice object
	public Dice() {
		this.colour = "white";
		this.currentSide = rollDice();
	}
	
	// second constructor taking a colour input for the Dice object
	public Dice(String colour) {
		this.currentSide = rollDice();
	}
	
	// method which rolls the Dice object and determines its side when called
	public int rollDice() {
		currentSide = (int) (Math.random() * 6+1);
		return currentSide;
	}
	
	// method which sets the Dice object's colour when called
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	// method which returns the Dice object's colour when called
	public String getColour() {
		return colour;
	}
	
	// method which returns the Dice object's side when called
	public int getSide() {
		return currentSide;		
	}
	
	// toString method which makes sure the Dice is printed in the proper format when used
	public String toString() {
		return colour + " dice: " + currentSide + " | ";	
	}
}
