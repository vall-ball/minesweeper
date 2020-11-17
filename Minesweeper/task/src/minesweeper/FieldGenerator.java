package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class FieldGenerator {
    Random random = new Random();


   public String[][] generate(int height, int width, int numberOfMines, int xCoor, int yCoor) {
        String[][] field = new String[height][width];
        if (numberOfMines == 0) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                        field[i][j] = ".";
                    }
                }
        } else {
            int[] coordinatesOfMines = massOfRandomNumber(numberOfMines, height * width);
            Arrays.sort(coordinatesOfMines);
            int index = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!checkCoordinates(i, j, xCoor, yCoor) && index < coordinatesOfMines.length && i == coordinatesOfMines[index] / height && j == (coordinatesOfMines[index] % width)) {
                        field[i][j] = "X";
                        index++;
                    } else {
                        field[i][j] = ".";
                    }
                }
            }
        }

            return field;

    }

    private int[] massOfRandomNumber(int numberOfMines, int numberOfCells) {
        int[] mass = new int[numberOfMines];
        mass[0] = random.nextInt(numberOfCells);
        for (int i = 1; i < numberOfMines; i++) {
           mass[i] = random.nextInt(numberOfCells);
           while (searchDouble(Arrays.copyOf(mass, i),  mass[i])) {
               mass[i] = random.nextInt(numberOfCells);
           }
        }
        return mass;
    }

    private boolean searchDouble(int[] array, int number) {
        boolean answer = false;
        for (int n : array) {
            if (n == number) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    private boolean checkCoordinates(int i, int j, int row, int columm) {
       return i == row && j == columm;
    }
}
