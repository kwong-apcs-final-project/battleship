package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that controls the whole game of Battleship
 * Has both the player and AI
 * @author kbagal
 *
 */
public class Game {

	private Player myPlayer;
	private AI myAI;
	
	/**
	 Constructs a new Game object
	 */
	public Game() 
	{
		myPlayer = new Player();
		myAI = new AI();
		
	}
	
	//methods for running game below
	// {
	/**
	 * aMethod for starting game
	 * inputs are locations of boats placed on board by player
	 * 
	 * @param bL1 locations of boat 1
	 * @param bL2 locations of boat 2
	 * @param bL3 locations of boat 3
	 * @param bL4 locations of boat 4
	 * @param bL5 locations of boat 5
	 */
	public void gameBootup(ArrayList<Location> bL1, ArrayList<Location> bL2, 
			ArrayList<Location> bL3, ArrayList<Location> bL4, ArrayList<Location> bL5) 
	{
		myPlayer.placePlayerBoats(bL1, bL2, bL3, bL4, bL5);
		myAI.placeAIBoats();
		printBoard();
		
	}
	
	//plays both Player and AI turns
	/**
	 * Method to play one round of the game
	 * @param ath (attempt to hit) location to try
	 * @return Location where AI is going to hit
	 */
	public Location playRound(Location ath) 
	{
		myPlayer.playPlayerRound(myAI, ath);
		
		//Location is spot where AI is going to fire
		Location AIhit = myAI.playAIRound(myPlayer);
		
		//check if either player dead
		if (myPlayer.numBoats() == 0 ||
				myAI.numBoats() == 0) 
		{
			endGame();
		}
		
		printBoard();
		return AIhit;
		
	}
	
	/**
	 * Game ending method
	 * (May not be in use)
	 */
	public void endGame() 
	{
		if (myPlayer.numBoats() == 0) 
		{
			System.out.println("You lost");
		}
		else 
		{
			System.out.println("NICE! You won!");
		}
		
	}
	// }
	
	//prints out player board + AI Board for testing after each round
	/**
	 * Method to print out board for testing
	 * (May not be in use)
	 */
	public void printBoard() 
	{
		
	}
}
