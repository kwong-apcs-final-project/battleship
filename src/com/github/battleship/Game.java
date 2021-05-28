package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that controls the whole game of Battleship
 * Has both the player and AI and uses their methods
 * to preform the most basic of game logic
 * 
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
	 * Method for starting game
	 * It also places all of the different AI boats
	 * 
	 * Inputs are locations of boats placed on board by player
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
		
	}
	
	//plays both Player and AI turns
	/**
	 * Method to play one round of the game
	 * and check if the game has ended or not
	 * 
	 * @param ath (attempt to hit) location to try to fire to by player
	 * @return Location where AI is going to hit for use in frontend
	 */
	public Location playRound(Location ath) 
	{
		myPlayer.playPlayerRound(myAI, ath);
		
		//Location is spot where AI is going to fire
		//for use in front end
		Location AIhit = myAI.playAIRound(myPlayer);
		
		//check if either player dead
		if (myPlayer.numBoats() == 0 ||
				myAI.numBoats() == 0) 
		{
			//returns (-1, 1) if player wins
			//returns (1, -1) if AI wins
			return (endGame());
		}
		
		return AIhit;
		
	}
	
	/**
	 * Method to return a boolean for whether a player has gotten
	 * hit if it gets shot at a certain location
	 * 
	 * To be used in the frontend of the code, not used for game logic
	 * 
	 * @param loc location to test if player gets hit
	 * @return boolean whether player gets hit at that location or not
	 */
	public boolean playerHit(Location loc) 
	{
		return myPlayer.getBBoard().hasHit(loc);
	}
	
	/**
	 * Game ending method
	 * Returns a different set of locations depending on who won
	 * 
	 * @return Location (-1, 1) if Player win, (1, -1) if AI win
	 */
	public Location endGame() 
	{
		if (myPlayer.numBoats() == 0) 
		{
			//player wins
			return (new Location(-1, 1));
		}
		else
		{
			//AI wins
			return (new Location(-1, 1));
		}
		
	}
	// }
	
	/**
	 * Accessor method for myPlayer
	 * To be used for testing
	 * 
	 * @return myPlayer the game's player
	 */
	public Player getMyPlayer() 
	{
		return myPlayer;
	}
	
	/**
	 * ToString method for Game
	 * To be used for testing
	 */
	public String toString() 
	{
		String returning = "Players Boats: \n" + myPlayer.toString() 
		+ "\n" + "AI's Boats: \n" + myAI.toString();
		return (returning);
	}
	
	/**
	 * ToString method for Game 
	 * without player since player = null
	 * at start without boats being initialized
	 * 
	 * @return toString w/o player
	 */
	public String toStringNoPlayer() 
	{
		return myAI.toString();
	}
}
