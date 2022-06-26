package simple;

import java.util.Arrays;

public class Code0136_SingleNumber {
    public static void main(String[] args) {
//        int[] nums = {2, 2, 1};
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber2(nums));

    }

    // 优化
    public static int singleNumber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int an = nums[nums.length - 1];
        for (int i = 0; i + 1 < nums.length; i += 2) {
            System.out.println(i);
            if (nums[i] != nums[i + 1]) {
                System.out.println("=====");
                an = nums[i];
                break;
            }
        }
        return an;
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isHave(nums, i)) {
                return nums[i];
            }
        }
        return nums[0];  // 逻辑赘余，应改为break的形式
    }

    public static boolean isHave(int[] nums, int i) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] == nums[j] && i != j) {
                return true;
            }
        }
        return false;
    }
}
