package minesweeper;

public class FieldUtils {

    public boolean isBottom(String[][] field, int row) {
        return (field.length == row + 1);
    }

    public boolean isCeiling(int row) {
        return (row == 0);
    }

    public boolean isLeft(int column) {
        return (column == 0);
    }

    public boolean isRight(String[][] field, int column) {
        return (field[0].length == column + 1);
    }
}
