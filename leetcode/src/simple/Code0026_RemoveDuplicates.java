package simple;

public class Code0026_RemoveDuplicates {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = null;
        System.out.println(removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }

    // 优化，不够安全
    public static int removeDuplicates2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int len = 1;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
                len++;
            }
        }
        return len;
    }

//    public static void swap(int[] nums, int i) {
//        int tmp = nums[i];
//        for (int j = i; j + 1 < nums.length; j++) {
//            nums[j] = nums[j + 1];
//        }
//        nums[nums.length - 1] = tmp;
//    }
}
