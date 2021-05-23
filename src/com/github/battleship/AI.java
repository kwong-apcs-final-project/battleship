package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that represents an AI, the player's opponent
 * 
 * IN PROGRESS
 * 
 * @author kbagal
 *
 */
public class AI {

	private BoatBoard AIBBoard;
	private PointerBoard AIPBoard;
	
	/**
	 * Default constructor just in case
	 */
	public AI() 
	{
		AIPBoard = new PointerBoard();
		//AIBBoard is going to be initialized in placeAIBoats
		//maybe change placeAIBoats into here when cleaning up
	}
	
	/**
	 * Constructs a new AI object
	 * @param b board to insert
	 */
	public AI(BoatBoard b) 
	{
		AIBBoard = b;
		AIPBoard = new PointerBoard();
	}
	
	//methods that the AI can do
	
	/**
	 * Method to place boats of AI randomly
	 * into AIBBoard
	 */
	public void placeAIBoats() 
	{
		
	}
	
	/**
	 * Method to choose a random firing location
	 * and fire there
	 * @param p player to fire to
	 */
	public void playAIRound(Player p) 
	{
		int row = 0;
		int col = 0;
		do 
		{
			row = (int) (Math.random() * 10);
			col = (int) (Math.random() * 10);
		}while(AIPBoard.isContained(new Location(row, col)));
		
		p.getShot(new Location(row, col));
	}
	
	/**
	 * Method for getting hit by player
	 * @param attemptToHit players' shot
	 */
	public void getShot(Location attemptToHit) 
	{
		//plug in same thing as Player.java
	}
	
	/**
	 * Accessor method for AIBBoard number of boats
	 * used for telling if game is over or not
	 * @return 
	 */
	public int numBoats() 
	{
		return AIBBoard.numBoats();
	}
	
	/**
	 * Accessor method for AIBBoard
	 * @return AIBBoard the board
	 */
	public BoatBoard getAIBBaord() 
	{
		return AIBBoard;
	}
	
	/**
	 * Accessor method for AIPBoard
	 * @return AIPBoard the board
	 */
	public PointerBoard gotAIPBoard() 
	{
		return AIPBoard;
	}
	
}
