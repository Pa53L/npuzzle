package Solver;

import java.util.Arrays;

import static Utils.ColorPrint.*;

public class Board {
    private int[][] blocks;
    private int zeroX;
    private int zeroY;
    private int size;

    public Board(int[][] field) {
        size = field.length;
        try {
            deepCopy(field);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        print(RED, this.toString(), true);
    }

    private void deepCopy(int[][] field) throws IllegalArgumentException {
        if (field == null) {
            blocks = null;
        }
        blocks = new int[size][size];
        for (int i = 0; i < size; i++) {
            if (field != null) {
                System.arraycopy(field[i], 0, blocks[i], 0, size);
            } else {
                throw new IllegalArgumentException("invalid input");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            sb.append(Arrays.toString(blocks[i]));
            sb.append("\n");
        }
        return sb.toString();
    }
}
