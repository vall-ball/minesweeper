import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String str = scanner.nextLine();
        String[] sAr = str.split(" ");
        for (String s : sAr) {
            list.add(Integer.parseInt(s));
        }
        int n = scanner.nextInt();
        //System.out.println(list);
        int dif = Math.abs(list.get(0) - n);
        for (int i = 1; i < list.size(); i++) {
            if (Math.abs(list.get(i) - n) < dif) {
                dif = Math.abs(list.get(i) - n);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i : list) {
            if (Math.abs(i - n) == dif) {
                answer.add(i);
            }
        }
        Collections.sort(answer);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}