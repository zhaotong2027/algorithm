package Class10_Sort;

public class Code02_Sort_Merge2 {

    public static void merge2(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        int step = 1;
        int N = ints.length;

        while (step < N) {
            int L = 0;
            while (L < N) {
                int M = 0;
                if (N - L >= step) {
                    M = L + step - 1;
                } else {
                    M = N - 1;
                }
                M = Math.min(N - 1, L + step - 1);

                // L...M
                if (M == N - 1) {
                    break;
                }
                int R = 0;
                if (N - 1 - M >= step) {
                    R = M + step;
                } else {
                    R = N - 1;
                }

                // L...M M+1...R
                merge(ints, L, M, R);
                if (R == N - 1) {
                    break;
                } else {
                    L = R + 1;
                }
            }

            if (step > (N / 2)) {
                break;
            }
            step *= 2;
        }
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
