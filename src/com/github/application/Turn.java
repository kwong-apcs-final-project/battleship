package com.github.application;

import com.github.battleship.Location;

public class Turn {
    private Location aiHit;
    private boolean hasHit;


    public Turn(boolean hasHit, Location aiHit) {
        this.hasHit = hasHit;
        this.aiHit = aiHit;
    }

    public Location getAiHit() {
        return aiHit;
    }

    public void setAiHit(Location aiHit) {
        this.aiHit = aiHit;
    }

    public boolean isHasHit() {
        return hasHit;
    }

    public void setHasHit(boolean hasHit) {
        this.hasHit = hasHit;
    }
}
