package src.simple;

/**
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class OfferII068_SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7};
        int target = 4;
        System.out.println(searchInsert2(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target && target <= nums[i + 1]) {
                return i + 1;
            }
        }
        return target <= nums[0] ? 0 : nums.length;
    }

    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            System.out.println(left + "  " + right);
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
