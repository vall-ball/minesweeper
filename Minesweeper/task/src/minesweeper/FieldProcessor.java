package minesweeper;

public class FieldProcessor {
    FieldUtils utils = new FieldUtils();

    public String numberOfMinesAround(String[][] field, int row, int column) {
        String answer;

        if (utils.isCeiling(row) && utils.isLeft(column)) {
            answer = Integer.toString(countForLeftUpCorner(field));
        } else if (utils.isCeiling(row) && utils.isRight(field, column)) {
            answer = Integer.toString(countForRightUpCorner(field));
        } else if (utils.isBottom(field, row) && utils.isRight(field, column)) {
            answer = Integer.toString(countForRightDownCorner(field));
        } else if (utils.isBottom(field, row) && utils.isLeft(column)) {
            answer = Integer.toString(countForLeftDownCorner(field));
        } else if (utils.isBottom(field, row)) {
            answer = Integer.toString(countForBottom(field, column));
        } else if (utils.isCeiling(row)) {
            answer = Integer.toString(countForCeiling(field, column));
        } else if (utils.isRight(field, column)) {
            answer = Integer.toString(countForRight(field, row));
        } else if (utils.isLeft(column)) {
            answer = Integer.toString(countForLeft(field, row));
        } else {
            answer = Integer.toString(countForCenter(field, row, column));
        }
        return answer;
    }

    private int countForLeftUpCorner(String[][] field) {
        int sum = 0;
        if ("X".equals(field[0][1])) {
            sum++;
        }
        if ("X".equals(field[1][0])) {
            sum++;
        }
        if ("X".equals(field[1][1])) {
            sum++;
        }
        return sum;
    }

    private int countForLeftDownCorner(String[][] field) {
        int sum = 0;
        if ("X".equals(field[field.length - 1][1])) {
            sum++;
        }
        if ("X".equals(field[field.length - 2][0])) {
            sum++;
        }
        if ("X".equals(field[field.length - 2][1])) {
            sum++;
        }
        return sum;
    }

    private int countForRightDownCorner(String[][] field) {
        int sum = 0;
        if ("X".equals(field[field.length - 1][field[0].length - 2])) {
            sum++;
        }
        if ("X".equals(field[field.length - 2][field[0].length - 1])) {
            sum++;
        }
        if ("X".equals(field[field.length - 2][field[0].length - 2])) {
            sum++;
        }
        return sum;
    }

    private int countForRightUpCorner(String[][] field) {
        int sum = 0;
        if ("X".equals(field[0][field[0].length - 2])) {
            sum++;
        }
        if ("X".equals(field[1][field[0].length - 1])) {
            sum++;
        }
        if ("X".equals(field[1][field[0].length - 2])) {
            sum++;
        }
        return sum;
    }

    private int countForBottom(String[][] field, int column) {
        int sum = 0;
        for (int i = column - 1; i <= column + 1; i++) {
            if ("X".equals(field[field.length - 2][i])) {
                sum++;
            }
        }
        if ("X".equals(field[field.length - 1][column - 1])) {
            sum++;
        }
        if ("X".equals(field[field.length - 1][column + 1])) {
            sum++;
        }
        return sum;
    }

    private int countForCeiling(String[][] field, int column) {
        int sum = 0;
        for (int i = column - 1; i <= column + 1; i++) {
            if ("X".equals(field[1][i])) {
                sum++;
            }
        }
        if ("X".equals(field[0][column - 1])) {
            sum++;
        }
        if ("X".equals(field[0][column + 1])) {
            sum++;
        }
        return sum;
    }

    private int countForLeft(String[][] field, int row) {
        int sum = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            if ("X".equals(field[i][1])) {
                sum++;
            }
        }
        if ("X".equals(field[row - 1][0])) {
            sum++;
        }
        if ("X".equals(field[row + 1][0])) {
            sum++;
        }
        return sum;
    }

    private int countForRight(String[][] field, int row) {
        int sum = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            if ("X".equals(field[i][field.length - 2])) {
                sum++;
            }
        }
        if ("X".equals(field[row - 1][field.length - 1])) {
            sum++;
        }
        if ("X".equals(field[row + 1][field.length - 1])) {
            sum++;
        }
        return sum;
    }

    private int countForCenter(String[][] field, int row, int column) {
        int sum = 0;
        for (int i = row - 1; i <= row + 1; i++) {
                if ("X".equals(field[i][column - 1])) {
                    sum++;
                }
                if ("X".equals(field[i][column + 1])) {
                    sum++;
                }
        }
        if ("X".equals(field[row - 1][column])) {
            sum++;
        }
        if ("X".equals(field[row + 1][column])) {
            sum++;
        }
        return sum;
    }

}
