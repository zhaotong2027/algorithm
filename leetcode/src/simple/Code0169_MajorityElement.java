package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code0169_MajorityElement {

    // 优化
    public static int majorityElement3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int an = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != an) {
                an = nums[i];
                count = 0;
            }
            count++;
            if (count > nums.length / 2) {
                return an;
            }
        }
        return an;
    }

    // 优化
    public static int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int maxLen = 0;
        int an = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != an) {
                an = nums[i];
                count = 0;
            }
            if (nums[i] == an) {
                count++;
            }
            maxLen = maxLen > count ? maxLen : count;
            if (maxLen > nums.length / 2) {
                return an;
            }
        }
        return an;
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int maxLen = 0;
        int an = nums[0];
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != an) {
                an = nums[i];
                list = new ArrayList();
            }
            if (nums[i] == an) {
                list.add(an);
            }
            maxLen = maxLen > list.size() ? maxLen : list.size();
            if (maxLen > nums.length / 2) {
                return an;
            }
        }

        return an;
    }
}
