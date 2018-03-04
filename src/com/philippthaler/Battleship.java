package com.philippthaler;

//
public class Battleship {
    public static final int FIELDSIZE = 10;
    public static final int NUMOFSHIPS = 5;
    public static final char WATER = '~';
    public static final char SHIP = 'S';
    public static final char HIT = 'X';

    public static Player player;
    public static Enemy enemy;

    public Battleship() {
        player = new Player();
        enemy = new Enemy();
    }

    public static boolean checkEnemyHit(int x, int y) {
        if (player.getPrimaryGrid().field[x][y] == SHIP) {
            player.getPrimaryGrid().drawHit(x, y);
            return true;
        }
        return false;
    }


}
