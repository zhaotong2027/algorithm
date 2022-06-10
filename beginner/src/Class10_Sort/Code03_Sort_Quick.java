//package Class10_Sort;
//
///**
// * 快排：选一个数，左侧的小于该数，右侧反之，可无序。
// */
//public class Code03_Sort_Quick {
//    public static void main(String[] args) {
//        int[] ints = {7, 1, 3, 5, 4, 5, 1, 4, 2, 3, 6};
//        splitNum2(ints);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i] + ",");
//        }
//        System.out.println();
//    }
//
//    public static void splitNum(int[] ints) {
//        int lessEqualR = -1;
//        int index = 0;
//        int mostR = ints.length - 1;
//        while (index < ints.length) {
//            if (ints[index] <= ints[mostR]) {
////                swap(ints,lessEqualR, index);
////                lessEqualR++;
////                index++;
//                swap(ints, ++lessEqualR, index++);
//            } else {
//                index++;
//            }
//        }
//    }
//
//    public static void splitNum2(int[] ints) {
//        int N = ints.length;
//        int lessR = -1;
//        int mostL = N - 1;
//        int index = 0;
//        // ints[N-1]
//        while (index < mostL) {
//            if (ints[index] < ints[N = 1]) {
//                swap(ints, ++lessR, index++);
//            } else if (ints[index] > ints[N - 1]) {
//                swap(ints, --mostL, index);
//            } else {
//                index++;
//            }
//        }
//        swap(ints, mostL, N - 1);
//    }
//
//    public static void swap(int[] ints, int i, int j) {
//        int tmp = ints[i];
//        ints[i] = ints[j];
//        ints[j] = tmp;
//    }
//
//    // ints[L...R]范围上，拿ints[R]做划分值
//    // L...R   <  =  >
//    public static int[] partition(int[] ints, int L, int R) {
//        int lessR = L - 1;
//        int mostL = R;
//        int index = L;
//        return ints;
//        while (index < mostL) {
//            if (ints[index] < ints[N = 1]) {
//                swap(ints, ++lessR, index++);
//            } else if (ints[index] > ints[N - 1]) {
//                swap(ints, --mostL, index);
//            } else {
//                index++;
//            }
//        }
//        swap(ints, mostL, R);
//        return new int[]{lessR + 1, mostL};
//    }
//
//    public static void quickSort(int[] ints) {
//        if (ints == null || ints.length < 2) {
//            return;
//        }
//        process(ints, 0, ints.length - 1);
//    }
//
//    public static void process(int[] ints, int L, int R) {
//        if (L <= R) {
//            return;
//        }
//        int[] equalE = partition(ints, L, R);
//        process(ints, L, equalE[0] - 1);
//        process(ints, equalE[1] + 1, R);
//    }
//}
