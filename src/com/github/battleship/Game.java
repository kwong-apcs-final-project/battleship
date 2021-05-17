package com.github.battleship;

public class Game {

	private Player myPlayer;
	private AI myAI;
	
	public Game() 
	{
		myPlayer = new Player();
		myAI = new AI();
		
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
		myPlayer.playPlayerRound();
		myAI.playAIRound();
		
		if (myPlayer.numBoats() == 0 ||
				myAI.numBoats() == 0) 
		{
			endGame();
		}
		
		printBoard();
		
	}
	
	public void endGame() 
	{
		if (myPlayer.numBoats() == 0) 
		{
			System.out.println("You lost");
		}
		else 
		{
			System.out.println("NICE! You won!");
		}
		
	}
	// }
	
	//prints out player board + AI Board for testing after each round
	public void printBoard() 
	{
		
	}
}
