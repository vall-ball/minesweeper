package minesweeper;

public class FieldForUser {
    String[][] field;
    GameField gameField;
    FieldProcessor processor = new FieldProcessor();
    FieldUtils utils = new FieldUtils();

    public FieldForUser() {
        field = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j] = ".";
            }
        }
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public GameField getGameField() {
        return gameField;
    }



    public void markCellAsMine(int row, int column) {
        if ("*".equals(field[row][column])) {
            field[row][column] = ".";
        } else {
            field[row][column] = "*";
        }
    }

    public boolean isFree(int row, int column) {
        if (".".equals(gameField.field[row][column]) && (".".equals(field[row][column]) || "*".equals(field[row][column]))) {
            field[row][column] = processor.numberOfMinesAround(gameField.field, row, column);
            if ("0".equals(field[row][column])) {
                field[row][column] = "/";
                openAround(row, column);
            }
            return true;
        } else {
            return false;
        }
    }

    public void openAround(int row, int column) {
        if (utils.isCeiling(row) && utils.isLeft(column)) {
            isFree(row, column + 1);
            isFree(row + 1, column);
            isFree(row + 1, column + 1);
        } else if (utils.isCeiling(row) && utils.isRight(gameField.field, column)) {
            isFree(row, column - 1);
            isFree(row + 1, column);
            isFree(row + 1, column - 1);
        } else if (utils.isBottom(gameField.field, row) && utils.isRight(gameField.field, column)) {
            isFree(row, column - 1);
            isFree(row - 1, column);
            isFree(row - 1, column - 1);
        } else if (utils.isBottom(gameField.field, row) && utils.isLeft(column)) {
            isFree(row, column + 1);
            isFree(row - 1, column);
            isFree(row - 1, column + 1);
        } else if (utils.isBottom(gameField.field, row)) {
            for (int i = column - 1; i <= column + 1; i++) {
                isFree(row - 1, i);
            }
            isFree(row, column -1);
            isFree(row , column + 1);
        } else if (utils.isCeiling(row)) {
            for (int i = column - 1; i <= column + 1; i++) {
                isFree(row + 1, i);
            }
            isFree(row,column -1);
            isFree(row ,column + 1);
        } else if (utils.isRight(gameField.field, column)) {
            for (int i = row - 1; i <= row + 1; i++) {
                isFree(i, column - 1);
            }
            isFree(row + 1, column);
            isFree(row - 1, column);
        } else if (utils.isLeft(column)) {
            for (int i = row - 1; i <= row + 1; i++) {
                isFree(i, column + 1);
            }
            isFree(row + 1, column);
            isFree(row - 1, column);
        } else {
            for (int i = column - 1; i <= column + 1; i++) {
                isFree(row + 1, i);
                isFree(row - 1, i);
            }
            isFree(row,column - 1);
            isFree(row ,column + 1);
        }
    }

    public void generateLosesField() {
        for (int i = 0; i < gameField.height; i++) {
            for (int j = 0; j < gameField.width; j++) {
                if ("X".equals(gameField.field[i][j])) {
                    field[i][j] = "X";
                }
            }
        }
    }

    public boolean winWithOpeningAllMines() {
        if (gameField == null) {
            return false;
        }
        if (gameField.numberOfMines != numberOfMarkedMines()) {
            return false;
        } else {
            int count = 0;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[0].length; j++) {
                    if ("X".equals(gameField.field[i][j]) && "*".equals(field[i][j])) {
                        count++;
                    }
                }
            }
            if (count == gameField.numberOfMines) {
                return true;
            } else {
                return false;
            }
        }
    }

    private int numberOfMarkedMines() {
        int sum = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if ("*".equals(field[i][j])) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public boolean winWithOpeningAllFreeCells() {
        if (gameField == null) {
            return false;
        }
        boolean answer = false;
        int numberOfFreeCell = 81 - gameField.numberOfMines;
        int rightMarks = 0;
        if (numberOfMarkedFreeCell() != numberOfFreeCell) {
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (isFreeCell(i, j) && !("*".equals(field[i][j]) || ".".equals(field[i][j]))) {
                        rightMarks++;
                    }
                }
            }
        }
        if (rightMarks == numberOfFreeCell) {
            answer = true;
        }
        System.out.println("rightMarks = " + rightMarks);
        return answer;
    }



    public int numberOfMarkedFreeCell() {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!"*".equals(field[i][j]) && !".".equals(field[i][j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isFreeCell(int row, int column) {
        return !"X".equals(gameField.field[row][column]);
    }
}
