package gameoflife2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class GameOfLife2Test {

    @Test
    public void itShouldLiveIfThereAre2Neighbours() throws Exception {
        boolean[][] field = {
                {true, true, true}
        };
        boolean[][] expected = {
                {false, true, false}
        };

        GameOfLife game = new GameOfLife(field);
        assertArrayEquals(expected, game.getNextGeneration());
    }

    @Test
    public void itShouldLiveIfThereAre3Neighbours() throws Exception {
        boolean[][] field = {
                {true, true, true},
                {false, true, false}
        };
        boolean[][] expected = {
                {true, true, true},
                {true, true, true}
        };

        GameOfLife game = new GameOfLife(field);
        assertArrayEquals(expected, game.getNextGeneration());
    }


    @Test
    public void itShouldDieIfThereAreMoreThan3Neighbours() throws Exception {
        boolean[][] field = {
                {true, true, true},
                {true, true, false}
        };
        boolean[][] expected = {
                {true, false, true},
                {true, false, true}
        };

        GameOfLife game = new GameOfLife(field);
        assertArrayEquals(expected, game.getNextGeneration());
    }

    @Test
    public void itShouldRebornIfThereAre3Neighbours() throws Exception {
        boolean[][] field = {
                {true, false, true},
                {false, true, false}
        };
        boolean[][] expected = {
                {false, true, false},
                {false, true, false}
        };

        GameOfLife game = new GameOfLife(field);
        assertArrayEquals(expected, game.getNextGeneration());
    }

    @Test
    public void itShouldDieIfThereAreLessThan2Neighbours() throws Exception {
        boolean[][] field = {
                {true, true, false},
                {false, false, false}
        };
        boolean[][] expected = {
                {false, false, false},
                {false, false, false}
        };

        GameOfLife game = new GameOfLife(field);
        assertArrayEquals(expected, game.getNextGeneration());
    }


    private class GameOfLife {
        private boolean[][] field;

        private GameOfLife(boolean[][] field) {
            this.field = field;
        }

        public boolean[][] getNextGeneration() {
            boolean[][] next = new boolean[field.length][field[0].length];

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    int aliveNeighbours = countNeighbours(i, j);

                    if (aliveNeighbours == 2) {
                        next[i][j] = field[i][j];
                    }

                    if (aliveNeighbours == 3) {
                        next[i][j] = true;
                    }
                }
            }

            System.out.println(Arrays.deepToString(next));

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
