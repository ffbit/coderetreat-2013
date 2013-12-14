package gameoflife3;

import gameoflife3.GameOfLife3Test.GameOfLife;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameOfLifeMain {

    public static void main(String...args) throws Exception {
        GameOfLife game = new GameOfLife(generateField());

        for (int i = 0; i < 100; i++) {
            printField(game.nextGeneration());
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private static void printField(boolean[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j]) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }

            System.out.println();
        }
    }

    private static boolean[][] generateField() {
        int n = 10;
        boolean[][] field = new boolean[n][n];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Random(System.nanoTime()).nextBoolean();
            }
        }

        return field;
    }

}
