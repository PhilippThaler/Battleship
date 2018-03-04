package com.philippthaler;

public class Player {

    private Grid primaryGrid;
    private Grid trackingGrid;

    private boolean carrierUsed;
    private boolean battleshipUsed;
    private boolean cruiserUsed;
    private boolean submarineUsed;
    private boolean destroyerUsed;

    public Player() {
        primaryGrid = new Grid();
        trackingGrid = new Grid();
        carrierUsed = false;
        battleshipUsed = false;
        cruiserUsed = false;
        submarineUsed = false;
        destroyerUsed = false;
    }

    public void addShips() {
        
    }

    public void shoot(int x, int y) {

    }

    public Grid getPrimaryGrid() {
        return primaryGrid;
    }

    public void setPrimaryGrid(Grid grid) {
        this.primaryGrid = grid;
    }

    public Grid getTrackingGrid() {
        return trackingGrid;
    }
}
