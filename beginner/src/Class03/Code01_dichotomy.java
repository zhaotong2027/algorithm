package Class03;

import java.util.ArrayList;

import static Class01.Code05_Sort_Insert.insertSort4;

/**
 * 有序数组中找到num：二分法
 */
public class Code01_dichotomy {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(77);
        ints.add(8);
        ints.add(5);
        ints.add(2);
        ints.add(2);
        ints.add(37);
        ints.add(4);
        ints.add(19);

        // 排序
        ArrayList<Integer> sortInts = insertSort4(ints);
        System.out.println(sortInts.toString());

        // 找数
        System.out.println(mostRightLessNumIndex(sortInts, 5));
    }

    // 有序数组找num
    public static int findNum(ArrayList<Integer> sortInts, Integer num) {
        if (sortInts == null || sortInts.size() == 0) {
            return -1;
        }
        int L = 0;
        int R = sortInts.size();
        while (L <= R) {
            int mid = (L + R) / 2;
            if (sortInts.get(mid) == num) {
                return mid;
            } else if (sortInts.get(mid) < num) {
                L = mid + 1;
            } else if (sortInts.get(mid) > num) {
                R = mid - 1;
            }
        }
        return -1;
    }

    // 有序数组找>=num的范围（最左值）
    public static int mostLeftNotLessNumIndex(ArrayList<Integer> sortInts, Integer num) {
        if (sortInts == null || sortInts.size() == 0) {
            return -1;
        }
        int L = 0;
        int R = sortInts.size() - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (sortInts.get(mid) >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    // 有序数组找<=num的范围（最右值）
    public static int mostRightLessNumIndex(ArrayList<Integer> sortInts, Integer num) {
        if (sortInts == null || sortInts.size() == 0) {
            return -1;
        }
        int L = 0;
        int R = sortInts.size() - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (sortInts.get(mid) <= num) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    // 无序数组找局部最小（相邻不想等）

}
