package com.philippthaler;

// Represents a playerboard where ships can be placed
public class Grid {
    public char[][] field;

    public Grid() {
        field = new char[Battleship.FIELDSIZE][Battleship.FIELDSIZE];
        initField();
    }

    // Initializes the Grid with the char for WATER
    private void initField() {
        for (int i = 0; i < Battleship.FIELDSIZE; i++) {
            for (int j = 0; j < Battleship.FIELDSIZE; j++) {
                field[i][j] = Battleship.WATER;
            }
        }
    }

    public void drawHit(int x, int y) {
        field[x][y] = 'X';
    }

}
