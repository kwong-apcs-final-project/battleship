package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that represents a player
 * can do all methods that a player of the game 
 * would need when playing against AI
 * 
 * This involves the firing against an AI
 * Getting shot by an AI
 * and checking to see if dead
 * 
 * @author kbagal
 *
 */
public class Player {
	
	private BoatBoard BBoard;

	
	/**
	 * Constructs a new Player Object
	 */
	public Player() 
	{
		//set BoatBoard in placePlayerBoats()
	}
	
	//methods that Player can do
	
	/**
	 * Method called at the start of the game
	 * to give the player object all of the boats that have been placed
	 * 
	 * @param bL1 locations of boat 1
	 * @param bL2 locations of boat 2
	 * @param bL3 locations of boat 3
	 * @param bL4 locations of boat 4
	 * @param bL5 locations of boat 5
	 */
	public void placePlayerBoats(ArrayList<Location> bL1, ArrayList<Location> bL2, 
			ArrayList<Location> bL3, ArrayList<Location> bL4, ArrayList<Location> bL5) 
	{
		BBoard = new BoatBoard(new Boat(bL1), new Boat(bL2), 
				new Boat(bL3), new Boat(bL4), new Boat(bL5));
	}
	
	/**
	 * Method called at the start of every turn
	 * Checks if attempted fire hits boat or not and
	 * changes the boats appropriately
	 * @param attemptToHit the place to shoot to
	 */
	public void getShot(Location attemptToHit) 
	{
		//use method "Does hit" in BBoard
		//use boat method "hit point" to change it
		boolean hits = BBoard.hasHit(attemptToHit);
		if (hits) 
		{
			//remove location from boat
			BBoard.removeLoc(attemptToHit);
			BBoard.ifDeadThenRemove();
		}
	}
	
	/**
	 * Method to shoot at enemy
	 * @param enemy the AI to fire to
	 * @param hitter location to try
	 */
	public void playPlayerRound(AI enemy, Location hitter) 
	{
		enemy.getShot(hitter);
	}
	
	/**
	 * Assessor method for number of boats in play
	 * used to tell if player is dead or not
	 * 
	 * @return BBoard.numBoats() if dead or not if 0
	 */
	public int numBoats() 
	{
		return BBoard.numBoats();
	}
	
	/**
	 * Assessor method for all boats still in play
	 * Used in testing, not game logic
	 * 
	 * @return BBoard the Boat Board
	 */
	public BoatBoard getBBoard() 
	{
		return BBoard;
	}
	

	/**
	 * ToString method for Player
	 * To be used for testing
	 */
	public String toString() 
	{
		return BBoard.toString();
	}
}
