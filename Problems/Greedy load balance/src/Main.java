import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTask = scanner.nextInt();

        Queue<Integer> firstQueue = new ArrayDeque<>();
        Queue<Integer> secondQueue = new ArrayDeque<>();
        int loadOfFirstQueue = 0;
        int loadOfSecondQueue = 0;
        int id;
        int load;
        for (int i = 0; i < numberOfTask; i++) {
            id = scanner.nextInt();
            load = scanner.nextInt();
            if (loadOfSecondQueue < loadOfFirstQueue) {
                secondQueue.add(id);
                loadOfSecondQueue += load;
            } else {
                firstQueue.add(id);
                loadOfFirstQueue += load;
            }
        }
        while (!firstQueue.isEmpty()) {
            System.out.print(firstQueue.poll() + " ");
        }
        System.out.println();
        while (!secondQueue.isEmpty()) {
            System.out.print(secondQueue.poll() + " ");
        }
    }
}