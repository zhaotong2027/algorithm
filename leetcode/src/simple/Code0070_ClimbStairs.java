package src.simple;

public class Code0070_ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] climbN = new int[n + 1];
        climbN[1] = 1;
        climbN[2] = 2;
        for (int i = 3; i <= n; i++) {
            climbN[i] = climbN[i - 1] + climbN[i - 2];
        }
        return climbN[n];
    }
}
