package com.github.application;

import com.github.battleship.Location;

public class Turn {
    private Location loc;
    private String uid;

    /**
     * Data model for client and AI turn
     * @param loc Coordinate location for the hit spot
     */
    public Turn(Location loc, String uid) {
        this.uid = uid; this.loc = loc;
    }

    public Location getLocation() {
        return loc;
    }
    public String getUUID () {
        return uid;
    }
}
