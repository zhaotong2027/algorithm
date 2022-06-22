package simple;

public class Code0125_IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if (!s.substring(i, i + 1).equals(s.substring(s.length() - i - 1, s.length() - i))) {
                return false;
            }
        }
        return true;
    }
}
