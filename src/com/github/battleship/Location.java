package com.github.battleship;


/**
 * Class that represents a given point on a grid
 * with x and y positions
 * @author kbagal
 *
 */
public class Location {
	
	private int xPos;
	private int yPos;
	
	/**
	 * Constructs a new Location object default version
	 */
	public Location()
	{
		xPos = 0;
		yPos = 0;
	}
	
	/**
	 * Constructs a new Location object 
	 * based on input parameters
	 * @param x x-coord of point
	 * @param y y-coord of point
	 */
	public Location(int x, int y) 
	{
		xPos = x;
		yPos = y;
	}
	
	/**
	 * Assessor method for X
	 * @return X the X position
	 */
	public int getX()
	{
		return xPos;
	}
	
	/**
	 * Assessor method for Y
	 * @return Y the Y position
	 */
	public int getY() 
	{
		return yPos;
	}
	
	/**
	 * Method to add value to X
	 * @param x amount to add
	 */
	public void addX(int x) 
	{
		xPos += x;
	}
	
	/**
	 * Method to add value to y
	 * @param y amount to add
	 */
	public void addY(int y) 
	{
		yPos += y;
	}
	
	/**
	 * Method to change X all together
	 * @param x what to change to
	 */
	public void changeX(int x) 
	{
		xPos = x;
	}
	
	/**
	 * Method to change Y all together
	 * @param y what to change to
	 */
	public void changeY(int y) 
	{
		yPos = y;
	}
	
	/**
	 * Method to tell if one location is same as given one
	 * @param other other location to test
	 * @return boolean if same or not
	 */
	public boolean same(Location other) 
	{
		if (xPos == other.getX() && yPos == other.getY()) 
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Method to return both x and y
	 * @return returning an array of x and y positions
	 */
	public int[] getLocation() 
	{
		int[] returning = {xPos, yPos};
		return returning;
	}
	
	/**
	 * ToString method for Location
	 * To be used for testing
	 */
	public String toString() 
	{
		return ("x = " + xPos + " y = " + yPos);
	}
}
