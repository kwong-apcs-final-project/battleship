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
	
	public void lostBoat() 
	{
		
	}
}
