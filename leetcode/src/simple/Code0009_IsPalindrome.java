package src.simple;

public class Code0009_IsPalindrome {
    public static void main(String[] args) {
//        int x = 121;
//        int x = -121;
        int x = 10;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        String xS = String.valueOf(x);

        for (int i = 0; i < xS.length() - i; i++) {
            if (!xS.substring(i, i + 1).equals(xS.substring(xS.length() - i - 1, xS.length() - i))) {
                return false;
            }
        }
        return true;
    }
}