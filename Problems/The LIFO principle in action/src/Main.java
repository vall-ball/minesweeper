import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            stack.add(scanner.nextInt());
        }

        for (int i = 0; i < number; i++) {
            System.out.println(stack.pollLast());
        }
    }
}