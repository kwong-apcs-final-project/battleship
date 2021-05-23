package com.github.battleship;

import java.util.ArrayList;

/**
 * Class that represents a board of all places
 * where the AI has shot to
 * 
 * MAY BE DELETED LATER IF NEEDED
 * 
 * @author kbagal
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
