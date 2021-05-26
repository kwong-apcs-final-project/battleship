package com.github.battleship;

import java.util.ArrayList;

/*
 * 
 * CLASS NOT IN USE ANYMORE
 *
 */
public class PointerBoard {

	private ArrayList<Location> pboard;
	
	/**
	 * Constructs a new PointerBoard Object
	 */
	public PointerBoard() 
	{
		pboard = new ArrayList<Location>(100);
	}
	
	/**
	 * Method to determine if given location 
	 * has already been fired at
	 * @param loc location to test
	 * @return boolean if fired or not
	 */
	public boolean isContained(Location loc) 
	{
		for (int i = 0; i < pboard.size(); i++) 
		{
			if (pboard.get(i).same(loc)) 
			{
				return true;
			}
		}
		return false;
	}
	
	
}
