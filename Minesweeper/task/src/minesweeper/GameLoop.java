package minesweeper;

import java.util.Scanner;

public class GameLoop {
    GameField gameField;
    FieldForUser fieldForUser;
    Scanner scanner = new Scanner(System.in);
    FieldPrinter printer = new FieldPrinter();
    String choice;

    public void loop() {
        System.out.print("How many mines do you want on the field? ");
        int numberOfMines = scanner.nextInt();
        scanner.nextLine();
        fieldForUser = new FieldForUser();
        printer.printWithFrame(fieldForUser.field);
        int row;
        int column;
        String command;
        boolean isGameEnd = false;

        while (!isGameEnd) {
            System.out.println("Set/unset mines marks or claim a cell as free: ");
            choice = scanner.nextLine();
            String[] massOfChoise = choice.split(" ");
            row = Integer.parseInt(massOfChoise[1]) - 1;
            column = Integer.parseInt(massOfChoise[0]) - 1;
            command = massOfChoise[2];

            switch (command) {
                case "free":
                    if (gameField == null) {
                        gameField = new GameField(numberOfMines, row, column);
                        fieldForUser.setGameField(gameField);
                    }
                    if (!fieldForUser.isFree(row, column)) {
                        fieldForUser.generateLosesField();
                        printer.printWithFrame(fieldForUser.field);
                        isGameEnd = true;
                        System.out.println("You stepped on a mine and failed!");
                    }
                    break;

                case "mine":
                    fieldForUser.markCellAsMine(row, column);
                    break;
            }
            if (fieldForUser.winWithOpeningAllMines()) {
                printer.printWithFrame(fieldForUser.field);
                System.out.println("Congratulations! You found all mines!");
                isGameEnd = true;
            }
            if (fieldForUser.winWithOpeningAllFreeCells()) {
                printer.printWithFrame(fieldForUser.field);
                System.out.println("Congratulations! You found all mines!");
                isGameEnd = true;
            }
            if (!isGameEnd) {
                printer.printWithFrame(fieldForUser.field);
            }
        }
    }


}
