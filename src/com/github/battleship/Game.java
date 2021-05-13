package com.github.battleship;

public class Game {

	private Player myPlayer;
	private AI myAI;
	
	public Game() 
	{
		myPlayer = new Player(new BoatBoard(),
				new PointerBoard());
		myAI = new AI(new BoatBoard(),
				new PointerBoard());
		
	}
	
	//methods for running game below
	// {
	public void gameBootup() 
	{
		myPlayer.placePlayerBoats();
		myAI.placeAIBoats();
		printBoard();
		
	}
	
	//plays both Player and AI turns
	public void playRound() 
	{
		
	}
	
	public void endGame() 
	{
		
	}
	// }
	
	//prints out player board + AI Board for testing after each round
	public void printBoard() 
	{
		
	}
}
