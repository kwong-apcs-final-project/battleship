package com.github.battleship;

import java.util.ArrayList;

public class Boat {
	
	private Location[] locations;
	private int numHittable;
	
	//ask if inputs are going to be Locations or x/y coordinates
	public Boat(int x, int y) 
	{
		locations = new Location[1];
		locations[0] = new Location(x, y);
	}
	
	public ArrayList<Location> calculateHittable(Boat b)
	{
		//return an arrayList of even single hittable
		//object for a given boat
		return new ArrayList<Location>();
	}
	
}
