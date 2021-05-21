package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that represents a player
 * can do all methods that a player of the game 
 * would need when playing against AI
 * 
 * @author kbagal
 *
 */
public class Player {
	
	private BoatBoard BBoard;
	private PointerBoard PBoard;
	
	/**
	 * Constructs a new Player Object
	 */
	public Player() 
	{
		//set BoatBoard in placePlayerBoats()
		PBoard = new PointerBoard();
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
	 * @param attemptToHit
	 */
	public void playPlayerRound(Location attemptToHit) 
	{
		//use method "Does hit" in BBoard
		//use boat method "hit point" to change it
	}
	
	/**
	 * Assessor method for all boats in play
	 * @return boats
	 */
	public int numBoats() 
	{
		return 1;
	}
	
	/**
	 * Assessor method for number of boats still in play
	 * @return num of Boats
	 */
	public BoatBoard getBBoard() 
	{
		return BBoard;
	}
	
	/**
	 * Assessor method for number of boats still in play
	 * @return all pointers
	 */
	public PointerBoard getPBoard() 
	{
		return PBoard;
	}

}
