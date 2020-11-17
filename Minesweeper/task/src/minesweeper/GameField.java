package minesweeper;

public class GameField {
    String[][] field;
    int height = 9;
    int width = 9;
    int numberOfMines;
    FieldProcessor processor = new FieldProcessor();
    FieldGenerator generator = new FieldGenerator();

    GameField(int numberOfMines, int row, int column) {
        this.numberOfMines = numberOfMines;
        field = generator.generate(height, width, numberOfMines, row, column);

    }



}
