import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = scanner.nextInt();
        scanner.nextLine();
        //System.out.println("numberOfCommands = " + numberOfCommands);
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stackOfMax = new ArrayDeque<>();
        Deque<Integer> stackOfMaxRequest = new ArrayDeque<>();
        int number;

        for (int i = 0; i < numberOfCommands; i++) {
            //System.out.println("i= " + i);
            String command = scanner.nextLine();
            String[] arrOfCom = command.split(" ");
            //System.out.println(arrOfCom[0]);


            switch (arrOfCom[0]) {
                case "push":
                    number = Integer.parseInt(arrOfCom[1]);
                    if (stackOfMax.isEmpty()) {
                        stackOfMax.push(number);
                    } else if (number >= stackOfMax.getFirst()) {
                        stackOfMax.push(number);
                    }
                    stack.push(number);
                    break;
                case "max":
                    stackOfMaxRequest.push(stackOfMax.getFirst());
                    break;
                case "pop":
                    number = stack.pop();
                    if (!stackOfMax.isEmpty() && stackOfMax.getFirst() == number) {
                        stackOfMax.pop();
                    }
                    break;
                default:
                    break;
            }



        }
        while (!stackOfMaxRequest.isEmpty()) {
            System.out.println(stackOfMaxRequest.pollLast());
        }
    }
}