package simple;

public class Code0202_IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        return process(20, n);
    }

    public static boolean process(int count, int n) {
        boolean an = false;
        int a = 0;
        while (n >= 1) {
            int y = n % 10;
            n -= y;
            n /= 10;
            a = a + y * y;
        }
        if (count == 0 && a != 1) {
            return false;
        }
        if (a < 1000) {
            count--;
        }
        System.out.println(a + " " + count);
        return a == 1 ? true : process(count, a);
    }
}
