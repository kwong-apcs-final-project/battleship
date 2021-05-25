package com.github.battleship;
import java.util.ArrayList;

/**
 * Class to represent all of the boats for 
 * either the Player or AI
 * @author kbagal
 *
 */
public class BoatBoard {

	private ArrayList<Boat> bboard;
	private ArrayList<Location> safeSpots; //all values not used by boat
	
	/**
	 * Default constructor used for AI
	 * since AI doesn't have boats to start
	 */
	public BoatBoard() 
	{
		bboard = new ArrayList<Boat>(5);
		safeSpots = new ArrayList<Location>(100);
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{
				safeSpots.add(new Location(i, j));
			}
		}
	}
	
	/**
	 * Constructs a new BoatBoard Object
	 * 
	 * @param b1 boat 1
	 * @param b2 boat 2
	 * @param b3 boat 3
	 * @param b4 boat 4
	 * @param b5 boat 5
	 */
	public BoatBoard(Boat b1, Boat b2, Boat b3, Boat b4, Boat b5) 
	{
		bboard = new ArrayList<Boat>(5);
		bboard.add(b1);
		bboard.add(b2);
		bboard.add(b3);
		bboard.add(b4);
		bboard.add(b5);
	}
	
	/**
	 * Method that returns if a location is in the boats
	 * locations or not
	 * @param attemptToHit location to test boats with
	 * @return boolean if true or not
	 */
	public boolean hasHit(Location attemptToHit) 
	{
		for (Boat b : bboard) 
		{
			if (b.isHit(attemptToHit)) 
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to remove a hit location from a boat
	 * @param attemptToHit hit location
	 */
	public void removeLoc(Location attemptToHit) 
	{
		for (Boat b : bboard) 
		{
			if (b.isHit(attemptToHit)) 
			{
				b.removeLoc(attemptToHit);
			}
		}
	}
	
	/**
	 * Method to remove any boats that have no hittable sports left
	 */
	public void ifDeadThenRemove() 
	{
		for (int i = 0; i < bboard.size(); i++) 
		{
			if (bboard.get(i).spotsLeft() == 0) 
			{
				bboard.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Assessor method for num of boats left
	 * @return number of boats
	 */
	public int numBoats() 
	{
		return bboard.size();
	}
	
	
	/**
	 * Method to place a boat of a given length
	 * into a random place in the board
	 * used only in AI.java
	 * 
	 * @param length length of boat to be placed
	 */
	public void placeBoat(int length) 
	{
		int viablePos = 10 - length;
		int row = (int)(Math.random() * viablePos);
		int col = (int)(Math.random() * viablePos);
		//gives values from 0 - len such that adding a ship
		//of size len does not = idx out of bounds
		
		int horizOrVert = (int)(Math.random() * 2); // 0 or 1
		ArrayList<Location> newBoat = new ArrayList<Location>(length);
		int idx = 0;
		if (horizOrVert == 0) // place boat vertically
		{
			for (int r = 0; r < length; r++) 
			{
				Location test = new Location(row + r, col);
				if (locAlreadyUsed(test)) 
				{
					placeBoat(length);
					return;
				}
				else 
				{
					newBoat.add(test);
				}
			}
		}
		else //place boat horizontally
		{
			for (int c = 0; c < length; c++) 
			{
				Location test = new Location(row, col + c);
				if (locAlreadyUsed(test)) 
				{
					placeBoat(length);
					return;
				}
				else 
				{
					newBoat.add(test);
				}
			}
		}
		
		//if reach here, all locations are not in use so add boat
		bboard.add(new Boat(newBoat));
	}
	
	/**
	 * Method to find if a given location is already
	 * being used by another boat or not
	 * 
	 * @param loc
	 */
	public boolean locAlreadyUsed(Location locTest) 
	{
		for (Boat b : bboard) 
		{
			ArrayList<Location> locs = b.getLocations();
			for (Location loc : locs) 
			{
				if (loc.same(locTest)) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Method for adding a boat manually in to the list
	 * used for testing of class
	 * 
	 * @param b boat to add
	 */
	public void addBoatManually(Boat b) 
	{
		bboard.add(b);
	}
	
	/**
	 * ToString method for BoatBoard
	 * To be used for testing
	 */
	public String toString() 
	{
		String returning = "";
		for (int i = 1; i <= bboard.size(); i++) 
		{
			returning += "Boat #" + i + " => " + 
		bboard.get(i - 1).toString() + "\n";
		}
		return returning;
	}
}
