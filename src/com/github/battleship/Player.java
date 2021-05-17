package com.github.battleship;

public class Player {
	
	private BoatBoard BBoard;
	private PointerBoard PBoard;
	
	public Player() 
	{
		//set BoatBoard in placePlayerBoats()
		PBoard = new PointerBoard();
	}
	
	//methods that Player can do
	
	public void placePlayerBoats() 
	{
		
	}
	
	public void playPlayerRound() 
	{
		
	}
	
	public int numBoats() 
	{
		return 1;
	}
	
	public BoatBoard getBBoard() 
	{
		return BBoard;
	}
	
	public PointerBoard getPBoard() 
	{
		return PBoard;
	}

}
