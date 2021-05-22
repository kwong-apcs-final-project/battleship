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
	
	public void lostBoat() 
	{
		
	}
}
