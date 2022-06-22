package simple;

public class Code0121_MaxProfit {
    public static void main(String[] args) {
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int an = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                max = prices[i];
            }
            max = max > prices[i] ? max : prices[i];
            an = max - min < an ? an : max - min;
        }
        System.out.println(min);
        System.out.println(max);
        return an;
    }
}
