import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Deque<String> stack = new ArrayDeque<>();
        String[] brackets = str.split("");
        boolean answer = true;
        for (String s : brackets) {
            if ("(".equals(s) || "{".equals(s) || "[".equals(s)) {
                stack.offerLast(s);
            } else if (")".equals(s) && !"(".equals(stack.pollLast())) {
                answer = false;
                break;
            } else if ("}".equals(s) && !"{".equals(stack.pollLast())) {
                answer = false;
                break;
            } else if ("]".equals(s) && !"[".equals(stack.pollLast())) {
                answer = false;
                break;
            }
        }
        if (stack.size() != 0) {
            answer = false;
        }
        System.out.println(answer);
    }
}