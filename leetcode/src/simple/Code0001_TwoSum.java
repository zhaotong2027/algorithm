package simple;

public class Code0001_TwoSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{2,7,11,15};
//        int target = 9;
//        int[] nums = new int[]{3,2,4};
//        int target = 6;
        int[] nums = new int[]{3, 3};
        int target = 6;
        int[] res = twoSum(nums, target);
        System.out.println(res);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
