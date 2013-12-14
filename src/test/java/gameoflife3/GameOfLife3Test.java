package gameoflife3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GameOfLife3Test {

    @Test
    public void itShouldDieIfThereAreMoreThan3Neighbours() throws Exception {
        boolean[][] field = {
                {true, true, true},
                {false, true, true}
        };
        boolean[][] expectedField = {
                {true, false, true},
                {true, false, true}
        };

        GameOfLife game = new GameOfLife(field);
        boolean[][] actual = game.nextGeneration();
        Assert.assertArrayEquals("Failed: " + Arrays.deepToString(actual), expectedField, actual);
    }

    @Test
    public void itShouldStillAliveIfThereAre2Neighbours() throws Exception {
        boolean[][] field = {
                {true, true, true}
        };
        boolean[][] expectedField = {
                {false, true, false}
        };
        GameOfLife game = new GameOfLife(field);
        Assert.assertArrayEquals(expectedField, game.nextGeneration());
    }

    @Test
    public void itShouldStillAliveIfThereAre3Neighbours() throws Exception {
        boolean[][] field = {
                {true, true, true},
                {false, true, false}
        };
        boolean[][] expectedField = {
                {true, true, true},
                {true, true, true}
        };
        GameOfLife game = new GameOfLife(field);
        boolean[][] actual = game.nextGeneration();
        Assert.assertArrayEquals("Failed: " + Arrays.deepToString(actual), expectedField, actual);
    }

    @Test
    public void itShouldBearIfThereAre3Neighbours() throws Exception {
        boolean[][] field = {
                {true, false, true},
                {false, true, false}
        };
        boolean[][] expectedField = {
                {false, true, false},
                {false, true, false}
        };
        GameOfLife game = new GameOfLife(field);
        boolean[][] actual = game.nextGeneration();
        Assert.assertArrayEquals("Failed: " + Arrays.deepToString(actual), expectedField, actual);
    }

    public static class GameOfLife {
        private boolean[][] field;

        public GameOfLife(boolean[][] field) {
            this.field = field;
        }

        public boolean[][] nextGeneration() {
            boolean[][] next = new boolean[field.length][field[0].length];

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    int neighbourCount = countNeighbours(i, j);

                    if (neighbourCount == 2) {
                        next[i][j] = field[i][j];
                    }
                    if(neighbourCount == 3){
                        next[i][j] = true;
                    }
                }
            }

            field = next;

            return next;
        }

        private int countNeighbours(int x, int y) {
            int count = 0;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == j && i == 0) {
                        continue;
                    }

                    int nx = x + i;
                    int ny = y + j;

                    if (nx >= 0
                            && ny >= 0
                            && nx < field.length
                            && ny < field[x].length
                            && field[nx][ny]) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
