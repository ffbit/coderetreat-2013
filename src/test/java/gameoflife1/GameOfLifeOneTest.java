package gameoflife1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeOneTest {

    @Test
    public void itShouldDieIfThereAreLessThan2Neighbours() throws Exception {
        boolean[][] field = {{true}};
        boolean[][] expectedField = {{false}};

        GameOfLife game = new GameOfLife(field);
        assertThat(game.nextGeneration(), is(expectedField));
    }


    @Test
    public void itShouldLiveIfThereAreThan2Neighbours() throws Exception {
        boolean[][] field = {{true, true, true}};
        boolean[][] expectedField = {{false, true, false}};

        GameOfLife game = new GameOfLife(field);
        assertThat(game.nextGeneration(), is(expectedField));
    }

    @Test
    public void itShouldLiveIfThereAreThan3Neighbours() throws Exception {
        boolean[][] field = {
                {true, true, true},
                {false, true, false}
        };
        boolean[][] expectedField = {
                {true, true, true},
                {false, true, false}
        };

        GameOfLife game = new GameOfLife(field);
        assertThat(game.nextGeneration(), is(expectedField));
    }


    private class GameOfLife {
        private boolean[][] field;

        private GameOfLife(boolean[][] field) {
            this.field = field;
        }

        public boolean[][] nextGeneration() {
            boolean[][] nextGeneration = new boolean[field.length][field[0].length];

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    int liveNeighbours = countNeighbours(i, j);

                    if (liveNeighbours == 2) {
                        nextGeneration[i][j] = field[i][j];
                    } else {
                        if (liveNeighbours == 3) {
                            nextGeneration[i][j] = field[i][j];


                        } else {

                            nextGeneration[i][j] = false;

                        }


                    }


                }
            }

            return nextGeneration;
        }

        private int countNeighbours(int i, int j) {
            int count = 0;
            for (int k = -1; k <= 1; k++) {
                for (int m = -1; m <= 1; m++) {
                    if (k != m && k != 0) {
                        int x = i + m;
                        int y = j + k;

                        if (x >= 0
                                && y >= 0
                                && x < field.length
                                && y < field[x].length) {
                            count++;
                        }
                    }
                }
            }

            return count;
        }
    }
}
