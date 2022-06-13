package src.simple;

public class Code0027_RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums = {3,2,2,3};
        int val = 2;
        System.out.println(removeElement3(nums, val));

        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }

    // 再优化
    public static int removeElement3(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    // 优化
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return nums.length;
        }
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }

}
