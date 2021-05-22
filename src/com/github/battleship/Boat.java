package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that represents a boat in the game
 * has locations of where it is on board
 * @author kbagal
 *
 */
public class Boat {
	
	private ArrayList<Location> locations;
	private ArrayList<Location> hits;
	
	//ask if inputs are going to be Locations or x/y coordinates
	/**
	 * Constructs a new Boat Object
	 * @param boatLoc locations objects of the given Boat
	 */
	public Boat(ArrayList<Location> boatLoc) 
	{
		locations = boatLoc;
		hits = new ArrayList<Location>(5);
		
	}
	
	/**
	 * Method that returns whether is given location is
	 * on the boat or not
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
		return true;
	}
	
	/**
	 * Method to remove a given hit point from 
	 * Available hit locations
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
	 * @return locations.size() = num of hittble spots
	 */
	public int spotsLeft() 
	{
		return locations.size();
	}
	
	public ArrayList<Location> calculateHittable(Boat b)
	{
		//return an arrayList of even single hittable
		//object for a given boat
		return new ArrayList<Location>();
	}
	
}
