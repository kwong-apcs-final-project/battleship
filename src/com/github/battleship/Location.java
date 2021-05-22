package com.github.battleship;

public class Location {
	
	private int xPos;
	private int yPos;
	
	public Location()
	{
		xPos = 0;
		yPos = 0;
	}
	
	public Location(int x, int y) 
	{
		xPos = x;
		yPos = y;
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY() 
	{
		return yPos;
	}
	
	public void addX(int x) 
	{
		xPos += x;
	}
	
	public void addY(int y) 
	{
		yPos += y;
	}
	
	public void changeX(int x) 
	{
		xPos = x;
	}
	
	public void changeY(int y) 
	{
		yPos = y;
	}
	
	public int[] getLocation() 
	{
		int[] returning = {xPos, yPos};
		return returning;
	}
}
