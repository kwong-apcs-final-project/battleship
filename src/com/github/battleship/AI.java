package com.github.battleship;

public class AI {

	private BoatBoard AIBBoard;
	private PointerBoard AIPBoard;
	
	public AI() 
	{
		
	}
	
	public AI(BoatBoard b, PointerBoard p) 
	{
		AIBBoard = b;
		AIPBoard = p;
	}
	
	//methods that the AI can do
	
	public void placeAIBoats() 
	{
		
	}
	
	public void playAIRound() 
	{
		
	}
	
	public int numBoats() 
	{
		return 1;
	}
	
	public BoatBoard getAIBBaord() 
	{
		return AIBBoard;
	}
	
	public PointerBoard getAIPBoard() 
	{
		return AIPBoard;
	}
}
