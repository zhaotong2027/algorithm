package simple;

public class Code0069_MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
    public static int mySqrt(int x) {
        return (int)mySqrt((long)x);
    }
    public static long mySqrt(long x) {
        long L = 1;
        long R = x;
        while (L <= R) {
            long mid = L + (R - L) /2;
            System.out.println(mid);
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return L - 1;
    }
}
