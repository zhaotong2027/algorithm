package Class10_Sort;

public class Code01_Sort_Merge {
    public static void main(String[] args) {

    }

    // 调用递归
    public static void mergeSort(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        process(ints, 0, ints.length);
    }

    // ints[L...R]范围是，请让这个范围上的数有序
    public static void process(int[] ints, int L, int R) {
        if (L == R) {
            return;
        }
        // int mid = (L + R) / 2; L+R底标可能会越界，下面这种写法更安全
        int mid = L + (R - L) / 2;
        process(ints, L, mid);
        process(ints, mid + 1, R);
        merge(ints, L, mid, R);
    }

    // 合并排序
    public static void merge(int[] ints, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 < M && p2 < R) {
            help[i++] = ints[p1] <= ints[p2] ? ints[p1++] : ints[p2++];
        }
        while (p1 <= M) {
            help[i++] = ints[p1++];
        }
        while (p2 <= R) {
            help[i++] = ints[p2++];
        }
        for (i = 0; i < help.length; i++) {
            ints[L + i] = help[i];
        }
    }


}
