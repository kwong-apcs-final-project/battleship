package com.github.battleship;

import java.util.ArrayList;

public class TestingInCode {
	
	public static void main(String[] args) 
	{
		//REMOVE COMMENTS FOR WHATEVER CLASSES
		//YOU WANT TO TEST
		
		//testGame();
		//testPlayer();
		//testAI();
		//testBoatBoard();
		//testBoat();
		//testLocation();
	}
	
	/**
	 * Testing method for Game.java
	 */
	public static void testGame() 
	{
		Game g = new Game();
		ArrayList<Location> locs = new ArrayList<Location>(2);
		locs.add(new Location(1, 2));
		locs.add(new Location(1, 3));
		ArrayList<Location> locs2 = new ArrayList<Location>(2);
		locs.add(new Location(2, 2));
		locs.add(new Location(2, 3));
		ArrayList<Location> locs3 = new ArrayList<Location>(2);
		locs.add(new Location(3, 2));
		locs.add(new Location(3, 3));
		ArrayList<Location> locs4 = new ArrayList<Location>(2);
		locs.add(new Location(4, 2));
		locs.add(new Location(4, 3));
		ArrayList<Location> locs5 = new ArrayList<Location>(2);
		locs.add(new Location(5, 2));
		locs.add(new Location(5, 3));
		g.gameBootup(locs, locs2, locs3, locs4, locs5);
		System.out.print(g.toStringNoPlayer());
	}
	
	/**
	 * Testing method for Player.java
	 */
	public static void testPlayer() 
	{
		ArrayList<Location> locs = new ArrayList<Location>(2);
		locs.add(new Location(1, 2));
		locs.add(new Location(1, 3));
		ArrayList<Location> locs2 = new ArrayList<Location>(2);
		locs.add(new Location(2, 2));
		locs.add(new Location(2, 3));
		ArrayList<Location> locs3 = new ArrayList<Location>(2);
		locs.add(new Location(3, 2));
		locs.add(new Location(3, 3));
		ArrayList<Location> locs4 = new ArrayList<Location>(2);
		locs.add(new Location(4, 2));
		locs.add(new Location(4, 3));
		ArrayList<Location> locs5 = new ArrayList<Location>(2);
		locs.add(new Location(5, 2));
		locs.add(new Location(5, 3));
		
		Player p = new Player();
		p.placePlayerBoats(locs, locs2, locs3, locs4, locs5);
		System.out.println(p);
		System.out.println(p.numBoats()); //works as intended even though print doesn't work
		
		//same get shot so that works as well
		
	}
	
	/**
	 * Testing method for AI.java
	 */
	public static void testAI() 
	{
		AI a = new AI();
		a.placeAIBoats();
		System.out.println(a);
		ArrayList<Location> locs = new ArrayList<Location>(2);
		locs.add(new Location(1, 2));
		locs.add(new Location(1, 3));
		Boat boat = new Boat(locs);
		a.getAIBBoard().addBoatManually(boat);
		System.out.println(a);
		a.getShot(new Location(1, 2));
		System.out.println(a);
		a.getShot(new Location(1, 3));
		System.out.println(a);
	}
	
	/**
	 * Testing method for BoatBoard.java
	 */
	public static void testBoatBoard() 
	{
		BoatBoard bb = new BoatBoard();
		bb.placeBoat(5);
		bb.placeBoat(4);
		bb.placeBoat(3);
		bb.placeBoat(3);
		bb.placeBoat(2);
		System.out.println(bb);
		
		ArrayList<Location> locs = new ArrayList<Location>(2);
		locs.add(new Location(1, 2));
		locs.add(new Location(1, 3));
		Boat boat = new Boat(locs);
		bb.addBoatManually(boat);
		System.out.println(bb.hasHit(new Location(1, 2)));
		System.out.println(bb);
		bb.removeLoc(new Location(1, 2));
		System.out.println(bb);
		bb.removeLoc(new Location(1, 3));
		System.out.println(bb);
		bb.ifDeadThenRemove();
		System.out.println(bb);
		
	}
	
	/**
	 * Testing method for Boat.java
	 */
	public static void testBoat() 
	{
		ArrayList<Location> locs = new ArrayList<Location>(2);
		locs.add(new Location(1, 2));
		locs.add(new Location(1, 3));
		Boat boat = new Boat(locs);
		
		System.out.println(boat);
		System.out.println(boat.isHit(new Location(2, 5)));
		boat.removeLoc(new Location(1, 2));
		System.out.println(boat);
		System.out.println(boat.spotsLeft());
	}
	
	/**
	 * Testing method for Location.java
	 */
	public static void testLocation() 
	{
		Location loc = new Location(5, 5);
		Location loc2 = new Location(5, 6);
		System.out.println(loc);
		System.out.println(loc.equals(loc2));
		System.out.println(loc.equals(loc));
		System.out.println(loc.getLocation());
		System.out.println(loc.getX() + " " + loc.getY());
	}
}


