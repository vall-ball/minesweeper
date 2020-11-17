import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        if (val != null) {
            if (val > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (val < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else return val.intValue();
        } else {
            return 0;
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}