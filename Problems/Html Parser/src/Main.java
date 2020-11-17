import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strHTML = scanner.nextLine();
        List<String> list = massOfStr(strHTML);
        //System.out.println(list);

        List<String> childs = getChildren(strHTML);
        //ystem.out.println(childs);
        Deque<String> stack = new ArrayDeque<>();
        Deque<String> stack1 = read(strHTML, stack);
        //System.out.println(stack.size());
        while (!stack1.isEmpty()) {
            System.out.println(stack1.poll());
        }



    }

    private static List<String> massOfStr(String str) {
        List<String> list = new ArrayList<>();
        int position = 0;
        while (position < str.length()) {
            String el = findOneStr(str, position);
            position += el.length();
            list.add(el);
        }
        return list;
    }

    private static String findOneStr(String str, int position) {
        String[] mass = str.split("");
        StringBuilder builder = new StringBuilder();
        if ("<".equals(mass[position])) {
            while (!">".equals(mass[position])) {
                builder.append(mass[position]);
                position++;
            }
            builder.append(mass[position]);
            position++;
        } else {
            while (!"<".equals(mass[position])) {
                builder.append(mass[position]);
                position++;
            }
        }
        return builder.toString();
    }

    private static boolean isOpeningTag(String str) {
        char[] mass = str.toCharArray();
        if (mass.length >= 2) {
            if (mass[0] == '<' && mass[1] != '/') {
                return true;
            } else return false;
        } else return false;
    }

    private static String closingTag(String openingTag) {
        return "</" + openingTag.substring(1);
    }

    private static String contentOfTags(String str) {
        //System.out.println("str in contentOfTags = " + str);
        List<String> list = massOfStr(str);
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < list.size() - 1; i++) {
            answer.append(list.get(i));
        }
        return answer.toString();
    }

    private static String getOneChild(List<String> list, int index) {
        StringBuilder answer = new StringBuilder();
        String closingTag = closingTag(list.get(index));
        while (!list.get(index).equals(closingTag)) {
            answer.append(list.get(index));
            index++;
        }
        answer.append(closingTag);
        return answer.toString();
    }


    private static int length(List<String> list, int index) {
        int i = 0;
        String closingTag = closingTag(list.get(index));
        while (!list.get(index).equals(closingTag)) {
            i++;
            index++;
        }
        return i;
    }

    private static boolean hasChildren(String el) {
        String s =  contentOfTags(el);
        char[] mass = s.toCharArray();
        return mass[0] == '<';
    }

    private static List<String> getChildren(String el) {
        List<String> answer = new ArrayList<>();
        List<String> list = massOfStr(el);
        int i = 1;
        while (i < list.size() - 1){
            if (isOpeningTag(list.get(i))) {
                answer.add(getOneChild(list, i));
                i += length(list, i);
                i++;
            } else {
                answer.add(list.get(i));
                i++;
            }
        }
        return answer;
    }

    private static Deque<String> read(String strHTML, Deque<String> stack) {

        if (!hasChildren(strHTML)) {
            //System.out.println(strHTML + "has no Children");
            //System.out.println("добавляю " + strHTML);
            stack.add(contentOfTags(strHTML));
        } else {
            //System.out.println(strHTML + "has Children");
            //System.out.println("добавляю " + strHTML);
            //stack.offerLast(contentOfTags(strHTML));
            for (String s : getChildren(strHTML)) {
                read(s, stack);
            }
            //System.out.println("добавляю " + strHTML);
            stack.add(contentOfTags(strHTML));
        }
        return stack;
    }

}