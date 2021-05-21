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
	
	public ArrayList<Location> calculateHittable(Boat b)
	{
		//return an arrayList of even single hittable
		//object for a given boat
		return new ArrayList<Location>();
	}
	
}
