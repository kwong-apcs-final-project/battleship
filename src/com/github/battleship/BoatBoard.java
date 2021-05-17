package com.github.battleship;
import java.util.ArrayList;

public class BoatBoard {

	private ArrayList<Boat> bboard;
	
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
