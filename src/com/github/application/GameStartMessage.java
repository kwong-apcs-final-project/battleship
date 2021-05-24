package com.github.application;

import com.github.battleship.Location;

import java.util.ArrayList;

public class GameStartMessage {
    private ArrayList<ArrayList<Location>> listOfBoatLocations;
    public GameStartMessage (){}
    public GameStartMessage ( ArrayList<ArrayList<Location>> listOfBoatLocations ) {
        this.listOfBoatLocations = listOfBoatLocations;
    }

    public ArrayList<ArrayList<Location>> getListOfBoatLocations() {
        return listOfBoatLocations;
    }

    public void setListOfBoatLocations(ArrayList<ArrayList<Location>> listOfBoatLocations) {
        this.listOfBoatLocations = listOfBoatLocations;
    }
    /*
    Example json
    [ Array list <ArrayList<Location>
      [  Array list <Location>
        {
          "xPos": 2, Location Object
          "yPos": 9
        },
        {
          "xPos": 1, Location Object
          "yPos": 1
        }
      ],
      [
        {
          "xPos": ...,
          "yPos": ...
        },
        {
          "xPos": ...,
          "yPos": ...
        }
      ],
    ]
     */

}
