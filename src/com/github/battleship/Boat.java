package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that represents a boat in the game
 * has locations of where it is on board
 * 
 * @author kbagal
 *
 */
public class Boat {
	
	private ArrayList<Location> locations;
	
	//ask if inputs are going to be Locations or x/y coordinates
	/**
	 * Constructs a new Boat Object
	 * 
	 * @param boatLoc locations objects of the given Boat
	 */
	public Boat(ArrayList<Location> boatLoc) 
	{
		locations = boatLoc;
	}
	
	/**
	 * Method that returns whether is given location is
	 * on the boat or not
	 * 
	 * @param attemptToHit location to test
	 * @return boolean if true or not
	 */
	public boolean isHit(Location attemptToHit) 
	{
		for (Location loc : locations) 
		{
			if (loc.same(attemptToHit)) 
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to remove a given hit point from 
	 * Available hit locations
	 * Precondition: attemptToHit.hasHit() == true
	 * 
	 * @param attemptToHit the hit spot
	 */
	public void removeLoc(Location attemptToHit) 
	{
		for (int i = 0; i < locations.size(); i++) 
		{
			if (locations.get(i).same(attemptToHit)) 
			{
				locations.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Assessor method for number of hittable spots left
	 * used to tell if Player/AI is dead or not
	 * 
	 * @return locations.size() = num of hittble spots
	 */
	public int spotsLeft() 
	{
		return locations.size();
	}
	
	/**
	 * Accessor method for locations that boat uses
	 * used in AI.java but can be used for testing as well
	 * 
	 * @return locations the locations the boat uses
	 */
	public ArrayList<Location> getLocations()
	{
		return locations;
	}
	
	/**
	 * ToString method for Boat
	 * To be used for testing
	 */
	public String toString() 
	{
		String returning = "";
		for (Location loc : locations) 
		{
			returning += "(" + loc.toString() + ")  " ;
		}
		return returning;
	}
	
}
