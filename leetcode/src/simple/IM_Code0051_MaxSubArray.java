package simple;

/**
 * 最大子数和 = 子数组 + 最大和 = 每个子数组
 * 动态递归计算每个值的最大值
 */
public class IM_Code0051_MaxSubArray {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-2, -1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int ans = nums[0];
        int[] dp = new int[nums.length];  // 数组中每个值都是从前面到该数组计算的最大值
        dp[0] = nums[0];
        System.out.println(0 + ":" + dp[0]);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            System.out.println(i + ":" + dp[i]);
            ans = ans > dp[i] ? ans : dp[i];
        }

        return ans;
    }
}
