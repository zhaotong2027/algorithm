package src.simple;

public class Code0028_StrStr {
    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.length() > haystack.length() - i) {
                return -1;
            }
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }
        return -1;
    }
}
