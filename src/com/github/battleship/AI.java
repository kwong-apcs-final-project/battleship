package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that represents an AI, the player's opponent
 * And thus does all the methods that a player does
 * but automated
 * 
 * This AI can shoot at the Player, get shot by the Player
 * and tell if it is dead
 * 
 * @author kbagal
 *
 */
public class AI {

	private BoatBoard AIBBoard;
	private ArrayList<Location> spotsLeft;
	
	/**
	 * Default constructor
	 * Used to construct all necesary components
	 */
	public AI() 
	{
		AIBBoard = new BoatBoard();
		//AIBBoard is going to be initialized in placeAIBoats
		//maybe change placeAIBoats into here when cleaning up
		spotsLeft = new ArrayList<Location>(100);
		for (int i = 1; i <= 10; i++) 
		{
			for (int j = 1; j <= 10; j++) 
			{
				spotsLeft.add(new Location(i, j));
			}
		}
	}
	
	
	//methods that the AI can do
	
	/**
	 * Method to place boats of AI randomly
	 * into AIBBoard with boat size of 5, 4, 3, 3, 2
	 * (the standard boat # and lengths)
	 */
	public void placeAIBoats() 
	{
		//place 5 boats, each with different lengths
		//use method placeBoat for this
		AIBBoard.placeBoat(5);
		AIBBoard.placeBoat(4);
		AIBBoard.placeBoat(3);
		AIBBoard.placeBoat(3);
		AIBBoard.placeBoat(2);
	}
	
	/**
	 * Method to choose a random firing location
	 * and fire there
	 * 
	 * @param p player to fire to
	 */
	public Location playAIRound(Player p) 
	{
		int size = spotsLeft.size();
		int randIdx = (int)(Math.random() * size);
		
		p.getShot(spotsLeft.get(randIdx));
		
		//return Location where shooting
		//for use in frontend
		Location returning = spotsLeft.get(randIdx);
		spotsLeft.remove(randIdx);
		return (returning);
		
	}
	
	/**
	 * Method for getting hit by player, acts just like 
	 * Player.getShot()
	 * 
	 * @param attemptToHit players' shot
	 */
	public void getShot(Location attemptToHit) 
	{
		//plug in same thing as Player.java
		//use method "Does hit" in BBoard
		//use boat method "hit point" to change it
		boolean hits = AIBBoard.hasHit(attemptToHit);
		if (hits) 
		{
			//remove location from boat
			AIBBoard.removeLoc(attemptToHit);
			AIBBoard.ifDeadThenRemove();
		}
	}
	
	/**
	 * Accessor method for AIBBoard number of boats
	 * used for telling if game is over or not
	 * 
	 * @return AiBBoard.numBoats if dead or not if 0
	 */
	public int numBoats() 
	{
		return AIBBoard.numBoats();
	}
	
	/**
	 * Accessor method for AIBBoard
	 * to be used in testing, not in game logic
	 * 
	 * @return AIBBoard the BBoard
	 */
	public BoatBoard getAIBBoard() 
	{
		return AIBBoard;
	}
	
	
	/**
	 * ToString method for AI
	 * To be used for testing
	 */
	public String toString() 
	{
		return AIBBoard.toString();
	}
}
