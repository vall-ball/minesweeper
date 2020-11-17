import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int n;
        for (int i = 0; i < number; i++) {
            n = scanner.nextInt();
            if (n % 2 == 0) {
                stack.offerFirst(n);
            } else {
                stack.offerLast(n);
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.println(stack.poll());
        }
    }
}