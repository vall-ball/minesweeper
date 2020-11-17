package minesweeper;

public class FieldPrinter {

    public void printWithFrame(String[][] field) {
        System.out.print(" |");
        for (int i = 1; i <= field.length; i++) {
            System.out.print(i);
        }
        System.out.print("|");
        System.out.println();

        System.out.print("-|");
        for (int i = 0; i < field[0].length; i++) {
            System.out.print("-");
        }
        System.out.print("|");
        System.out.println();

        for (int i = 0; i < field.length; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }

        System.out.print("-|");
        for (int i = 0; i < field.length; i++) {
            System.out.print("-");
        }
        System.out.print("|");

        System.out.println();
    }

}
