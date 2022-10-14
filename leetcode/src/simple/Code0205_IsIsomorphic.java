package simple;

public class Code0205_IsIsomorphic {
    public static void main(String[] args) {
//        boolean result = isIsomorphic("add", "egg");
        boolean result = isIsomorphic("foo", "bar");
        System.out.println();
        System.out.println(result);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int index = 0;
        while (index < s.length()) {
            int i = s.indexOf(s.substring(index, index + 1), 0);
            int j = t.indexOf(t.substring(index, index + 1), 0);
            if (i != j) {
                return false;
            }
            index++;
        }
        return true;
    }
}
