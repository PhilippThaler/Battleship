package com.philippthaler;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy {
    private Grid grid;

    public Enemy() {
        grid = new Grid();
        placeShips();
    }

    private void placeShips() {
        boolean twoShipsSize3 = false;

        for (int i = Battleship.NUMOFSHIPS; i > 0; i--) {
            // Wählt die Ausrichtung der Schiffe (horizontal/vertikal)
            int direction = ThreadLocalRandom.current().nextInt(0, 2);
            // Zufällige Positionen
            int posX = ThreadLocalRandom.current().nextInt(0, Battleship.FIELDSIZE);
            int posY = ThreadLocalRandom.current().nextInt(0, Battleship.FIELDSIZE);

            boolean hasSpace = false;

            while (true) {
                // Prüft ob das Schiff mit der Größe i Platz hat
                for (int j = 0; j < i; j++) {
                    // Wenn Vertikal
                    if (direction == 0) {
                        if (posY + i < Battleship.FIELDSIZE) {
                            if (grid.field[posX][posY + j] != '~') {
                                hasSpace = false;
                                continue;
                            } else {
                                hasSpace = true;
                            }
                        }
                    }

                    // Wenn Horizontal
                    if (direction == 1) {
                        if (posX + i < Battleship.FIELDSIZE) {
                            if (grid.field[posX + j][posY] != '~') {
                                hasSpace = false;
                                continue;
                            } else {
                                hasSpace = true;
                            }
                        }
                    }
                }

                // Wenn kein Platz, generiere neue Koordinaten
                if (!hasSpace) {
                    posX = ThreadLocalRandom.current().nextInt(0, Battleship.FIELDSIZE);
                    posY = ThreadLocalRandom.current().nextInt(0, Battleship.FIELDSIZE);
                } else {
                    break;
                }

            }
            // Platziert die Schiffe
            // Wenn Vertikal
            if (direction == 0) {
                for (int j = 0; j < i; j++) {
                    grid.field[posX][posY + j] = Battleship.SHIP;
                }
            }

            // Wenn Horizontal
            if (direction == 1) {
                for (int j = 0; j < i; j++) {
                    grid.field[posX + j][posY] = Battleship.SHIP;
                }
            }
            if (i == 3 && !twoShipsSize3) {
                i++;
                twoShipsSize3 = true;
            }
        }
    }

    public void shoot() {
        // Zufällige Positionen
        int posX = ThreadLocalRandom.current().nextInt(0, Battleship.FIELDSIZE);
        int posY = ThreadLocalRandom.current().nextInt(0, Battleship.FIELDSIZE);

        if (Battleship.checkEnemyHit(posX, posY)) {
            System.out.println("Hit at Coordinates X:" + posX + " Y:" + posY);
        }
    }

    public Grid getGrid() {
        return grid;
    }
}
