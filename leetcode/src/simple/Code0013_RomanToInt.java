package src.simple;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class Code0013_RomanToInt {
    public static void main(String[] args) {
//        String s = "III";
//        String s = "IV";
//        String s = "IX";
//        String s = "LVIII";
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));

    }
    public static int romanToInt(String s) {
        int res = 0;
        HashMap<String, Integer> basic = new HashMap<>();
        basic.put("I", 1);
        basic.put("V", 5);
        basic.put("X", 10);
        basic.put("L", 50);
        basic.put("C", 100);
        basic.put("D", 500);
        basic.put("M", 1000);

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            strings.add(s.substring(i, i + 1));
        }
        for (int i = 0; i < strings.size(); i++) {
            res += basic.get(strings.get(i));
            if (i > 0 && basic.get(strings.get(i - 1)) < basic.get(strings.get(i))) {
                res -= 2 * basic.get(strings.get(i - 1));
            }
        }
        return res;
    }
}
