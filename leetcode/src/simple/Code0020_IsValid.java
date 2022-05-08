package src.simple;

import java.util.ArrayList;
import java.util.HashMap;

public class Code0020_IsValid {
    public static void main(String[] args) {
//        String s = "()";
//        String s = "()[]{}";
//        String s = "(]";
//        String s = "([)]";
//        String s = "{[]}";
//        String s = "((";
//        String s = "({{{{}}}))";
        String s = "[[[]";
        System.out.println(s);
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (!(s.length() % 2 == 0)) {
            return false;
        }
        if (s.substring(s.length() - 1, s.length()).equals("(")) {
            return false;
        }
        if (s.substring(s.length() - 1, s.length()).equals("{")) {
            return false;
        }
        if (s.substring(s.length() - 1, s.length()).equals("[")) {
            return false;
        }

        HashMap<String, String> basics = new HashMap<>();
        basics.put("(", ")");
        basics.put("{", "}");
        basics.put("[", "]");

        ArrayList<String> filo = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (basics.containsKey(s.substring(i, i + 1))) {
                filo.add(basics.get(s.substring(i, i + 1)));
            } else if (basics.containsValue(s.substring(i, i + 1))) {
                if (filo.size() == 0) {
                    return false;
                }
                if (filo.get(filo.size()-1).equals(s.substring(i, i + 1))) {
                    filo.remove(filo.size()-1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (filo.size() == 0) {
            return true;
        }
        return false;
    }
    //  "))" 测试用例失败
//    public static boolean isValid(String s) {
//        if (s == null || s.length() == 0) {
//            return false;
//        } else if (!(s.length() % 2 == 0)) {
//            return false;
//        } else if (s.substring(s.length() - 1, s.length()).equals("(")) {
//            return false;
//        } else if (s.substring(s.length() - 1, s.length()).equals("{")) {
//            return false;
//        } else if (s.substring(s.length() - 1, s.length()).equals("[")) {
//            return false;
//        } else {
//            s = s.replace('(', ')');
//            s = s.replace('{', '}');
//            s = s.replace('[', ']');
//            System.out.println(s);
//            for (int i = 0; i <= s.length() / 2; i++) {
//                System.out.println(s.substring(i, i + 1));
//                System.out.println(s.substring(s.length() - i - 1, s.length() - i));
//                if (!s.substring(i, i + 1).equals(s.substring(s.length() - i - 1, s.length() - i))) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
}
