package simple;

public class Code0035_SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int M = L + ((R - L) >> 1);
            if (nums[M] == target) {
                return M;
            } else if (nums[M] > target) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return L;
//        return process(nums, target, 0, nums.length-1);
    }

    // 数组中存在的可以找出来
    public static int process(int[] nums, int target, int left, int right) {
        while (left <= right) {  // 左标可能比右大，处于遍历到最大值依然比 target 小的情况
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {  // 开区间
                right = mid - 1;
            } else {  // 闭区间
                left = mid + 1;
            }
        }
        return left;
    }
}
