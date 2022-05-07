package Class03;

import java.util.ArrayList;

import static Class01.Code05_Sort_Insert.insertSort4;

/**
 * 有序数组中找到num：二分法
 */
public class Code01_Dichotomy {
    public static void main(String[] args) {
//        ArrayList<Integer> ints = new ArrayList<Integer>();
//        ints.add(150);
//        ints.add(12);
//        ints.add(167);
//        ints.add(136);
//        ints.add(130);
//        ints.add(130);
//        ints.add(137);
//        ints.add(60);
//        ints.add(171);

        // 排序
//        ArrayList<Integer> sortInts = insertSort4(ints);
//        System.out.println(sortInts.toString());
        // 找数
//        System.out.println(mostRightLessNumIndex(sortInts, 5));

//        ArrayList<Integer> ints = randomdiffInts(9, 5);
//        System.out.println(ints.toString());
////        [4, 1, 3, 0, 3]
//        int minIndex = oneMinIndex(ints);
//        System.out.println(minIndex);
//        System.out.println(testOneMinIndex(ints, minIndex));

        int maxLen = 20;
        int maxValue = 200;
        int times = 10000;
        for (int i = 0; i < times; i++ ) {
            ArrayList<Integer> ints = randomdiffInts(maxLen, maxValue);
//                [150, 12, 167, 136, 130, 130, 137, 60, 171]
            int minIndex = oneMinIndex(ints);
            if (!testOneMinIndex(ints, minIndex)) {
                System.out.println(ints.toString());
            }
        }

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

    // 无序数组找局部最小（相邻不相等）
    // 必存在局部最小，mid比左小，也比右小，返回mid；↘...↗️️必右最小
    public static int oneMinIndex(ArrayList<Integer> ints) {
        if (ints == null || ints.size() == 0) {
            return -1;
        }

        int N = ints.size();
        if (N == 1) {
            return 0;
        }
        if (N == 2) { // 直接去掉这个条件，则数组长度为2时，下个条件显示越界
            return ints.get(0) < ints.get(1) ? 0 : 1;
        }
        if (ints.get(N - 1) < ints.get(N - 2)) {
            return N-1;
        }
        int L = 0;
        int R = N-1;
        // mid-1 > mid < mid+1  mid✅
        // mid-1 < mid < mid+1  R✅
        // mid-1 < mid > mid+1  L or R✅
        // mid-1 > mid > mid+1  L✅
        // TODO: 2022/5/7 保证二分的至少是三个数，以解决越界问题
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (ints.get(mid - 1) > ints.get(mid) && ints.get(mid) < ints.get(mid + 1)) {
                return mid;
            } else {
                if (ints.get(mid - 1) < ints.get(mid)) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
//            if (sortInts.get(mid - 1) < sortInts.get(mid)) {
//                R = mid - 1;
//                continue;
//            }
//            if (sortInts.get(mid) > sortInts.get(mid + 1)) {
//                L = mid + 1;
//                continue;
//            }
        }
        return ints.get(L) < ints.get(R) ? L : R;
    }

    // 生产不相邻随机长度数值数组，不可超过最大值最大长度
    public static ArrayList<Integer> randomdiffInts(int maxLen, int maxValue) {
        int size = (int)(Math.random() * maxLen);
        ArrayList<Integer> ints = new ArrayList<>(size);
        if (size > 0) {
            ints.add(0, (int)(Math.random()*maxValue));
            for (int i = 1; i < size; i++) {
                ints.add(i, (int)(Math.random()*maxValue));
//                do {
//                    ints.set(i, (int)(Math.random()*maxValue));
//                } while (ints.get(i) == ints.get(i - 1));
                do {
                    ints.set(i, (int)(Math.random()*maxValue));
                } while (ints.get(i).equals(ints.get(i - 1)));
            }
        }
        return ints;
    }

    // 验证
    public static boolean testOneMinIndex(ArrayList<Integer> sortInts, int minIndex) {
        if (sortInts.size() == 0) {
            return true;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? sortInts.get(left) > sortInts.get(minIndex) : true;
        boolean rightBigger = right < sortInts.size() ? sortInts.get(minIndex) < sortInts.get(right) : true;
        return leftBigger && rightBigger;
    }
}
