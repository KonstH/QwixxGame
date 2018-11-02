// -------------------------------------------------------
// Assignment #4 - Player Class
// Written by: Konstantin Hristev - 40008099
// For COMP 248 Section S – Winter 2018
//
// The purpose of this program is to run a boardgame which
// can be played by 2-5 players.
//
// This class is made to create a Player object. 
// --------------------------------------------------------

public class Player {

	private String name;	// variable where colour of the Move object is stored
	private String [][] gameBoard = new String [4][11];		// string array where the player's gameboard is stored
	private int cross_R; 	// variable where the last number cross off the Red row is stored
	private int cross_Y; 	// variable where the last number cross off the Yellow row is stored
	private int negativePoints;		// variable where the player's negative points are stored
	private int score;		// variable where score of the player for each colour is stored
	private int cross_G = 13;	// variable where the last number cross off the Green row is stored, set to 13 to properly store the X's in a later method
	private int cross_B = 13;	// variable where the last number cross off the Blue row is stored, set to 13 to properly store the X's in a later method
	
	// constructor which takes 7 inputs and defines a Player object
	public Player(String name, String [][] gameBoard, int cross_R, int cross_Y, int cross_G, int cross_B, int negPts) {
		this.name = name;
		initializeGameboard(gameBoard);
		this.cross_R = cross_R;
		this.cross_Y = cross_Y;
		this.cross_G = cross_G;
		this.cross_B = cross_B;
		negativePoints = negPts;
	}
	
	// constructor which only takes 1 input and sets the name of the Player
	public Player(String name) {
		this.name = name;
	}
	
	// method which initialize's the player's gameboard when called
	public void initializeGameboard(String [][] p) {
		int count1 = 2 ;
		int count2 = 12;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 11; j++) {
				if (i == 0 || i == 1) {
					p[i][j] = Integer.toString(count1);
				}
				if (i == 2 || i == 3) {
					p[i][j] = Integer.toString(count2);
				}
				
			count1++;
			count2--;
			}
		count1 = 2 ;
		count2 = 12;
		}
		gameBoard = p;
	}
	
	// method which returns the player's name when called
	public String getName() {
		return name;
	}
	
	// method which sets the player's name when called
	public void setName(String name) {
		this.name = name;	
	}
	
	// method which returns the last number crossed off the Red row name when called
	public int getcross_R() {
		return cross_R;
	}
	
	// method which sets the last number crossed off the Red row name when called
	public void setcross_R(int cross_R) {
		this.cross_R = cross_R;		
	}
	
	// method which returns the last number crossed off the Yellow row name when called
	public int getcross_Y() {
		return cross_Y;
	}
	
	// method which sets the last number crossed off the Yellow row name when called
	public void setcross_Y(int cross_Y) {
		this.cross_Y = cross_Y;		
	}
	
	// method which returns the last number crossed off the Green row name when called
	public int getcross_G() {
		return cross_G;		
	}
	
	// method which sets the last number crossed off the Green row name when called
	public void setcross_G(int cross_G) {
		this.cross_G = cross_G;
	}
	
	// method which returns the last number crossed off the Blue row name when called
	public int getcross_B() {
		return cross_B;		
	}
	
	// method which sets the last number crossed off the Blue row name when called
	public void setcross_B(int cross_B) {
		this.cross_B = cross_B;
	}
	
	// method which returns a player's negative points
	public int getNegativePoints() {
		return negativePoints;		
	}
	
	// method which sets the amount of negative points desired
	public void setNegativePoints(int negativePoints) {
		this.negativePoints = negativePoints;
	}
	
	// method which adds negative points to a player's total points when called
	public void addNegativePoints(int pts) {
		negativePoints += pts;
	}
	
	// method which prints the gameboard of the player which called the method
	public void printGameBoard(String name) {
		System.out.println(name + "'s Gameboard: ");
		for (int i = 0; i<4; i++) {	
			if (i == 0)
				System.out.print("Red: "); 
			if (i == 1)
				System.out.print("Yellow: ");
			if (i == 2)
				System.out.print("Green: ");
			if (i == 3)
				System.out.print("Blue: ");
			
			for (int j = 0; j<11; j++) 
			System.out.print(gameBoard[i][j] + " ");	

			System.out.println(); 
		}	
		System.out.println();
	}
	
	// method which takes a move input and stores an X in the proper index of the gameboard array
	public void makeMove(Move m) {
		if (Move.convertColourtoNum(m.getColour()) == 0) {
			cross_R = m.getNumber();
			gameBoard[Move.convertColourtoNum(m.getColour())][m.getNumber()-2] = "X";
		}
		if (Move.convertColourtoNum(m.getColour()) == 1) {
			cross_Y = m.getNumber();
			gameBoard[Move.convertColourtoNum(m.getColour())][m.getNumber()-2] = "X";
		}
		if (Move.convertColourtoNum(m.getColour()) == 2) {
			cross_G = m.getNumber();
			gameBoard[Move.convertColourtoNum(m.getColour())][11-(m.getNumber()-1)] = "X";
		}
		if (Move.convertColourtoNum(m.getColour()) == 3) {
			cross_B = m.getNumber();
			gameBoard[Move.convertColourtoNum(m.getColour())][11-(m.getNumber()-1)] = "X";
		}
	}
	
	// method which returns the player's final score when called
	public int getBoardTotal() {
		int total = 0;	// varible where the final score is stored
		int count = 0;	// varible where the amount of X's the player has is stored
		int countR = 0;	// varible where the amount of X's the player has in the Red colour is stored
		int countY = 0;	// varible where the amount of X's the player has in the Yellow colour is stored
		int countG = 0;	// varible where the amount of X's the player has in the Green colour is stored
		int countB = 0;	// varible where the amount of X's the player has in the Blue colour is stored
		
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<11; j++) {
				if (gameBoard[i][j] == "X")
					count++;
			}
			setScore(count);
			if (i == 0)
				countR = getScore();
			if (i == 1)
				countY = getScore();
			if (i == 2)
				countG = getScore();
			if (i == 3)
				countB = getScore();
			count = 0;
		}
		
		total = countR + countY + countG + countB + negativePoints;
		return total;
	}
	
	// method which determines what score the player got depending on the amount of X's on their board
	public void setScore(int count) {
		if (count == 1)
			score = 1;
		else if (count == 2)
			score = 3;
		else if (count == 3)
			score = 6;
		else if (count == 4)
			score = 10;
		else if (count == 5)		// change this so its stored in array later
			score = 15;
		else if (count == 6)
			score = 21;
		else if (count == 7)
			score = 28;
		else if (count == 8)
			score = 36;
		else if (count == 9)
			score = 45;
		else if (count == 10)
			score = 55;
		else if (count == 11)
			score = 66;
		else if (count == 12)
			score = 78;
	}
	
	// method which returns the score the player got depending on the amount of X's on their board
	public int getScore () {
		return score;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
