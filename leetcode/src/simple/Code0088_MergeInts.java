package simple;

public class Code0088_MergeInts {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;

//        int[] nums1 = {1};
//        m = 1;
//        int[] nums2 = {};
//        n = 0;
//        int[] nums1 = {2,0};
//        m = 1;
//        int[] nums2 = {1};
//        n = 1;

        int[] nums1 = {0, 0, 3, 0, 0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {-1, 1, 1, 1, 2, 3};
        int n = 6;

        merge2(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }

    // 优化
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (nums1[m - 1] == nums2[n - 1]) {
            nums1[m + n - 1] = nums1[m - 1];
            nums1[m + n - 2] = nums2[n - 1];
            merge2(nums1, --m, nums2, --n);
        } else if (nums1[m - 1] > nums2[n - 1]) {
            nums1[m + n - 1] = nums1[m - 1];
            merge2(nums1, --m, nums2, n);
        } else {
            nums1[m + n - 1] = nums2[n - 1];
            merge2(nums1, m, nums2, --n);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
//            nums1 = nums2.clone();
            return;
        }
        while (m > 0 || n > 0) {
            if (n == 0) {
                return;
            }
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
            if (nums1[m - 1] == nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            } else if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
    }

//    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
//        if (nums2 == null || n == 0) {
//            return nums1;
//        }
//        if (nums1.length - n == 0) {
//            nums1 = nums2.clone();
//            return nums1;
//        }
//        while (m > 0 && n > 0) {
//            if (nums1[m - 1] == nums2[n - 1]) {
//                nums1[m + n - 1] = nums1[m - 1];
//                m--;
//                nums1[m + n - 1] = nums2[n - 1];
//                n--;
//            } else if (nums1[m - 1] > nums2[n - 1]) {
//                nums1[m + n - 1] = nums1[m - 1];
//                m--;
//            } else {
//                nums1[m + n - 1] = nums2[n - 1];
//                n--;
//            }
//        }
//        return nums1;
//    }
}
